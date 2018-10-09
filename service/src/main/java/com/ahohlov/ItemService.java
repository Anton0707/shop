package com.ahohlov;

import com.ahohlov.dao.model.Item;
import com.ahohlov.dto.ItemDTO;

import java.util.List;

/**
 * Created by admin on 10/9/18.
 */
public interface ItemService {
    ItemDTO update(ItemDTO itemDTO);

    ItemDTO save(ItemDTO itemDTO);

    Item demoSave(Item item);

    Item findUserByEmail(String email);

    List<Item> findAll();

    void deleteById(Long id);

    Item findItemById(Long id);
}
