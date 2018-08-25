package com.epam.lstr.dao.impl;

import com.epam.lstr.dao.Connector;
import com.epam.lstr.dao.OrderDao;
import com.epam.lstr.model.Order;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class OrderDaoImpl implements OrderDao {


    private Connector connector = Connector.getConnector();

    private static final String INSERT_SQL = "INSERT INTO orders (customer_id, tour_id, paid) VALUES (?, ?, ?)";
    private static final String GET_ALL_SQL = "SELECT order_id, customer_id, tour_id, paid FROM orders";
    private static final String GET_BY_CUSTOMER_SQL = "SELECT order_id, customer_id, tour_id, paid FROM orders WHERE customer_id = ?";
    private static final String GET_ONE_SQL = "SELECT order_id, customer_id, tour_id, paid FROM orders WHERE order_id = ?";
    private static final String DELETE_ALL_SQL = "DELETE FROM orders";
    private static final String DELETE_ONE_SQL = "DELETE FROM orders WHERE order_id = ?";
    private static final String UPDATE_SQL = "UPDATE orders SET customer_id = ?, tour_id = ?, paid = ? WHERE order_id = ?";
    private static final String COUNT_SQL = "SELECT COUNT(order_id) FROM orders";

    private static final String ID_FIELD = "order_id";
    private static final String CUSTOMER_FIELD = "customer_id";
    private static final String TOUR_FIELD = "tour_id";
    private static final String PAID_FIELD = "paid";


    @Override
    @SneakyThrows
    public Order add(Order order) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val ps = connection.prepareStatement(INSERT_SQL, RETURN_GENERATED_KEYS);

        ps.setString(1, String.valueOf(order.getCustomerId()));
        ps.setString(2, String.valueOf(order.getTourId()));
        ps.setString(3, String.valueOf(order.isPaid()));

        ps.executeUpdate();

        @Cleanup val rs = ps.getGeneratedKeys();
        if (!rs.next())
            throw new RuntimeException("The key has not been generated!");

        order.setOrderId(rs.getInt(1));
        return order;
    }

    @Override
    @SneakyThrows
    public List<Order> getAll() {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val rs = statement.executeQuery(GET_ALL_SQL);

        List<Order> orders = new ArrayList<>();

        while (rs.next()) {
            orders.add(new Order(rs.getInt(ID_FIELD),
                    rs.getInt(CUSTOMER_FIELD),
                    rs.getInt(TOUR_FIELD),
                    rs.getBoolean(PAID_FIELD)));
        }

        return orders;
    }

    @Override
    @SneakyThrows
    public Order getById(int orderId) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val ps = connection.prepareStatement(GET_ONE_SQL);
        ps.setInt(1, orderId);
        @Cleanup val rs = ps.executeQuery();


        return rs.next() ?
                new Order(rs.getInt(ID_FIELD),
                        rs.getInt(CUSTOMER_FIELD),
                        rs.getInt(TOUR_FIELD),
                        rs.getBoolean(PAID_FIELD))
                : null;
    }

    @SneakyThrows
    @Override
    public List<Order> getByCustId(int customerId) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val ps = connection.prepareStatement(GET_BY_CUSTOMER_SQL);
        ps.setLong(1, customerId);
        @Cleanup val rs = ps.executeQuery();

        List<Order> orders = new ArrayList<>();

        while (rs.next()) {
            orders.add(new Order(rs.getInt(ID_FIELD),
                    rs.getInt(CUSTOMER_FIELD),
                    rs.getInt(TOUR_FIELD),
                    rs.getBoolean(PAID_FIELD)));
        }

        return orders;
    }

    @Override
    @SneakyThrows
    public OrderDao update(Order order) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val ps = connection.prepareStatement(UPDATE_SQL, RETURN_GENERATED_KEYS);

        ps.setString(1, String.valueOf(order.getCustomerId()));
        ps.setString(2, String.valueOf(order.getTourId()));
        ps.setString(3, String.valueOf(order.isPaid()));
        ps.setString(4, String.valueOf(order.getOrderId()));

        ps.executeUpdate();

        return this;
    }

    @Override
    @SneakyThrows
    public OrderDao deleteOne(Order order) {

        @Cleanup val connection = connector.getConnection();
        @Cleanup val ps = connection.prepareStatement(DELETE_ONE_SQL);
        ps.setLong(1, order.getOrderId());
        ps.executeLargeUpdate();
        return this;
    }

    @Override
    @SneakyThrows
    public OrderDao clear() {

        @Cleanup val connection = connector.getConnection();
        @Cleanup val statement = connection.createStatement();
        statement.execute(DELETE_ALL_SQL);

        return this;
    }

    @Override
    @SneakyThrows
    public int count() {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val rs = statement.executeQuery(COUNT_SQL);
        return rs.next() ? rs.getInt(1) : 0;
    }
}
