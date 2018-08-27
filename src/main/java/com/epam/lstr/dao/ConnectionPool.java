package com.epam.lstr.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Cleanup;
import lombok.val;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

    private static final String CREATE_USERS_SQL = "CREATE TABLE users (user_id IDENTITY, login varchar not null, password varchar, role enum('manager','customer'))";
    private static final String CREATE_TOURS_SQL = "CREATE TABLE tours (tour_id IDENTITY, name varchar, price int, hot boolean, discount int)";
    private static final String CREATE_ORDERS_SQL = "CREATE TABLE orders (order_id IDENTITY, customer_id int, tour_id int, paid boolean)";
    private static final String CREATE_CUSTOMERS_SQL = "CREATE TABLE customers (customer_id IDENTITY, name varchar, surname varchar, vip boolean, user_id int)";

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(DB_URL);
        config.setUsername("");
        config.setPassword("");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);

        try {
            @Cleanup val connection = DriverManager.getConnection(DB_URL);
            @Cleanup val statement = connection.createStatement();
            statement.executeUpdate(CREATE_USERS_SQL);
            statement.executeUpdate(CREATE_TOURS_SQL);
            statement.executeUpdate(CREATE_CUSTOMERS_SQL);
            statement.executeUpdate(CREATE_ORDERS_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private ConnectionPool() {
    }
}
