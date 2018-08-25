package com.epam.lstr.services;

import com.epam.lstr.model.Order;

import java.util.Collection;

public interface OrderService {
    Order add(Order order);

    Order get(int orderId);

    Collection<Order> getByCustId(int customerId);

    Collection<Order> getAll();

    OrderService delete(Order order);

    OrderService deleteAll();

    int count();
}
