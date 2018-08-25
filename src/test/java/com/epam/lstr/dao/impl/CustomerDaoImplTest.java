package com.epam.lstr.dao.impl;

import com.epam.lstr.dao.CustomerDao;
import com.epam.lstr.model.Customer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDaoImplTest {

    final static String CUSTOMER_NAME = "Don";
    final static String CUSTOMER_SURNAME = "Pomodoro";
    final static boolean CUSTOMER_VIP = true;
    final static int CUSTOMER_USER_ID = 666;

    final static int ROW_COUNT = 3;

    static Customer customer = newCustomer();
    static CustomerDao customerDao = new CustomerDaoImpl();

    private static Customer newCustomer() {
        return new Customer(
                CUSTOMER_NAME,
                CUSTOMER_SURNAME,
                CUSTOMER_VIP,
                CUSTOMER_USER_ID
        );
    }

    @Test
    @DisplayName("Create method works correctly.")
    void create() {
        customerDao.create(customer);
        assertThat(customerDao.getCustomerById(customer.getCustomerId()), is(customer));

        customerDao.delete(customer);
    }

    @Test
    @DisplayName("Update method works correctly.")
    void update() {
        customerDao.create(customer);
        Customer updatedCustomer = new Customer(
                customer.getCustomerId(),
                customer.getName(),
                customer.getSurname(),
                customer.isVIP(),
                customer.getUserId()
        );

        updatedCustomer.setName("Donna");
        updatedCustomer.setSurname("Pomodorio");
        updatedCustomer.setVIP(false);
        customerDao.update(updatedCustomer);

        assertThat(customerDao.getCustomerById(customer.getCustomerId()), is(updatedCustomer));

        customerDao.delete(customer);
    }

    @Test
    @DisplayName("Delete method works correctly.")
    void delete() {
        customerDao.create(customer);
        customerDao.delete(customer);

        assertThat(customerDao.count(), is(0));
    }

    @Test
    @DisplayName("GetCustomerById method works correctly.")
    void getCustomerById() {
        customerDao.create(customer);

        assertThat(customerDao.getCustomerById(customer.getCustomerId()), is(customer));

        customerDao.delete(customer);
    }

    @Test
    @DisplayName("GetAllCustomers method works correctly.")
    void getAllCustomers() {
        for (int i = 0; i < ROW_COUNT; i++) {
            customerDao.create(customer);
        }

        assertThat(customerDao.getAllCustomers().size(), is(ROW_COUNT));

        customerDao.clear();
    }

    @Test
    @DisplayName("Clear method works correctly.")
    void clear() {
        for (int i = 0; i < ROW_COUNT; i++) {
            customerDao.create(customer);
        }

        customerDao.clear();

        assertThat(customerDao.count(), is(0));
    }

    @Test
    @DisplayName("Count method works correctly.")
    void count() {
        for (int i = 0; i < ROW_COUNT; i++) {
            customerDao.create(customer);
        }

        assertThat(customerDao.count(), is(ROW_COUNT));

        customerDao.clear();
    }
}
