package com.course.server.vo;

import java.util.List;

public class PageVO<T> {

    /**
     * 前端传入数据
     */

    /**
     * 当前页码
     */
    protected int page;

    /**
     * 每条页数
     */
    protected int size;

    /**
     * 后端查询完成后的数据
     */

    /**
     * 总条数
     */
    protected long total;

    /**
     * 当前页的数据
     */
    protected List<T> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
