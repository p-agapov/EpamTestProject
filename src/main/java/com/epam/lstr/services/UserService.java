package com.epam.lstr.services;

import com.epam.lstr.model.User;

import java.util.Collection;

public interface UserService {
    User add(User u);
    User get(int id);

    User getByLogPas(String login, String password);
    Collection<User> getAll();
    boolean set(User u);
    String getUserRole(int id);
    boolean delete(int id);
    boolean deleteAll();
    int count();
}
