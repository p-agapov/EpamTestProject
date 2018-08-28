package com.epam.lstr.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class ConnectionPool {
    private static String PASHA_SERVER = "176.57.220.5";
    private static String EPAM_SERVER = "10.6.198.142";

    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    private static final String POSTRGES_URL = String.format("jdbc:postgresql://%s:5432/postgres", PASHA_SERVER);
    private static final String H2_DRIVER = "org.h2.Driver";
    private static final String H2_URL = "jdbc:h2:mem:test;";


    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {

        try {
            Class.forName(POSTGRES_DRIVER).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        config.setJdbcUrl(POSTRGES_URL);
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    @SneakyThrows
    public static void setTestDB() {
        Class.forName(H2_DRIVER).newInstance();
        config.setJdbcUrl(H2_URL);
        config.setUsername("");
        config.setPassword("");
        ds = new HikariDataSource(config);

        Properties props = new Properties();
        props.load(ConnectionPool.class.getResourceAsStream("/testInit.properties"));

        @Cleanup val connection = ds.getConnection();
        for (Map.Entry entry :
                props.entrySet()) {
            connection.prepareStatement((String) entry.getValue())
                    .executeUpdate();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
