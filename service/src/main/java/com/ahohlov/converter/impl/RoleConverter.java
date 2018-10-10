package com.ahohlov.converter.impl;

import com.ahohlov.converter.Converter;
import com.ahohlov.dao.model.Role;
import com.ahohlov.dao.model.User;
import com.ahohlov.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public class RoleConverter implements Converter<RoleDTO, Role> {

    @Override
    public Role toEntity(RoleDTO dto) {
        UserConverter userConverter = new UserConverter();
        User user = userConverter.toEntity(dto.getUserDTO());
        Role role = new Role();
        role.setRoleId(dto.getRoleId());
        role.setName(dto.getName());

        return role;
    }

    @Override
    public List<Role> toEntityList(List<RoleDTO> list) {
        List<Role> roles = new ArrayList<>();
        for(RoleDTO ls: list){
            roles.add(toEntity(ls));
        }
        return roles;
    }
}
