package com.epam.lstr.dao.impl;

import com.epam.lstr.dao.ConnectionPool;
import com.epam.lstr.dao.TourDao;
import com.epam.lstr.model.Tour;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class TourDaoImpl implements TourDao {

    private static final String INSERT_SQL = "INSERT INTO tours (name, price, hot, discount) VALUES (?, ?, ?, ?)";
    private static final String GET_ALL_SQL = "SELECT tour_id, name, price, hot, discount FROM tours";
    private static final String GET_ONE_SQL = "SELECT tour_id, name, price, hot, discount FROM tours where tour_id = ?";
    private static final String DELETE_ONE_SQL = "DELETE FROM tours WHERE tour_id = ?";
    private static final String DELETE_ALL_SQL = "DELETE FROM tours";
    private static final String UPDATE_SQL = "UPDATE tours SET name = ?, price = ?, hot = ?, discount = ? WHERE tour_id = ?";
    private static final String COUNT_SQL = "SELECT COUNT(tour_id) FROM tours";

    private static final String ID_FIELD = "tour_id";
    private static final String NAME_FIELD = "name";
    private static final String PRICE_FIELD = "price";
    private static final String HOT_FIELD = "hot";
    private static final String DISCOUNT_FIELD = "discount";


    @SneakyThrows
    public Tour add(@NonNull Tour tour) {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(INSERT_SQL, RETURN_GENERATED_KEYS);

        ps.setString(1, tour.getName());
        ps.setInt(2, tour.getPrice());
        ps.setBoolean(3, tour.isHot());
        ps.setInt(4, tour.getDiscount());

        ps.executeUpdate();

        @Cleanup val rs = ps.getGeneratedKeys();

        if (!rs.next())
            throw new RuntimeException("Не был сгенерирован ключ!");

        tour.setTourId(rs.getInt(1));
        return tour;
    }

    @SneakyThrows
    public List<Tour> getAll() {

        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val rs = statement.executeQuery(GET_ALL_SQL);

        List<Tour> tours = new ArrayList<>();

        while (rs.next()) {
            tours.add(new Tour(rs.getInt(ID_FIELD),
                    rs.getString(NAME_FIELD),
                    rs.getInt(PRICE_FIELD),
                    rs.getBoolean(HOT_FIELD),
                    rs.getInt(DISCOUNT_FIELD)));
        }
        return tours;
    }

    @SneakyThrows
    public Tour getById(int tourId) {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(GET_ONE_SQL);
        ps.setInt(1, tourId);
        @Cleanup val rs = ps.executeQuery();


        return rs.next() ?
                new Tour(rs.getInt(ID_FIELD),
                        rs.getString(NAME_FIELD),
                        rs.getInt(PRICE_FIELD),
                        rs.getBoolean(HOT_FIELD),
                        rs.getInt(DISCOUNT_FIELD))
                : null;
    }

    @SneakyThrows
    public TourDao update(Tour tour) {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(UPDATE_SQL, RETURN_GENERATED_KEYS);

        ps.setString(1, tour.getName());
        ps.setString(2, String.valueOf(tour.getPrice()));
        ps.setString(3, String.valueOf(tour.isHot()));
        ps.setString(4, String.valueOf(tour.getDiscount()));
        ps.setString(5, String.valueOf(tour.getTourId()));

        ps.executeUpdate();

        return this;
    }


    @SneakyThrows
    public TourDao deleteOne(Tour tour) {

        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(DELETE_ONE_SQL);
        ps.setLong(1, tour.getTourId());
        ps.executeUpdate();
        return this;
    }

    @SneakyThrows
    public TourDao clear() {

        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val statement = connection.createStatement();
        statement.execute(DELETE_ALL_SQL);

        return this;
    }

    @SneakyThrows
    public int count() {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val rs = statement.executeQuery(COUNT_SQL);
        return rs.next() ? rs.getInt(1) : 0;
    }

}