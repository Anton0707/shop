package com.ahohlov.dao;

import com.ahohlov.dao.model.Orders;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 9/16/18.
 */
public interface OrderDao extends GenericDao{

    Orders findOrderById(Connection connection, Long id);

    List<Orders> findAll(Connection connection);

    void create(Orders orders);

    void update(Orders orders);

    void delete(Orders orders);
}
