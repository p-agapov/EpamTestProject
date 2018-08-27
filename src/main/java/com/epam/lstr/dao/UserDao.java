package com.epam.lstr.dao;

import com.epam.lstr.model.User;

import java.util.Collection;

public interface UserDao {
    User insertUser(User u);
    User findUser(int id);

    User findByLogPas(String login, String password);
    Collection<User> findAllUsers ();
    boolean updateUser(User u);
    String getUserRole(int id);
    boolean deleteUser(int id);
    boolean deleteAllUsers();
    int countAllUsers();
}
