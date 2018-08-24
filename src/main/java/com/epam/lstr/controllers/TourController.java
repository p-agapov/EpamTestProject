package com.epam.lstr.controllers;

import com.epam.lstr.model.Tour;
import com.epam.lstr.services.TourService;
import com.epam.lstr.services.impl.TourServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/tours")
public class TourController extends HttpServlet {

    private TourService service = new TourServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getParameter("method")) {
            case "get":
                get(req, resp);
                break;
            case "getAll":
                getAll(req, resp);
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
            case "set":
                set(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "deleteAll":
                deleteAll(req, resp);
                break;
        }
    }


    private void get(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println(service.get(id));
        out.println("</body></html>");
        out.close();
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Tour> tours = (List<Tour>) service.getAll();
        req.setAttribute("tours", tours);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showTours.jsp");
        dispatcher.forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        boolean isHot = req.getParameter("hot").equals("on");
        int discount = Integer.parseInt(req.getParameter("discount"));
        Tour tour = new Tour(name, price, isHot, discount);

        service.add(tour);

        getAll(req, resp);

    }

    private void set(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        boolean isHot = req.getParameter("hot").equals("on");
        int discount = Integer.parseInt(req.getParameter("discount"));
        Tour tour = new Tour(id, name, price, isHot, discount);

        service.set(tour);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("id"));

        Tour tour = new Tour(id);
        service.delete(tour);

        getAll(req, resp);
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        service.deleteAll();

        getAll(req, resp);

    }

    private void count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println(service.count());
        out.println("</body></html>");
        out.close();
    }


}
