package com.ahohlov.converter.impl;

import com.ahohlov.converter.Converter;
import com.ahohlov.dao.model.News;
import com.ahohlov.dto.NewsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public class NewsConverter implements Converter <NewsDTO, News> {
    @Override
    public News toEntity(NewsDTO dto) {
        News news = new News();
        news.setNewsId(dto.getNewsId());
        news.setTitle(dto.getTitle());
        news.setContent(dto.getContent());
        news.setCreated(dto.getCreated());

        return news;
    }

    @Override
    public List<News> toEntityList(List<NewsDTO> list) {
        List<News> newses = new ArrayList<>();
        for(NewsDTO ls: list){
            newses.add(toEntity(ls));
        }
        return newses;
    }
}
