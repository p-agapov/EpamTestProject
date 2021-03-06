package com.epam.lstr.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

/**
 * Class of Customer entity
 *
 * @author Pavel Agapov
 * @version 1.0
 */

@Data
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Customer {

    int customerId;
    String name;
    String surname;
    boolean isVIP;
    int userId;

    public Customer(String name, String surname, boolean isVIP, int userId) {
        this(0, name, surname, isVIP, userId);
    }
}
