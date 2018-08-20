package com.epam.lstr.dao;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

    private static final String CREATE_USERS_SQL = "CREATE TABLE users (user_id IDENTITY, login varchar not null, password varchar, role enum('manager','customer'))";
    private static final String CREATE_TOURS_SQL = "CREATE TABLE tours (tour_id IDENTITY, name varchar, price int, hot boolean, discount int)";
    private static final String CREATE_ORDERS_SQL = "CREATE TABLE orders (order_id IDENTITY, customer_id int, tour_id int, paid boolean)";
    private static final String CREATE_CUSTOMERS_SQL = "CREATE TABLE customers (customer_id IDENTITY, name varchar, surname varchar, vip boolean, user_id int)";

    private static Connector connector;

    private Connector() {
        init();
    }

    public static Connector getConnector() {
        if (connector == null)
            connector = new Connector();
        return connector;
    }

    @SneakyThrows
    public Connection getConnection() {
        return DriverManager.getConnection(DB_URL);
    }

    @SneakyThrows
    private void init() {
        @Cleanup val connection = DriverManager.getConnection(DB_URL);
        val statement = connection.createStatement();
        statement.executeUpdate(CREATE_USERS_SQL);
        statement.executeUpdate(CREATE_TOURS_SQL);
        statement.executeUpdate(CREATE_CUSTOMERS_SQL);
        statement.executeUpdate(CREATE_ORDERS_SQL);

    }
}
