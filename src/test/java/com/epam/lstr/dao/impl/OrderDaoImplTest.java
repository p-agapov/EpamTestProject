package com.epam.lstr.dao.impl;

import com.epam.lstr.dao.OrderDao;
import com.epam.lstr.model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrderDaoImplTest {

    private static OrderDao orderDao;
    private static Order order;

    public static Order randomOrder() {
        Random random = new Random();
        int customerId = Math.abs(random.nextInt());
        int tourId = Math.abs(random.nextInt());
        boolean paid = false;
        return new Order(customerId, tourId, paid);
    }

    @BeforeAll
    static void init() {
        orderDao = new OrderDaoImpl();
        order = randomOrder();
    }


    @Test
    void add() {
        orderDao.add(order);
        assertThat(orderDao.getById(order.getOrderId()), is(order));

        orderDao.deleteOne(order);
    }

    @Test
    void getAll() {
        int entriesNum = 5;
        for (int i = 0; i < entriesNum; i++)
            orderDao.add(randomOrder());

        assertThat(orderDao.getAll().size(), is(entriesNum));

        orderDao.clear();

    }

    @Test
    void update() {
        orderDao.add(order);
        Order updatedOrder = order;
        updatedOrder.setCustomerId(-2);
        updatedOrder.setPaid(true);
        updatedOrder.setTourId(-2);

        orderDao.update(updatedOrder);

        assertThat(orderDao.getById(updatedOrder.getOrderId()), is(updatedOrder));

        orderDao.deleteOne(updatedOrder);

    }

    @Test
    void deleteOne() {
        orderDao.add(order);
        assertThat(orderDao.deleteOne(order).count(), is(0));
    }

    @Test
    void getByCustId() {

        int customerId = 1;
        int num = 2;

        orderDao.add(new Order(customerId, 2, true));
        orderDao.add(new Order(customerId, 3, true));
        orderDao.add(new Order(2, 2, true));

        assertThat(orderDao.getByCustId(customerId).size(), is(num));

        orderDao.clear();

    }
}