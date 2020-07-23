package com.sinothk.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <pre>
 *  创建:  梁玉涛 2019/4/30 on 14:34
 *  项目:  RxRetrofitLib
 *  描述:
 *  更新:
 * <pre>
 */
@ApiModel(description = "分页结构")
public class PageData<T> {

    @ApiModelProperty(value = "当前页")
    private long pageNum;

    @ApiModelProperty(value = "每页的数量")
    private long pageSize;

    @ApiModelProperty(value = "当然页")
    private long current;

    @ApiModelProperty(value = "总条数")
    private long total;

    @ApiModelProperty(value = "是否有上一页")
    private boolean hasPrevious;

    @ApiModelProperty(value = "是否有下一页")
    private boolean hasNext;

    @ApiModelProperty(value = "结果对象")
    private List<T> data;


    public PageData() {
    }

    public PageData(List<T> data, boolean hasNext) {
        this.hasNext = hasNext;
        this.data = data;
    }
//    public PageData(boolean hasNext, List<T> data) {
//        this.hasNext = hasNext;
//        this.data = data;
//    }

    // ===================================================================
    //是否有下一页
    @Deprecated
    private boolean hasMore;

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
