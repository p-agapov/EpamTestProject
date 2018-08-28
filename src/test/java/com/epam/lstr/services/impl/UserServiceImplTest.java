package com.epam.lstr.services.impl;

import com.epam.lstr.dao.ConnectionPool;
import com.epam.lstr.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UserServiceImplTest {

    private static final UserServiceImpl userService = new UserServiceImpl();
    private static final String LOG = "yyyyyy";
    private static final String ROLE = "manager";

    private User vasya = new User(LOG, "admin", ROLE);

    @BeforeAll
    static void init() {
        ConnectionPool.setTestDB();
    }

    @Test
    @DisplayName("Test Service Add works")
    void add() {
        User us = userService.add(vasya);
        assertThat(userService.get(us.getId()), is(vasya));
    }

    @Test
    @DisplayName("Test Service Get works")
    void get() {
        User us = userService.add(vasya);
        User us2 = userService.get(us.getId());
        String s = us2.getLogin();
        assertThat(s, is(LOG));
    }

    @Test
    @DisplayName("Test Service GetALL works")
    void getAll() {
        userService.add(vasya);
        List<User> list = userService.getAll();
        assertThat(list.size(), is(1));
    }

    @Test
    @DisplayName("Test Service Set works")
    void set() {
        User us = userService.add(vasya);
        us.setPassword("test");
        boolean isUpdate = userService.set(us);
        User us2 = userService.get(us.getId());
        assertThat(us2.getPassword(), is("test"));
        assertThat(isUpdate, is(true));
    }

    @Test
    @DisplayName("Test Service GetUserRole works")
    void getUserRole() {
        User us = userService.add(vasya);
        String s1 = userService.getUserRole(us.getId());
        assertThat(s1, is("manager"));
    }

    @Test
    @DisplayName("Test Service Delete works")
    void delete() {
        User us = userService.add(vasya);
        boolean isDelete = userService.delete(us.getId());
        assertThat(isDelete, is(true));
    }

    @Test
    @DisplayName("Test Service DeleteALL works")
    void deleteAll() {
        userService.add(vasya);
        boolean isDelete = userService.deleteAll();
        assertThat(isDelete, is(true));
    }

    @Test
    @DisplayName("Test Service Count works")
    void count() {
        userService.deleteAll();
        userService.add(vasya);
        int count = userService.count();
        assertThat(count, is(1));
    }

    @AfterEach
    void deleteData() {
     userService.deleteAll();
    }
}
