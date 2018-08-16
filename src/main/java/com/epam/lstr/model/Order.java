package com.epam.lstr.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int orderId;
    private int customerId;
    private int tourId;
    private boolean isPaid;

    public Order(int customerId, int tourId, boolean isPaid) {
        this.customerId = customerId;
        this.tourId = tourId;
        this.isPaid = isPaid;
    }
}
