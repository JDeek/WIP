package com.khja021.mapper;

import java.util.List;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public interface Mapper<T, TDto> {
    T fromDto(TDto tDto);

    TDto toDto(T t);

    List<TDto> toDtoList(List<T> ts);

    List<T> fromDtoList(List<TDto> tDtos);
}
