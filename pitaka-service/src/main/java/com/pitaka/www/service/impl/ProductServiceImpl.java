package com.pitaka.www.service.impl;


import com.pitaka.www.mapper.ProductMapper;
import com.pitaka.www.model.Product;
import com.pitaka.www.service.ProductService;
import com.pitaka.www.utils.ResultUtil;
import com.pitaka.www.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResultUtil findAllProduct() {
        List<Product> productList = productMapper.findAll();
        return  new ResultUtil().success(productList);
    }

    @Override
    public ResultUtil findBySeriesId(Integer seriesId) {
        List<ProductVO> productList = productMapper.selectBySeriesId(seriesId);
        return  new ResultUtil().success(productList);
    }
}
