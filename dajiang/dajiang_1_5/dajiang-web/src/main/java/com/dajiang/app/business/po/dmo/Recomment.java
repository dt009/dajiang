/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 推荐大匠 banner t_recomment
 *
 * @author zhouwd code generator
 */
public class Recomment extends BaseDTO {

    private Integer recommentId;

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

    /**
     * 插入时间
     */
    private Date recommentInsertdt;

    /**
     * 修改时间
     */
    private Date recommentUpdatedt;

    /**
     * 获取 t_recomment.recomment_id
     *
     * @return t_recomment.recomment_id
     */
    public Integer getRecommentId() {
        return recommentId;
    }

    /**
     * 设置 t_recomment.recomment_id
     *
     * @param recommentId t_recomment.recomment_id
     */
    public void setRecommentId(Integer recommentId) {
        this.recommentId = recommentId;
    }

    /**
     * 获取 推荐顺序 t_recomment.recomment_sort
     *
     * @return 推荐顺序
     */
    public Integer getRecommentSort() {
        return recommentSort;
    }

    /**
     * 设置 推荐顺序 t_recomment.recomment_sort
     *
     * @param recommentSort 推荐顺序
     */
    public void setRecommentSort(Integer recommentSort) {
        this.recommentSort = recommentSort;
    }

    /**
     * 获取 推荐大匠图片地址 t_recomment.recomment_imag_path
     *
     * @return 推荐大匠图片地址
     */
    public String getRecommentImagPath() {
        return recommentImagPath;
    }

    /**
     * 设置 推荐大匠图片地址 t_recomment.recomment_imag_path
     *
     * @param recommentImagPath 推荐大匠图片地址
     */
    public void setRecommentImagPath(String recommentImagPath) {
        this.recommentImagPath = recommentImagPath == null ? null : recommentImagPath.trim();
    }

    /**
     * 获取 推荐链接地址 t_recomment.recomment_url
     *
     * @return 推荐链接地址
     */
    public String getRecommentUrl() {
        return recommentUrl;
    }

    /**
     * 设置 推荐链接地址 t_recomment.recomment_url
     *
     * @param recommentUrl 推荐链接地址
     */
    public void setRecommentUrl(String recommentUrl) {
        this.recommentUrl = recommentUrl == null ? null : recommentUrl.trim();
    }

    /**
     * 获取 插入时间 t_recomment.recomment_insertDT
     *
     * @return 插入时间
     */
    public Date getRecommentInsertdt() {
        return recommentInsertdt;
    }

    /**
     * 设置 插入时间 t_recomment.recomment_insertDT
     *
     * @param recommentInsertdt 插入时间
     */
    public void setRecommentInsertdt(Date recommentInsertdt) {
        this.recommentInsertdt = recommentInsertdt;
    }

    /**
     * 获取 修改时间 t_recomment.recomment_updateDT
     *
     * @return 修改时间
     */
    public Date getRecommentUpdatedt() {
        return recommentUpdatedt;
    }

    /**
     * 设置 修改时间 t_recomment.recomment_updateDT
     *
     * @param recommentUpdatedt 修改时间
     */
    public void setRecommentUpdatedt(Date recommentUpdatedt) {
        this.recommentUpdatedt = recommentUpdatedt;
    }
}