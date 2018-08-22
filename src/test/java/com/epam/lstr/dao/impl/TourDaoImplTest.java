package com.epam.lstr.dao.impl;

import com.epam.lstr.dao.TourDao;
import com.epam.lstr.model.Tour;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TourDaoImplTest {

    private static TourDao tourDao;
    private static Tour tour;

    static public Tour randomTour() {
        Random random = new Random();
        String name = String.valueOf(Math.abs(random.nextInt()));
        int price = Math.abs(random.nextInt());
        int discount = Math.abs(random.nextInt() % price);
        return new Tour(name, price, false, discount);
    }

    @BeforeAll
    static void init() {
        tourDao = new TourDaoImpl();
        tour = randomTour();
    }

    @Test
    void add() {
        tourDao.add(tour);
        assertThat(tourDao.getById(tour.getTourId()), is(tour));

        tourDao.deleteOne(tour);
    }

    @Test
    void update() {
        tourDao.add(tour);
        Tour updatedTour = tour;
        updatedTour.setDiscount(-2);
        updatedTour.setHot(true);
        updatedTour.setPrice(-2);

        tourDao.update(updatedTour);

        assertThat(tourDao.getById(updatedTour.getTourId()), is(updatedTour));

        tourDao.deleteOne(updatedTour);
    }

    @Test
    void deleteOne() {
        tourDao.add(tour);
        assertThat(tourDao.deleteOne(tour).count(), is(0));
    }

    @Test
    void getAll() {
        int entriesNum = 5;
        for (int i = 0; i < entriesNum; i++)
            tourDao.add(randomTour());

        assertThat(tourDao.getAll().size(), is(entriesNum));

        tourDao.clear();

    }
}
