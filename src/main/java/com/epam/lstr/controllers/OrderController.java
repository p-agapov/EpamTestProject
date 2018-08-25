package com.epam.lstr.controllers;

import com.epam.lstr.model.Order;
import com.epam.lstr.services.OrderService;
import com.epam.lstr.services.impl.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderController extends HttpServlet {

    private final OrderService service = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getParameter("method")) {
            case "get":
                get(req, resp);
                break;
            case "getAll":
                getAll(req, resp);
                break;
            case "getByCustId":
                getByCustId(req, resp);
                break;
            case "count":
                count(req, resp);
                break;
            default:
                getAll(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("method")) {
            case "add":
                add(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "deleteAll":
                deleteAll(req, resp);
                break;
            default:
                getAll(req, resp);
        }
    }


    private void get(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException();
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Order> orders = (List<Order>) service.getAll();
        req.setAttribute("orders", orders);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showToursManager.jsp");
        dispatcher.forward(req, resp);
    }

    private void getByCustId(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int customerId = Integer.parseInt(req.getParameter("custId"));
        List<Order> orders = (List<Order>) service.getByCustId(customerId);
        req.setAttribute("orders", orders);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showToursManager.jsp");
        dispatcher.forward(req, resp);
    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int custId = Integer.parseInt(req.getParameter("custId"));
        int tourId = Integer.parseInt(req.getParameter("tourId"));
        boolean isPaid = req.getParameter("paid") != null;
        Order order = new Order(custId, tourId, isPaid);

        service.add(order);

        getAll(req, resp);

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("id"));

        Order order = new Order(id);
        service.delete(order);

        getAll(req, resp);
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        service.deleteAll();

        getAll(req, resp);

    }

    private void count(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException();
    }
}
