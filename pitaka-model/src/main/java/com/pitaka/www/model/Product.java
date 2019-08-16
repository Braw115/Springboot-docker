package com.pitaka.www.model;

/**
 * 产品类
 */
public class Product {
    private Integer id;
    private String  productName;    //产品名称
    private Integer seriesId;   //所属系列id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }
}
