package com.ahohlov.dao.impl;

import com.ahohlov.dao.RoleDao;
import com.ahohlov.dao.model.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

    private static final Logger logger = LogManager.getLogger(RoleDaoImpl.class);

    public RoleDaoImpl(Class<Role> clazz) {
        super(clazz);
    }

    @Override
    public Role findRoleById(Connection connection, Long id) {
        return null;
    }

    @Override
    public List<Role> findAll(Connection connection) {
        return null;
    }
}
