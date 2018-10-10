package com.ahohlov.converter.impl;

import com.ahohlov.converter.DTOConverter;
import com.ahohlov.dao.model.Orders;
import com.ahohlov.dao.model.User;
import com.ahohlov.dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 9/5/18.
 */
public class UserDTOConverter implements DTOConverter<UserDTO,User>{

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        ProfileDTOConverter profileDTOConverter = new ProfileDTOConverter();
        ProfileDTO profileDTO = profileDTOConverter.toDTO(user.getProfile());
        OrderDTOConverter orderDTOConverter = new OrderDTOConverter();
        List<OrderDTO> orderDTOs = orderDTOConverter.toDTOList(user.getOrderList());
        NewsDTOConverter newsDTOConverter = new NewsDTOConverter();
        List<NewsDTO> newsDTOs = newsDTOConverter.toDTOList(user.getNewses());
        RoleDTOConverter roleDTOConverter = new RoleDTOConverter();
        RoleDTO roleDTO = roleDTOConverter.toDTO(user.getRole());



        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());


        userDTO.setProfileDTO(profileDTO);
        profileDTO.setUserDTO(userDTO);
        userDTO.setOrderDTOList(orderDTOs);
        userDTO.setNewsDTOList(newsDTOs);
        userDTO.setRoleDTO(roleDTO);
        
        return userDTO;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> list) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User ls: list){
            userDTOs.add(toDTO(ls));
        }
        return userDTOs;
    }
}
