package com.ahohlov.impl;

import com.ahohlov.ItemService;
import com.ahohlov.converter.impl.ItemConverter;
import com.ahohlov.converter.impl.ItemDTOConverter;
import com.ahohlov.dao.ItemDao;
import com.ahohlov.dao.impl.ItemDaoImpl;
import com.ahohlov.dao.model.Item;
import com.ahohlov.dto.ItemDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by admin on 10/9/18.
 */
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LogManager.getLogger(ItemServiceImpl.class);

    private ItemDao userDao = new ItemDaoImpl(Item.class);
    private ItemDTOConverter userDTOConverter = new ItemDTOConverter();
    private ItemConverter userConverter = new ItemConverter();

    @Override
    public ItemDTO update(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public Item demoSave(Item item) {
        return null;
    }

    @Override
    public Item findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Item findItemById(Long id) {
        return null;
    }
}
