package io.github.jacksonhua.web.response;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private long pageSize = -1;
    private long total;
    private long page = 0;
    private List<T> data;

    public static <T> Page<T> of(com.github.pagehelper.Page<T> result) {
        Page<T> pageData = new Page<>();
        pageData.setData(result.getResult());
        pageData.setTotal(result.getTotal());
        pageData.setPage(result.getPageNum());
        pageData.setPageSize(result.getPageSize());
        return pageData;
    }

    public static <T> Page<T> of(com.baomidou.mybatisplus.core.metadata.IPage<T> result) {
        Page<T> pageData = new Page<>();
        pageData.setData(result.getRecords());
        pageData.setTotal(result.getTotal());
        pageData.setPage(result.getCurrent());
        pageData.setPageSize(result.getSize());
        return pageData;
    }
    public static <T> Page<T> data(List<T> data) {
        Page<T> pageData = new Page<>();
        pageData.setData(data);
        return pageData;
    }



}