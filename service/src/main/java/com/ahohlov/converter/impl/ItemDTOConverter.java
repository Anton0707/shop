package com.ahohlov.converter.impl;

import com.ahohlov.converter.DTOConverter;
import com.ahohlov.dao.model.Item;
import com.ahohlov.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/9/18.
 */
public class ItemDTOConverter implements DTOConverter<ItemDTO, Item> {
    @Override
    public ItemDTO toDTO(Item entity) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemId(entity.getItemId());
        itemDTO.setName(entity.getName());
        itemDTO.setDescription(entity.getDescription());
        itemDTO.setUniqueNumber(entity.getUniqueNumber());
        itemDTO.setPrice(entity.getPrice());
        return itemDTO;
    }

    @Override
    public List<ItemDTO> toDTOList(List<Item> list) {
        List<ItemDTO> itemDTOs = new ArrayList<>();
        for(Item ls: list){
            itemDTOs.add(toDTO(ls));
        }
        return itemDTOs;
    }
}
