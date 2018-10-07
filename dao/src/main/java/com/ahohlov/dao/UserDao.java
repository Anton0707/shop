package com.ahohlov.dao;

import com.ahohlov.dao.model.User;

import java.sql.Connection;
import java.util.List;



public interface UserDao extends GenericDao {


    User findUserByEmail(Connection connection, String email);

    List<User> findAll(Connection connection);

    void create(User user);

    void update(User user);

    void delete(User user);
}
