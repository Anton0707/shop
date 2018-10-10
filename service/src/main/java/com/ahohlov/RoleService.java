package com.ahohlov;

import com.ahohlov.dao.model.Role;
import com.ahohlov.dto.RoleDTO;

import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public interface RoleService {

    RoleDTO update(RoleDTO roleDTO);

    RoleDTO save(RoleDTO roleDTO);

    Role findRoleById(Long id);

    List<Role> findAll();

    void deleteById(Long id);

}
