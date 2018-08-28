package com.epam.lstr.controllers;

import com.epam.lstr.model.Customer;
import com.epam.lstr.model.Order;
import com.epam.lstr.model.Tour;
import com.epam.lstr.services.CustomerService;
import com.epam.lstr.services.OrderService;
import com.epam.lstr.services.TourService;
import com.epam.lstr.services.impl.CustomerServiceImpl;
import com.epam.lstr.services.impl.OrderServiceImpl;
import com.epam.lstr.services.impl.TourServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/logged")
public class LoggedCustomerController extends HttpServlet {
    private final TourService tourService = new TourServiceImpl();
    private final CustomerService customerService = new CustomerServiceImpl();
    private final OrderService ordersService = new OrderServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getParameter("method")) {
            case "get":
                get(req, resp);
                break;
            case "getSortedByPrice":
                getSortedByPrice(req, resp);
                break;
            case "getSortedByDiscount":
                getSortedByDiscount(req, resp);
                break;
            case "getOrders":
                getOrders(req, resp);
                break;
            default:
                get(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("method")) {
            case "add":
                add(req, resp);
                break;
            case "buy":
                buy(req, resp);
                break;

        }
    }

    private void get(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        List<Tour> tours = (List<Tour>) tourService.getAll();
        req.setAttribute("tours", tours);

        Object idRaw = req.getSession().getAttribute("customer_id");
        int id;
        if (idRaw == null) {
            req.getSession().setAttribute("customer_id",
                    customerService.getByUserId(Integer.parseInt(req.getParameter("user_id")))
                            .getCustomerId());
            idRaw = req.getSession().getAttribute("customer_id");
        }

        id = (Integer) idRaw;

        Customer customer = customerService.get(id);
        req.setAttribute("customer", customer);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/showToursCustomer.jsp");

        dispatcher.forward(req, resp);
    }

    private void getSortedByPrice(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        List<Tour> tours = getSorted(Comparator.comparing(Tour::getPrice));

        req.setAttribute("tours", tours);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showToursCustomer.jsp");

        dispatcher.forward(req, resp);
    }

    private void getSortedByDiscount(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        List<Tour> tours = getSorted(Comparator.comparing(Tour::getDiscount).reversed());

        req.setAttribute("tours", tours);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showToursCustomer.jsp");

        dispatcher.forward(req, resp);
    }

    private void getOrders(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        List<Order> orders = (List<Order>) ordersService.getByCustId((Integer)
                req.getSession()
                        .getAttribute("customer_id")
        );


        List<Tour> tours = orders.stream()
                .map(order -> tourService.get(order.getTourId()))
                .collect(Collectors.toList());

        req.setAttribute("tours", tours);

        int id = (Integer) req.getSession().getAttribute("customer_id");
        Customer customer = customerService.get(id);
        req.setAttribute("customer", customer);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/showMyOrders.jsp");

        dispatcher.forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        boolean isVip = req.getParameter("vip") != null;
        int userId = Integer.parseInt(req.getParameter("user_id"));

        Customer customer = new Customer(name, surname, isVip, userId);

        customerService.add(customer);

        req.getSession().setAttribute("customer_id", customer.getCustomerId());

        get(req, resp);
    }


    private void buy(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int customerId = (Integer) req.getSession().getAttribute("customer_id");
        int tourId = Integer.parseInt(req.getParameter("tour_id"));
        boolean isPaid = true;
        Order order = new Order(customerId, tourId, isPaid);

        ordersService.add(order);

        getOrders(req, resp);
    }

    private List<Tour> getSorted(Comparator<Tour> comparator) {
        return tourService
                .getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }


}
