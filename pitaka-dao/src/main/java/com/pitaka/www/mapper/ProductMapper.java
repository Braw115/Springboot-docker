package com.pitaka.www.mapper;

import com.pitaka.www.model.Product;
import com.pitaka.www.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    /**
     * 查询所有产品
     * @return
     */
    List<Product> findAll();

    /**
     * 按系列id查询产品
     * @param seriesId
     * @return
     */
    List<ProductVO> selectBySeriesId(@Param("seriesId") Integer seriesId);

}
