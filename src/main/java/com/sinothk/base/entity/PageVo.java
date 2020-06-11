package com.sinothk.base.entity;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * <pre>
 *  创建:  梁玉涛 2019/4/30 on 14:34
 *  项目:  RxRetrofitLib
 *  描述:
 *  更新:
 * <pre>
 */
public class PageVo<T> {

    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;

    private T vo;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getVo() {
        return vo;
    }

    public void setVo(T vo) {
        this.vo = vo;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
