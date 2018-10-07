package com.ahohlov.converter;

import java.util.List;

/**
 * Created by admin on 9/4/18.
 */
public interface Converter<D,E> {
    E toEntity(D dto);
    List<E> toEntityList(List<D> list);
}
