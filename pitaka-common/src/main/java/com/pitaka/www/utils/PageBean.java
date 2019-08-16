package com.pitaka.www.utils;

import java.util.List;

/**
 * 分页工具类,默认为第1页,10条数据
 * @author rx
 * @created 2018-8-10 11:01:51
 * @param <T>
 */
public class PageBean<T> {

    private Integer currentPage=1;
    private Integer currentSize=10;
    private long recordsFiltered;
    private long recordsTotal;
    private List<T> items;

    public PageBean(){}

    public PageBean(Integer currentPage, Integer currentSize, long recordsFiltered){
        super();
        this.currentPage = currentPage;
        this.currentSize = currentSize;
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Integer currentSize) {
        this.currentSize = currentSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
