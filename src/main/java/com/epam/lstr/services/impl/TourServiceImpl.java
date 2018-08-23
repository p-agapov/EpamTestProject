package com.epam.lstr.services.impl;

import com.epam.lstr.dao.TourDao;
import com.epam.lstr.dao.impl.TourDaoImpl;
import com.epam.lstr.model.Tour;
import com.epam.lstr.services.TourService;

import java.util.Collection;

public class TourServiceImpl implements TourService {

    private TourDao dao;

    public TourServiceImpl() {
        dao = new TourDaoImpl();
    }

    @Override
    public Tour add(Tour tour) {
        return dao.add(tour);
    }

    @Override
    public Tour get(int tourId) {
        return dao.getById(tourId);
    }

    @Override
    public Collection<Tour> getAll() {
        return dao.getAll();
    }

    @Override
    public TourService set(Tour tour) {
        dao.update(tour);
        return this;
    }

    @Override
    public TourService delete(Tour tour) {
        dao.deleteOne(tour);
        return this;
    }

    @Override
    public TourService deleteAll() {
        dao.clear();
        return this;
    }

    @Override
    public int count() {
        return dao.count();
    }
}
