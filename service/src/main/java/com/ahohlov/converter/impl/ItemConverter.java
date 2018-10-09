package com.ahohlov.converter.impl;

import com.ahohlov.converter.Converter;
import com.ahohlov.dao.model.Item;
import com.ahohlov.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/9/18.
 */
public class ItemConverter implements Converter<ItemDTO, Item> {
    @Override
    public Item toEntity(ItemDTO dto) {
        Item item = new Item();
        item.setItemId(dto.getItemId());
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setUniqueNumber(dto.getUniqueNumber());
        item.setPrice(dto.getPrice());
        return item;
    }

    @Override
    public List<Item> toEntityList(List<ItemDTO> list) {
        List<Item> items = new ArrayList<>();
        for(ItemDTO ls: list){
            items.add(toEntity(ls));
        }
        return items;
    }
}
