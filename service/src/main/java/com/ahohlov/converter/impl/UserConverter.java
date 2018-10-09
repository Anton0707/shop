package com.ahohlov.converter.impl;

import com.ahohlov.converter.Converter;
import com.ahohlov.dao.model.News;
import com.ahohlov.dao.model.Orders;
import com.ahohlov.dao.model.Profile;
import com.ahohlov.dao.model.User;
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


        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRole(userDTO.getRole());

        user.setProfile(profile);
        profile.setUser(user);
        user.setOrderList(orders);
        user.setNewses(newses);

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
