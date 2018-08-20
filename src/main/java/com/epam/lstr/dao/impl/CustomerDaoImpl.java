package com.epam.lstr.dao.impl;

import com.epam.lstr.dao.Connector;
import com.epam.lstr.dao.CustomerDao;
import com.epam.lstr.dao.model.Customer;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * Implementation of CustomerDao interface
 *
 * @author Pavel Agapov
 * @version 1.0
 */

@FieldDefaults(level = PRIVATE)
public class CustomerDaoImpl implements CustomerDao {

    static final String INSERT_SQL = "INSERT INTO customers (name, surname, VIP, user_id) VALUES (?, ?, ?, ?)";
    static final String UPDATE_SQL = "UPDATE customers SET name = ?, surname = ?, VIP = ?, user_id = ? WHERE customer_id = ?";
    static final String DELETE_SQL = "DELETE FROM customers WHERE customer_id = ?";
    static final String GET_SQL = "SELECT customer_id, name, surname, VIP, user_id FROM customers WHERE customer_id = ?";
    static final String GET_ALL_SQL = "SELECT customer_id, name, surname, VIP, user_id FROM customers";
    static final String DELETE_ALL_SQL = "DELETE FROM customers";
    static final String COUNT_SQL = "SELECT COUNT(customer_id) FROM customers";

    static final String CUSTOMER_ID_FIELD = "customer_id";
    static final String NAME_FIELD = "name";
    static final String SURNAME_FIELD = "surname";
    static final String VIP_FIELD = "VIP";
    static final String USER_ID_FIELD = "user_id";

    Connector connector = Connector.getConnector();

    @NonNull
    @SneakyThrows
    public Customer create(@NonNull Customer customer) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getSurname());
        preparedStatement.setBoolean(3, customer.isVIP());
        preparedStatement.setInt(4, customer.getUserId());
        preparedStatement.executeUpdate();

        @Cleanup val resultSet = preparedStatement.getGeneratedKeys();
        if (!resultSet.next()) {
            throw new RuntimeException("Key generation failed!");
        }
        customer.setCustomerId(resultSet.getInt(1));

        return customer;
    }

    @NonNull
    @SneakyThrows
    public Customer update(@NonNull Customer customer) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(UPDATE_SQL);

        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getSurname());
        preparedStatement.setBoolean(3, customer.isVIP());
        preparedStatement.setInt(4, customer.getUserId());
        preparedStatement.setInt(5, customer.getCustomerId());
        preparedStatement.executeUpdate();

        return customer;
    }

    @NonNull
    @SneakyThrows
    public CustomerDao delete(@NonNull Customer customer) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(DELETE_SQL);

        preparedStatement.setInt(1, customer.getCustomerId());
        preparedStatement.executeUpdate();

        return this;
    }

    @SneakyThrows
    public Customer getCustomerById(int id) {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(GET_SQL);

        preparedStatement.setInt(1, id);

        @Cleanup val resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
            return new Customer(
                    resultSet.getInt(CUSTOMER_ID_FIELD),
                    resultSet.getString(NAME_FIELD),
                    resultSet.getString(SURNAME_FIELD),
                    resultSet.getBoolean(VIP_FIELD),
                    resultSet.getInt(USER_ID_FIELD));

        return null;
    }

    @NonNull
    @SneakyThrows
    public List<Customer> getAllCustomers() {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val resultSet = statement.executeQuery(GET_ALL_SQL);

        List<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {
            customers.add(new Customer(
                    resultSet.getInt(CUSTOMER_ID_FIELD),
                    resultSet.getString(NAME_FIELD),
                    resultSet.getString(SURNAME_FIELD),
                    resultSet.getBoolean(VIP_FIELD),
                    resultSet.getInt(USER_ID_FIELD)));
        }

        return customers;
    }

    @NonNull
    @SneakyThrows
    public CustomerDao clear() {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(DELETE_ALL_SQL);
        preparedStatement.executeUpdate();
        return this;
    }

    @SneakyThrows
    public int count() {
        @Cleanup val connection = connector.getConnection();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val resultSet = statement.executeQuery(COUNT_SQL);
        return resultSet.next() ? resultSet.getInt(1) : 0;
    }
}
