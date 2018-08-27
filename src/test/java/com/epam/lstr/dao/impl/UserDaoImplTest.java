package com.epam.lstr.dao.impl;

import com.epam.lstr.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UserDaoImplTest {

    private UserDaoImpl userDao = new UserDaoImpl();
    private String LOG = "yyyyyy";
    private String ROLE = "manager";


    private User vasya = userDao.insertUser(new User(1, LOG, "admin", ROLE));

    @Test
    @DisplayName("InsertUser method works correctly")
    void testInsert() {
        userDao.insertUser(vasya);
        assertThat(userDao.findUser(vasya.getId()), is(vasya));
    }

    @Test
    @DisplayName("FindUser method works correctly")
    void testFindUser() {
        User vasya2 = userDao.findUser(vasya.getId());
        String s = vasya2.getLogin();
        assertThat(s, is("yyyyyy"));
    }

    @Test
    @DisplayName("FindAllUsers method works correctly")
    void testFindAllUsers() {
        List<User> list = userDao.findAllUsers();
        assertThat(list.size(), is(1));

    }

    @Test
    @DisplayName("UpdateUser method works correctly")
    void testUpdateUser() {
        vasya.setPassword("444444");
        boolean isUpdate = userDao.updateUser(vasya);
        User u2 = userDao.findUser(vasya.getId());
        assertThat(u2.getPassword(), is("444444"));
        assertThat(isUpdate, is(true));
    }

    @Test
    @DisplayName("GetUserRole method works correctly")
    void testGetUserRole() {
        String s1 = userDao.getUserRole(vasya.getId());
        assertThat(s1,is("manager"));
    }

    @Test
    @DisplayName("Delete method works correctly")
    void testDeleteUser() {
        boolean isDelete = userDao.deleteUser(vasya.getId());
        assertThat(isDelete, is(true));
    }

    @Test
    @DisplayName("DeleteALL method works correctly")
    void testDeleteAllUsers() {
        boolean isDelete = userDao.deleteAllUsers();
        assertThat(isDelete, is(true));
    }

    @Test
    @DisplayName("CountALL method works correctly")
    void testCountAllUsers() {
        int count = userDao.countAllUsers();
        assertThat(count, is(1));
    }

    @Test
    void findByLogPas() {
        userDao.deleteAllUsers();
        userDao.insertUser(vasya);
        assertThat(userDao.findByLogPas(LOG, "admin"), is(vasya));
    }
}
