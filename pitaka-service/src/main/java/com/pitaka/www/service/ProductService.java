package com.pitaka.www.service;


import com.pitaka.www.utils.ResultUtil;
public interface ProductService {





    /**
     * 查询所有产品
     * @return
     */
    ResultUtil findAllProduct();

    /**
     * 按系列id查询产品
     * @param seriesId
     * @return
     */

    ResultUtil findBySeriesId(Integer seriesId);

}
