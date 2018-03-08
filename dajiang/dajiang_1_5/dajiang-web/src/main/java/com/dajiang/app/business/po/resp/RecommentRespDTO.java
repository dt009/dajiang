package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class RecommentRespDTO extends BaseDTO {

    /**
     * 推荐顺序
     */
    private Integer recommentSort;

    /**
     * 推荐大匠图片地址
     */
    private String recommentImagPath;

    /**
     * 推荐链接地址
     */
    private String recommentUrl;

    public Integer getRecommentSort() {
        return recommentSort;
    }

    public void setRecommentSort(Integer recommentSort) {
        this.recommentSort = recommentSort;
    }

    public String getRecommentImagPath() {
        return recommentImagPath;
    }

    public void setRecommentImagPath(String recommentImagPath) {
        this.recommentImagPath = recommentImagPath;
    }

    public String getRecommentUrl() {
        return recommentUrl;
    }

    public void setRecommentUrl(String recommentUrl) {
        this.recommentUrl = recommentUrl;
    }
}
