package com.epam.lstr.dao;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ConnectionPoolTest {

    @BeforeAll
    static void init() {
        ConnectionPool.setTestDB();
    }

    @SneakyThrows
    @Test
    void getConnection() {
        assertThat(ConnectionPool.getConnection().isValid(1), is(true));
    }
}