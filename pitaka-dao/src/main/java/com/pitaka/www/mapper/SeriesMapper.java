package com.pitaka.www.mapper;

import com.pitaka.www.model.Series;

import java.util.List;


public interface SeriesMapper {
    /**
     * 查询所有系列
     * @return
     */
    List<Series> findAll();
}
