package com.ahohlov.dao;

import com.ahohlov.dao.model.Item;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 10/9/18.
 */
public interface ItemDao extends GenericDao {

    Item findItemById(Connection connection, Long id);

    List<Item> findAll(Connection connection);

    void create(Item item);

    void update(Item item);

    void delete(Item item);
}
