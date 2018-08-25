package com.epam.lstr.services;

import com.epam.lstr.model.Customer;

import java.util.Collection;

/**
 * Interface of CustomerService
 *
 * @author Pavel Agapov
 * @version 1.0
 */
public interface CustomerService {

    Customer add(Customer customer);

    CustomerService set(Customer customer);

    CustomerService delete(Customer customer);

    Customer get(int id);

    Collection<Customer> getAll();

    CustomerService deleteAll();

    int count();
}
