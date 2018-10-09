package com.ahohlov.converter.impl;

import com.ahohlov.converter.DTOConverter;
import com.ahohlov.dao.model.Orders;
import com.ahohlov.dao.model.User;
import com.ahohlov.dto.ItemDTO;
import com.ahohlov.dto.OrderDTO;
import com.ahohlov.dto.UserDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 9/16/18.
 */
public class OrderDTOConverter implements DTOConverter<OrderDTO,Orders>{
    @Override
    public OrderDTO toDTO(Orders entity) {
        UserDTOConverter userConverter = new UserDTOConverter();
        UserDTO userDTO = userConverter.toDTO(entity.getUser());
        ItemDTOConverter itemDTOConverter = new ItemDTOConverter();
        ItemDTO itemDTO = itemDTOConverter.toDTO(entity.getItem());

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(entity.getOrderId());
        orderDTO.setItemId(entity.getItemId());
        orderDTO.setCreated(entity.getCreated());
        orderDTO.setQauntity(entity.getQauntity());

        orderDTO.setUserDTO(userDTO);
        orderDTO.setItemDTO(itemDTO);

        return orderDTO;
    }

    @Override
    public List<OrderDTO> toDTOList(List<Orders> list) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(Orders ls: list){
            orderDTOList.add(toDTO(ls));
        }
        return orderDTOList;
    }
}