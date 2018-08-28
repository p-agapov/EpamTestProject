package com.epam.lstr.controllers;

import com.epam.lstr.model.Customer;
import com.epam.lstr.services.CustomerService;
import com.epam.lstr.services.impl.CustomerServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerController extends HttpServlet {

    final CustomerService service = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getParameter("method")) {
            case "getAll":
                getAll(req, resp);
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

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> customers = (List<Customer>) service.getAll();
        req.setAttribute("customers", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("showCustomersManager.jsp");
        dispatcher.forward(req, resp);
    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        boolean isVip = req.getParameter("vip") != null;
        int userId = Integer.parseInt(req.getParameter("userid"));
        boolean redirectToUserController = req.getParameter("redirect") != null;

        Customer customer = new Customer(name, surname, isVip, userId);

        service.add(customer);
        if (redirectToUserController)
            resp.sendRedirect("users?method=getAll");
        else
            getAll(req, resp);
    }


    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = new Customer(id);

        service.delete(customer);

        getAll(req, resp);
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.deleteAll();

        getAll(req, resp);
    }

}
