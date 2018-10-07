package com.ahohlov.dao.impl;

import com.ahohlov.dao.UserDao;
import com.ahohlov.dao.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 9/3/18.
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    public UserDaoImpl(Class<User> clazz) {
        super(clazz);
    }

    @Override
    public User findUserByEmail(Connection connection, String email) {
        return null;
    }

    @Override
    public List<User> findAll(Connection connection) {
        return null;
    }
}
