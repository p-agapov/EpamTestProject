package com.epam.lstr.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tour {

    int tourId;
    String name;
    int price;
    boolean isHot;
    int discount;

    public Tour(String name, int price, boolean isHot, int discount) {
        this.name = name;
        this.price = price;
        this.isHot = isHot;
        this.discount = discount;
    }

    public Tour(int id) {
        this.tourId = id;
    }
}
