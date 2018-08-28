package com.epam.lstr.dao.impl;

import com.epam.lstr.dao.ConnectionPool;
import com.epam.lstr.dao.UserDao;
import com.epam.lstr.model.User;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDaoImpl implements UserDao {
    private static final String INSERT_SQL = "insert into users (login, password, role) values (?, ?, ?)";
    private static final String FIND_SQL = "select user_id, login, password, role from users where user_id = ?";
    private static final String FIND_BY_LOGIN_PASS_SQL = "select user_id, login, password, role from users where login = ? and password = ?";
    private static final String FIND_ALL_SQL = "select user_id, login, password, role from users";
    private static final String UPDATE_SQL = "update users set login = ?, password = ?, role = ? where user_id = ?";
    private static final String GETROLE_SQL = "select role from users where user_id = ?";
    private static final String DELETE_SQL = "delete from users where user_id = ?";
    private static final String DELETE_ALL_SQL = "delete from users";
    private static final String COUNT_SQL = "select count(user_id) from users";


    private static final String ID_FIELD = "user_id";
    private static final String LOGIN_FIELD = "login";
    private static final String PASS_FIELD = "password";
    private static final String ROLE_FIELD = "role";

//    @SneakyThrows
//    public boolean ifUserExist(String) {
//
//        return false;
//    }

    @SneakyThrows
    public User insertUser(@NonNull User u) {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(INSERT_SQL, RETURN_GENERATED_KEYS);
        ps.setString(1, u.getLogin());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getRole());
        ps.executeUpdate();
        @Cleanup val rs = ps.getGeneratedKeys();
        if (!rs.next())
            throw new NullPointerException("Key was not generated!");
        u.setId(rs.getInt(1));
        return u;
    }

    @NonNull
    @SneakyThrows
    public User findUser(int id) {
        int userId = 0;
        String login = null;
        String password = null;
        String role = null;
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(FIND_SQL);
        ps.setLong(1, id);
        @Cleanup ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            userId = rs.getInt(1);
            login = rs.getString(2);
            password = rs.getString(3);
            role = rs.getString(4);
        }
        return new User(userId, login, password, role);
    }

    @SneakyThrows
    @Override
    public User findByLogPas(String login, String password) {

        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(FIND_BY_LOGIN_PASS_SQL);
        ps.setString(1, login);
        ps.setString(2, password);

        @Cleanup ResultSet rs = ps.executeQuery();

        return rs.next() ?
                new User(rs.getInt(ID_FIELD),
                        rs.getString(LOGIN_FIELD),
                        rs.getString(PASS_FIELD),
                        rs.getString(ROLE_FIELD))
                : null;
    }

    @NonNull
    @SneakyThrows
    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(FIND_ALL_SQL);
        @Cleanup ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new User(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)));
        }
        return list;
    }

    @SneakyThrows
    public boolean updateUser(@NonNull User u) {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(UPDATE_SQL);
        preparedStatement.setString(1, u.getLogin());
        preparedStatement.setString(2, u.getPassword());
        preparedStatement.setString(3, u.getRole());
        preparedStatement.setLong(4, u.getId());
        int countRows = preparedStatement.executeUpdate();
        return countRows == 1;
    }

    @NonNull
    @SneakyThrows
    public String getUserRole(int id) {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val ps = connection.prepareStatement(GETROLE_SQL);
        ps.setLong(1, id);
        @Cleanup ResultSet rs = ps.executeQuery();
        String role = "";
        while (rs.next()) {
            role = rs.getString(1);
        }
        return role;
    }

    @SneakyThrows
    public boolean deleteUser(int id) {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(DELETE_SQL);
        preparedStatement.setLong(1, id);
        int countRows = preparedStatement.executeUpdate();
        return countRows == 1;
    }

    @SneakyThrows
    public boolean deleteAllUsers() {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val preparedStatement = connection.prepareStatement(DELETE_ALL_SQL);
        int countRows = preparedStatement.executeUpdate();
        return countRows > 0;
    }

    @SneakyThrows
    public int countAllUsers() {
        @Cleanup val connection = ConnectionPool.getConnection();
        @Cleanup val statement = connection.createStatement();
        @Cleanup val resultSet = statement.executeQuery(COUNT_SQL);
        return resultSet.next() ? resultSet.getInt(1) : 0;
    }
}
