package com.ahohlov.dao;

import com.ahohlov.dao.model.Role;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public interface RoleDao extends GenericDao {
    Role findRoleById(Connection connection, Long id);

    List<Role> findAll(Connection connection);

    void create(Role role);

    void update(Role role);

    void delete(Role role);
}
