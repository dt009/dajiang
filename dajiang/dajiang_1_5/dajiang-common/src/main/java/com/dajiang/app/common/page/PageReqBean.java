package com.dajiang.app.common.page;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class PageReqBean<T> extends BaseDTO {

    private int pageNum = 1;

    private int pageSize = 10;

    private T condition;

    public PageReqBean() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (pageSize > 200) {
            return 200;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }
}