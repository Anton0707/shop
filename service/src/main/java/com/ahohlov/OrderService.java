package com.ahohlov;

import com.ahohlov.dao.model.Orders;
import com.ahohlov.dto.OrderDTO;

import java.util.List;

/**
 * Created by admin on 9/16/18.
 */
public interface OrderService {
    OrderDTO update(OrderDTO orderDTO);

    OrderDTO save(OrderDTO orderDTO);

    Orders findOrderById(Long id);

    List<Orders> findAll();

    void deleteById(Long id);
}
