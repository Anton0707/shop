package com.ahohlov.dao.impl;

import com.ahohlov.dao.ProfileDao;
import com.ahohlov.dao.model.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 9/7/18.
 */
public class ProfileDaoImpl extends GenericDaoImpl<Profile> implements ProfileDao{
    private static final Logger logger = LogManager.getLogger(ProfileDaoImpl.class);

    public ProfileDaoImpl(Class<Profile> clazz) {
        super(clazz);
    }

    @Override
    public Profile findProfileById(Connection connection, Long id) {
        return null;
    }

    @Override
    public List<Profile> findAll(Connection connection) {
        return null;
    }
}
