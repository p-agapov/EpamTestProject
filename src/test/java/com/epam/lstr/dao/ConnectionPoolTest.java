package com.epam.lstr.dao;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ConnectionPoolTest {


    @Test
    @SneakyThrows
    void getConnection() {
        val connection = ConnectionPool.getConnection();
        assertThat(connection.isValid(1), is(true));
    }
}