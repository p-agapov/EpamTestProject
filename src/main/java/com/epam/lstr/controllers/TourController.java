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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/tours")
public class TourController extends HttpServlet {

    private final TourService service = new TourServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param = req.getParameter("method");
        if (param != null) {
            switch (param) {
                case "get":
                    get(req, resp);
                    break;
                case "getAll":
                    getAll(req, resp);
                    break;
                case "getSortedByPrice":
                    getSortedByPrice(req, resp);
                    break;
                case "getSortedByDiscount":
                    getSortedByDiscount(req, resp);
                    break;
                default:
                    getAll(req, resp);

            }
        } else
            getAll(req, resp);
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


    private void get(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getParameter("tour_id"));

        Tour tour = service.get(id);

        req.setAttribute("tour", tour);
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String level = req.getParameter("level");
        List<Tour> tours = (List<Tour>) service.getAll();

        req.setAttribute("tours", tours);
        RequestDispatcher dispatcher = decideAccess(req, level);

        dispatcher.forward(req, resp);
    }

    private void getSortedByPrice(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String level = req.getParameter("level");
        List<Tour> tours = getSorted(Comparator.comparing(Tour::getPrice));

        req.setAttribute("tours", tours);
        RequestDispatcher dispatcher = decideAccess(req, level);

        dispatcher.forward(req, resp);
    }

    private void getSortedByDiscount(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String level = req.getParameter("level");
        List<Tour> tours = getSorted(Comparator.comparing(Tour::getDiscount).reversed());

        req.setAttribute("tours", tours);
        RequestDispatcher dispatcher = decideAccess(req, level);

        dispatcher.forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        boolean isHot = req.getParameter("hot") != null;
        int discount = Integer.parseInt(req.getParameter("discount"));
        Tour tour = new Tour(name, price, isHot, discount);

        service.add(tour);

        getAll(req, resp);

    }

    private void set(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        boolean isHot = req.getParameter("hot") != null;
        int discount = Integer.parseInt(req.getParameter("discount"));
        Tour tour = new Tour(id, name, price, isHot, discount);

        service.set(tour);

        getAll(req, resp);
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

    private List<Tour> getSorted(Comparator<Tour> comparator) {
        return service
                .getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private RequestDispatcher decideAccess(HttpServletRequest req, String level) {
        RequestDispatcher dispatcher;
        if ("manager".equals(level))
            dispatcher = req.getRequestDispatcher("/showToursManager.jsp");
        else if ("customer".equals(level))
            dispatcher = req.getRequestDispatcher("/showToursCustomer.jsp");
        else
            dispatcher = req.getRequestDispatcher("/showToursNobody.jsp");
        return dispatcher;
    }
}
