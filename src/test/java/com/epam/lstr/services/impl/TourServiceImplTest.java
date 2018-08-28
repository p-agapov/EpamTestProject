package com.epam.lstr.services.impl;

import com.epam.lstr.dao.ConnectionPool;
import com.epam.lstr.model.Tour;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.epam.lstr.dao.impl.TourDaoImplTest.randomTour;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class TourServiceImplTest {

    private static TourServiceImpl service;
    private static Tour tour;


    @BeforeAll
    private static void init() {
        service = new TourServiceImpl();
        tour = randomTour();
        ConnectionPool.setTestDB();
    }


    @Test
    void add() {
        service.add(tour);
        assertThat(service.get(tour.getTourId()), is(tour));

        service.delete(tour);
    }

    @Test
    void getAll() {
        int entriesNum = 5;
        for (int i = 0; i < entriesNum; i++)
            service.add(randomTour());

        assertThat(service.getAll().size(), is(entriesNum));

        service.deleteAll();
    }

    @Test
    void set() {
        service.add(tour);
        Tour updatedTour = tour;
        updatedTour.setDiscount(-2);
        updatedTour.setHot(true);
        updatedTour.setPrice(-2);

        service.set(updatedTour);

        assertThat(service.get(updatedTour.getTourId()), is(updatedTour));

        service.delete(updatedTour);
    }

    @Test
    void delete() {
        service.add(tour);
        assertThat(service.delete(tour).count(), is(0));
    }

    @Test
    void deleteAll() {
        int entriesNum = 5;
        for (int i = 0; i < entriesNum; i++)
            service.add(randomTour());

        service.deleteAll();

        assertThat(service.count(), is(0));
    }
}