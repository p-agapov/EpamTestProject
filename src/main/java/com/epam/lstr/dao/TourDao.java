package com.epam.lstr.dao;


import com.epam.lstr.model.Tour;

import java.util.List;

public interface TourDao {

    Tour add(Tour tour);

    List<Tour> getAll();

    Tour getById(int tourId);

    TourDao update(Tour tour);

    TourDao deleteOne(Tour tour);

    TourDao clear();

    int count();

}
