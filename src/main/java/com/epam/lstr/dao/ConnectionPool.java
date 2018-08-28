package com.epam.lstr.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static String PASHA_SERVER = "176.57.220.5";
    private static String EPAM_SERVER = "10.6.198.142";

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = String.format("jdbc:postgresql://%s:5432/postgres", PASHA_SERVER);

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {

        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        config.setJdbcUrl(DB_URL);
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
