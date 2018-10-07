package com.ahohlov.impl;

import com.ahohlov.OrderService;
import com.ahohlov.converter.impl.OrderConverter;
import com.ahohlov.converter.impl.OrderDTOConverter;
import com.ahohlov.dao.OrderDao;
import com.ahohlov.dao.impl.OrderDaoImpl;
import com.ahohlov.dao.model.Orders;
import com.ahohlov.dao.util.HibernateUtil;
import com.ahohlov.dto.OrderDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by admin on 9/16/18.
 */
public class OrderServiceImpl implements OrderService{

    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    private OrderDao orderDao = new OrderDaoImpl(Orders.class);
    private OrderDTOConverter orderDTOConverter = new OrderDTOConverter();
    private OrderConverter orderConverter = new OrderConverter();

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO)
    {
        Session session = orderDao.getCurrentSession();
        try{
            Transaction transaction = session.getTransaction();
            if(!transaction.isActive()){
                session.beginTransaction();
            }
            Orders orders = orderConverter.toEntity(orderDTO);
            orderDao.create(orders);
            transaction.commit();
            return orderDTOConverter.toDTO(orders);
        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            logger.error("Failed to save order", e);
        }
        return orderDTO;
    }

    @Override
    public Orders findOrderById(Long id) {
        return null;
    }

    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
