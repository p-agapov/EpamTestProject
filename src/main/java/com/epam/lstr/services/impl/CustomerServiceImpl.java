package com.epam.lstr.services.impl;

import com.epam.lstr.dao.CustomerDao;
import com.epam.lstr.dao.impl.CustomerDaoImpl;
import com.epam.lstr.model.Customer;
import com.epam.lstr.services.CustomerService;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

/**
 * Implementation of CustomerDao interface
 *
 * @author Pavel Agapov
 * @version 1.0
 */

@FieldDefaults(level = PRIVATE)
public class CustomerServiceImpl implements CustomerService {

    CustomerDao dao;

    public CustomerServiceImpl() {
        dao = new CustomerDaoImpl();
    }

    @Override
    public Customer add(Customer customer) {
        return dao.create(customer);
    }

    @Override
    public CustomerService set(Customer customer) {
        dao.update(customer);
        return this;
    }

    @Override
    public CustomerService delete(Customer customer) {
        dao.delete(customer);
        return this;
    }

    @Override
    public Customer get(int id) {
        return dao.getCustomerById(id);
    }

    @Override
    public Collection<Customer> getAll() {
        return dao.getAllCustomers();
    }

    @Override
    public CustomerService deleteAll() {
        dao.clear();
        return this;
    }

    @Override
    public int count() {
        return dao.count();
    }
}
