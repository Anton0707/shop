package com.ahohlov;

import com.ahohlov.converter.impl.UserDTOConverter;
import com.ahohlov.dao.model.Orders;
import com.ahohlov.dao.model.Profile;
import com.ahohlov.dao.model.RoleEnum;
import com.ahohlov.dao.model.User;
import com.ahohlov.dao.util.HibernateUtil;
import com.ahohlov.impl.UserServiceImpl;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by admin on 10/1/18.
 */
public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        UserDTOConverter userDTOConverter = new UserDTOConverter();
        List<Orders> list = new ArrayList<>();


        Profile profile = new Profile("1","1");
        User user = new User("1","1","1","1",RoleEnum.USER, null, null);
        Orders orders = new Orders(LocalDateTime.now(),2L, 2, null);
        list.add(orders);

        user.setOrderList(list);
        orders.setUser(user);

        user.setProfile(profile);
        profile.setUser(user);

        userService.demoSave(user);

        user.setFirstName("2");
        userService.demoUpdate(user, 1L);
    }
}
