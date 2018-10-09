package com.ahohlov.dao;

import com.ahohlov.dao.model.News;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 10/10/18.
 */
public interface NewsDao extends GenericDao {
    News findNewsById(Connection connection, Long id);

    List<News> findAll(Connection connection);

    void create(News news);

    void update(News news);

    void delete(News news);
}
