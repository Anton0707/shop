package com.ahohlov.impl;

import com.ahohlov.NewsService;
import com.ahohlov.converter.impl.NewsConverter;
import com.ahohlov.converter.impl.NewsDTOConverter;
import com.ahohlov.dao.NewsDao;
import com.ahohlov.dao.impl.NewsDaoImpl;
import com.ahohlov.dao.model.News;
import com.ahohlov.dto.NewsDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public class NewsServiceImpl implements NewsService {

    private static final Logger logger = LogManager.getLogger(NewsServiceImpl.class);

    private NewsDao userDao = new NewsDaoImpl(News.class);
    private NewsDTOConverter userDTOConverter = new NewsDTOConverter();
    private NewsConverter userConverter = new NewsConverter();

    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        return null;
    }

    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        return null;
    }

    @Override
    public News demoSave(News news) {
        return null;
    }

    @Override
    public News findNewsById(Long is) {
        return null;
    }

    @Override
    public List<News> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public News findUserById(Long id) {
        return null;
    }
}
