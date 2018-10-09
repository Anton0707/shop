package com.ahohlov.converter.impl;

import com.ahohlov.converter.DTOConverter;
import com.ahohlov.dao.model.News;
import com.ahohlov.dto.NewsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public class NewsDTOConverter implements DTOConverter <NewsDTO, News> {
    @Override
    public NewsDTO toDTO(News entity) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setNewsId(entity.getNewsId());
        newsDTO.setTitle(entity.getTitle());
        newsDTO.setContent(entity.getContent());
        newsDTO.setCreated(entity.getCreated());

        return newsDTO;
    }

    @Override
    public List<NewsDTO> toDTOList(List<News> list) {
        List<NewsDTO> newses = new ArrayList<>();
        for(News ls: list){
            newses.add(toDTO(ls));
        }
        return newses;
    }
}
