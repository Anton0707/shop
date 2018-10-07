package com.ahohlov.converter;

import java.util.List;

/**
 * Created by admin on 9/4/18.
 */
public interface DTOConverter<D,E> {
    D toDTO(E entity);
    List<D> toDTOList(List<E> list);
}