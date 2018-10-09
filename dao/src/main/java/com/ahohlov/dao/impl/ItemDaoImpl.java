package com.ahohlov.dao.impl;

import com.ahohlov.dao.ItemDao;
import com.ahohlov.dao.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 10/9/18.
 */
public class ItemDaoImpl  extends GenericDaoImpl<Item> implements ItemDao {

    private static final Logger logger = LogManager.getLogger(ItemDaoImpl.class);

    public ItemDaoImpl(Class<Item> clazz) {
        super(clazz);
    }

    @Override
    public Item findItemById(Connection connection, Long id) {
        return null;
    }

    @Override
    public List<Item> findAll(Connection connection) {
        return null;
    }
}
