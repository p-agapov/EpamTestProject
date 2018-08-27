package com.epam.lstr.services.impl;

import com.epam.lstr.dao.impl.UserDaoImpl;
import com.epam.lstr.model.User;
import com.epam.lstr.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    public User add(User u) {
        return userDao.insertUser(u);
    }

    public User get(int id) {
        return userDao.findUser(id);
    }

    @Override
    public User getByLogPas(String login, String password) {
        return userDao.findByLogPas(login, password);
    }

    public List<User> getAll() {
        return userDao.findAllUsers();
    }

    public boolean set(User u) {
        return userDao.updateUser(u);
    }

    public String getUserRole (int id) {
        return userDao.getUserRole(id);
    }

    public boolean delete(int id) {
        return userDao.deleteUser(id);
    }

    public boolean deleteAll() {
        return userDao.deleteAllUsers();
    }

    public int count() {
        return userDao.countAllUsers();
    }
}
