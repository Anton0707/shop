package com.ahohlov.converter.impl;

import com.ahohlov.converter.DTOConverter;
import com.ahohlov.dao.model.Role;
import com.ahohlov.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public class RoleDTOConverter implements DTOConverter<RoleDTO, Role> {
    @Override
    public RoleDTO toDTO(Role entity) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(entity.getRoleId());
        roleDTO.setName(entity.getName());

        return roleDTO;
    }

    @Override
    public List<RoleDTO> toDTOList(List<Role> list) {
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for(Role ls: list){
            roleDTOs.add(toDTO(ls));
        }
        return roleDTOs;
    }
}
