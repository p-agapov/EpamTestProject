package com.epam.lstr.dao;

import com.epam.lstr.model.Customer;

import java.util.List;

/**
 * Interface of CustomerDao
 *
 * @author Pavel Agapov
 * @version 1.0
 */

public interface CustomerDao {

    Customer create(Customer customer);
    Customer update(Customer customer);
    CustomerDao delete(Customer customer);

    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();

    CustomerDao clear();
    int count();
}
