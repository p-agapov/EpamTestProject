package com.epam.lstr.services.impl;

import com.epam.lstr.model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.epam.lstr.dao.impl.OrderDaoImplTest.randomOrder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class OrderServiceImplTest {

    private static OrderServiceImpl service;
    private static Order order;


    @BeforeAll
    private static void init() {
        service = new OrderServiceImpl();
        order = randomOrder();
    }


    @Test
    void add() {
        service.add(order);
        assertThat(service.get(order.getOrderId()), is(order));

        service.delete(order);
    }


    @Test
    void getAll() {
        int entriesNum = 5;
        for (int i = 0; i < entriesNum; i++)
            service.add(randomOrder());

        assertThat(service.getAll().size(), is(entriesNum));

        service.deleteAll();
    }

    @Test
    void delete() {
        service.add(order);
        assertThat(service.delete(order).count(), is(0));
    }

    @Test
    void deleteAll() {
        int entriesNum = 5;
        for (int i = 0; i < entriesNum; i++)
            service.add(randomOrder());

        service.deleteAll();

        assertThat(service.count(), is(0));
    }

    @Test
    void getByCustId() {
        int customerId = 1;
        int num = 2;

        service.add(new Order(customerId, 2, true));
        service.add(new Order(customerId, 3, true));
        service.add(new Order(2, 2, true));

        assertThat(service.getByCustId(customerId).size(), is(num));

        service.deleteAll();

    }
}