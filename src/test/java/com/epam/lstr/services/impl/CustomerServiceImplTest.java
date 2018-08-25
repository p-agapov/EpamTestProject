package com.epam.lstr.services.impl;

import com.epam.lstr.model.Customer;
import com.epam.lstr.services.CustomerService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@FieldDefaults(level = AccessLevel.PRIVATE)
class CustomerServiceImplTest {

    final static String CUSTOMER_NAME = "Don";
    final static String CUSTOMER_SURNAME = "Pomodoro";
    final static boolean CUSTOMER_VIP = false;
    final static int CUSTOMER_USER_ID = 666;

    final static int ROW_COUNT = 3;

    static Customer customer = newCustomer();
    static CustomerService customerService = new CustomerServiceImpl();

    private static Customer newCustomer() {
        return new Customer(
                CUSTOMER_NAME,
                CUSTOMER_SURNAME,
                CUSTOMER_VIP,
                CUSTOMER_USER_ID
        );
    }

    @Test
    @DisplayName("Add method works correctly.")
    void add() {
        customerService.add(customer);
        assertThat(customerService.get(customer.getCustomerId()), is(customer));

        customerService.delete(customer);
    }

    @Test
    @DisplayName("Set method works correctly.")
    void set() {
        customerService.add(customer);
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
        customerService.set(updatedCustomer);

        assertThat(customerService.get(customer.getCustomerId()), is(updatedCustomer));

        customerService.delete(customer);
    }

    @Test
    @DisplayName("Delete method works correctly.")
    void delete() {
        customerService.add(customer);
        customerService.delete(customer);

        assertThat(customerService.count(), is(0));
    }

    @Test
    @DisplayName("Get method works correctly.")
    void get() {
        customerService.add(customer);

        assertThat(customerService.get(customer.getCustomerId()), is(customer));

        customerService.delete(customer);
    }

    @Test
    @DisplayName("GetAll method works correctly.")
    void getAll() {
        for (int i = 0; i < ROW_COUNT; i++) {
            customerService.add(customer);
        }

        assertThat(customerService.getAll().size(), is(ROW_COUNT));

        customerService.deleteAll();
    }

    @Test
    @DisplayName("DeleteAll method works correctly.")
    void deleteAll() {
        for (int i = 0; i < ROW_COUNT; i++) {
            customerService.add(customer);
        }

        customerService.deleteAll();

        assertThat(customerService.count(), is(0));
    }

    @Test
    @DisplayName("Count method works correctly.")
    void count() {
        for (int i = 0; i < ROW_COUNT; i++) {
            customerService.add(customer);
        }

        assertThat(customerService.count(), is(ROW_COUNT));

        customerService.deleteAll();
    }
}
