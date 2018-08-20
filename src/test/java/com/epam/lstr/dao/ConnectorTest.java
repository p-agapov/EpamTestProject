package com.epam.lstr.dao;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ConnectorTest {

    @Test
    @SneakyThrows
    void getConnection() {
        val connector = Connector.getConnector();
        val connection = connector.getConnection();
        assertThat(connection.isValid(1), is(true));
    }
}