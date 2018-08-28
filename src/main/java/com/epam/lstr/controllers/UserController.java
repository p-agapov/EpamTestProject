package com.epam.lstr.controllers;

import com.epam.lstr.model.User;
import com.epam.lstr.services.impl.UserServiceImpl;
import com.google.common.hash.Hashing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Function;

@WebServlet("/users")
public class UserController extends HttpServlet {
    private static UserServiceImpl userService = new UserServiceImpl();
    private static final String LOG = "login";
    private static final String PAS = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("method")) {
            case "get":
                get(req, resp);
                break;
            case "getAll":
                getAll(req, resp);
                break;
            case "getUserRole":
                getUserRole(req, resp);
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
            case "login":
                login(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;

            case "register":
                register(req, resp);
                break;
            default:
                getAll(req, resp);


        }
    }

    private void get(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.get(id);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userSearch.jsp");
        dispatcher.forward(req, resp);
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> users = userService.getAll();
        req.setAttribute("users", users);
        String no = "no data";
        if (users.isEmpty()) {
            User defUser = new User(no, no, no);
            req.setAttribute("defUser", defUser);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/usersAll.jsp");
        dispatcher.forward(req, resp);
    }

    private void getUserRole(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String userRole = userService.getUserRole(id);
        req.setAttribute("userRole", userRole);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String login = req.getParameter(LOG);
        String password = req.getParameter(PAS);
        String role = req.getParameter("role");
        User user = new User(login, password, role);
        userService.add(user);
        getAll(req, resp);
    }

    private void set(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter(LOG);
        String password = req.getParameter(PAS);
        String role = req.getParameter("role");
        User user = new User(id, login, password, role);
        boolean set = userService.set(user);
        String yes = "updated";
        if (set) {
            req.setAttribute("yes", yes);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateUser.jsp");
        dispatcher.forward(req, resp);

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.delete(id);
        getAll(req, resp);
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        userService.deleteAll();

        getAll(req, resp);
    }

    private void count(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int amount = userService.count();
        req.setAttribute("amount", amount);
        getAll(req, resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOG);
        String password = GET_HASHED.apply(req.getParameter(PAS));
        String role = req.getParameter("role");
        User user = new User(login, password, role);
        userService.add(user);
        req.setAttribute("userId", user.getId());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/registration2.jsp");
        dispatcher.forward(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(LOG);
        String password = GET_HASHED.apply(req.getParameter(PAS));
        String redirect;
        User user = userService.getByLogPas(login, password);

        if (user == null) {
            resp.sendRedirect("tours?method=getAll&level=nobody&login=wrong");
        } else {
            if (user.getRole().equals("manager"))
                resp.sendRedirect("/managerFrontPage.jsp");
            else
                resp.sendRedirect("logged?method=get&user_id=" + user.getId());

        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }



    private Function<String, String> GET_HASHED = string -> Hashing.sha256()
            .hashString(string, StandardCharsets.UTF_8)
            .toString();
}
