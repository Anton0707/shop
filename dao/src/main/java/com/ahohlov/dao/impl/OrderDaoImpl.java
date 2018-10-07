package com.ahohlov.dao.impl;


import com.ahohlov.dao.OrderDao;
import com.ahohlov.dao.model.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 9/16/18.
 */
public class OrderDaoImpl extends GenericDaoImpl<Orders> implements OrderDao{

    private static final Logger logger = LogManager.getLogger(OrderDaoImpl.class);

    public OrderDaoImpl(Class<Orders> clazz) {
        super(clazz);
    }

    @Override
    public Orders findOrderById(Connection connection, Long id) {
        return null;
    }

    @Override
    public List<Orders> findAll(Connection connection) {
        return null;
    }
}
