package com.ahohlov.dao.impl;

import com.ahohlov.dao.NewsDao;
import com.ahohlov.dao.model.News;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public class NewsDaoImpl  extends GenericDaoImpl<News> implements NewsDao {

    private static final Logger logger = LogManager.getLogger(NewsDaoImpl.class);

    public NewsDaoImpl(Class<News> clazz) {
        super(clazz);
    }

    @Override
    public News findNewsById(Connection connection, Long id) {
        return null;
    }

    @Override
    public List<News> findAll(Connection connection) {
        return null;
    }
}
