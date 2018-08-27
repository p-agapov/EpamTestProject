package com.epam.lstr.dao;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private static String PASHA_SERVER = "agapovp.com";
    private static String EPAM_SERVER = "10.6.198.142";

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = String.format("jdbc:postgresql://%s:5432/postgres", PASHA_SERVER);

    private static final String CREATE_USERS_SQL = "CREATE TABLE IF NOT EXISTS users (user_id INT, login varchar not null, password varchar, role enum('manager','customer'))";
    private static final String CREATE_TOURS_SQL = "CREATE TABLE IF NOT EXISTS tours (tour_id IDENTITY, name varchar, price int, hot boolean, discount int)";
    private static final String CREATE_ORDERS_SQL = "CREATE TABLE IF NOT EXISTS orders (order_id IDENTITY, customer_id int, tour_id int, paid boolean)";
    private static final String CREATE_CUSTOMERS_SQL = "CREATE TABLE IF NOT EXISTS customers (customer_id IDENTITY, name varchar, surname varchar, vip boolean, user_id int)";
    private static final String INSERT_MANAGER_SQL = "INSERT INTO users (login, password, role)\n" +
            "VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'manager')";
    private static Connector connector;

    private Connector() {
//        init();
    }

    public static Connector getConnector() {
        if (connector == null)
            connector = new Connector();
        return connector;
    }

    @SneakyThrows
    public Connection getConnection() {
        return DriverManager.getConnection(DB_URL, "postgres", "postgres");
    }

    @SneakyThrows
    private void init() {
        Class.forName(JDBC_DRIVER).newInstance();
        @Cleanup val connection = DriverManager.getConnection(DB_URL, "postgres", "postgres");
        @Cleanup val statement = connection.createStatement();
        statement.executeUpdate(CREATE_USERS_SQL);
        statement.executeUpdate(CREATE_TOURS_SQL);
        statement.executeUpdate(CREATE_CUSTOMERS_SQL);
        statement.executeUpdate(CREATE_ORDERS_SQL);
        statement.executeUpdate(INSERT_MANAGER_SQL);

    }
}
