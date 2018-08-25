package com.epam.lstr.dao;

import com.epam.lstr.model.Order;

import java.util.List;

public interface OrderDao {
    Order add(Order order);

    Order getById(int orderId);

    List<Order> getByCustId(int customerId);

    List<Order> getAll();

    OrderDao update(Order order);

    OrderDao deleteOne(Order order);

    OrderDao clear();

    int count();

}
