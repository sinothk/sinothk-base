package com.sinothk.base.entity;

/**
 * <pre>
 *  创建:  梁玉涛 2019/4/30 on 14:34
 *  项目:  RxRetrofitLib
 *  描述:
 *  更新:
 * <pre>
 */
public class PageData<T> {
    
	//当前页
    private int pageNum;
    //每页的数量
    private int pageSize;

    //是否有下一页
    private boolean hasMore;

    private T data;

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

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
