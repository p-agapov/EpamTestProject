package com.epam.lstr.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private int id;
    private String login;
    private String password;
    private String role;

    public User(String login, String password, String role) {
        this(0, login, password, role);
    }
}
