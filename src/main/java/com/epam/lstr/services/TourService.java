package com.epam.lstr.services;

import com.epam.lstr.model.Tour;

import java.util.Collection;

public interface TourService {
    Tour add(Tour tour);

    Tour get(int tourId);

    Collection<Tour> getAll();

    TourService set(Tour tour);

    TourService delete(Tour tour);

    TourService deleteAll();

    int count();
}
