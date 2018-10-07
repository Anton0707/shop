package com.ahohlov.dao;

import com.ahohlov.dao.impl.GenericDaoImpl;
import com.ahohlov.dao.model.Profile;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 9/7/18.
 */
public interface ProfileDao extends GenericDao{

    Profile findProfileById(Connection connection, Long id);

    List<Profile> findAll(Connection connection);

    void create(Profile profile);

    void update(Profile profile);

    void delete(Profile profile);
}
