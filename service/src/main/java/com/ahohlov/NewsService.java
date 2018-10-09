package com.ahohlov;

import com.ahohlov.dao.model.News;
import com.ahohlov.dto.NewsDTO;

import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public interface NewsService {

    NewsDTO update(NewsDTO newsDTO);

    NewsDTO save(NewsDTO newsDTO);

    News demoSave(News news);

    News findNewsById(Long is);

    List<News> findAll();

    void deleteById(Long id);

    News findUserById(Long id);
}
