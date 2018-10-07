package com.ahohlov.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 9/3/18.
 */
public interface GenericDao<T extends Serializable> {
    T findOne(final long entityId);
    List<T> findAll();
    void deleteById(final long entityId);
    Session getCurrentSession();
}
