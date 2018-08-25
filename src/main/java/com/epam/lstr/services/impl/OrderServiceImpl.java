package com.epam.lstr.services.impl;

import com.epam.lstr.dao.OrderDao;
import com.epam.lstr.dao.impl.OrderDaoImpl;
import com.epam.lstr.model.Order;
import com.epam.lstr.services.OrderService;

import java.util.Collection;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao;

    public OrderServiceImpl() {
        dao = new OrderDaoImpl();
    }

    @Override
    public Order add(Order order) {
        return dao.add(order);
    }

    @Override
    public Order get(int orderId) {
        return dao.getById(orderId);
    }

    @Override
    public Collection<Order> getByCustId(int customerId) {
        return dao.getByCustId(customerId);
    }

    @Override
    public Collection<Order> getAll() {
        return dao.getAll();
    }

    @Override
    public OrderService delete(Order order) {
        dao.deleteOne(order);
        return this;
    }

    @Override
    public OrderService deleteAll() {
        dao.clear();
        return this;
    }

    @Override
    public int count() {
        return dao.count();
    }
}
