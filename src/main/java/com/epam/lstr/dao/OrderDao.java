package com.epam.lstr.dao;

import com.epam.lstr.model.Order;

import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getAll();

    Order getById(int orderId);

    OrderDao update(Order order);

    OrderDao deleteOne(Order order);

    OrderDao clear();

    int count();

}
