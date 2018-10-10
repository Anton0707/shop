package com.ahohlov.converter.impl;

import com.ahohlov.converter.Converter;
import com.ahohlov.dao.model.*;
import com.ahohlov.dto.ProfileDTO;
import com.ahohlov.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 9/4/18.
 */
public class UserConverter implements Converter<UserDTO,User> {
    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        ProfileConverter profileConverter = new ProfileConverter();
        Profile profile = profileConverter.toEntity(userDTO.getProfileDTO());
        OrderConverter orderConverter = new OrderConverter();
        List<Orders> orders = orderConverter.toEntityList(userDTO.getOrderDTOList());
        NewsConverter newsConverter = new NewsConverter();
        List<News> newses = newsConverter.toEntityList(userDTO.getNewsDTOList());
        RoleConverter roleConverter = new RoleConverter();
        Role role = roleConverter.toEntity(userDTO.getRoleDTO());


        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());


        user.setProfile(profile);
        profile.setUser(user);
        user.setOrderList(orders);
        user.setNewses(newses);
        user.setRole(role);

        return user;
    }



    @Override
    public List<User> toEntityList(List<UserDTO> list) {
        List<User> users = new ArrayList<>();
        for(UserDTO ls: list){
            users.add(toEntity(ls));
        }
        return users;
    }
}
