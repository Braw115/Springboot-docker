package com.pitaka.www.service.impl;


import com.pitaka.www.mapper.SeriesMapper;
import com.pitaka.www.model.Series;
import com.pitaka.www.service.SeriesService;
import com.pitaka.www.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SeriesServiceImpl implements SeriesService {
    @Autowired
    private SeriesMapper seriesMapper;

    @Override
    public ResultUtil findAllSeries() {
        List<Series> seriesList = seriesMapper.findAll();
        return new ResultUtil().success(seriesList);
    }

}
