package com.ahohlov.converter.impl;

import com.ahohlov.converter.Converter;
import com.ahohlov.dao.model.Item;
import com.ahohlov.dao.model.Orders;
import com.ahohlov.dao.model.User;
import com.ahohlov.dto.OrderDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by admin on 9/16/18.
 */
public class OrderConverter implements Converter<OrderDTO,Orders>{
    @Override
    public Orders toEntity(OrderDTO dto) {
        UserConverter userConverter = new UserConverter();
        User user = userConverter.toEntity(dto.getUserDTO());
        ItemConverter itemConverter = new ItemConverter();
        Item item = itemConverter.toEntity(dto.getItemDTO());

        Orders orders = new Orders();
        orders.setOrderId(dto.getOrderId());
        orders.setItemId(dto.getItemId());
        orders.setCreated(dto.getCreated());
        orders.setQauntity(dto.getQauntity());

        orders.setUser(user);
        orders.setItem(item);

        return orders;
    }

    @Override
    public List<Orders> toEntityList(List<OrderDTO> list) {
        List<Orders> ordersList = new ArrayList<>();
        for(OrderDTO ls: list){
            ordersList.add(toEntity(ls));
        }
        return ordersList;
    }
}
