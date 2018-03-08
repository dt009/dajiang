/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 我的收藏 t_collection
 *
 * @author zhouwd code generator
 */
public class Collection extends BaseDTO {


    private Integer collectionId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 大匠id
     */
    private Integer professionalId;

    /**
     * 收藏时间
     */
    private Date collectionInsertdt;

    /**
     * 获取 t_collection.collection_id
     *
     * @return t_collection.collection_id
     */
    public Integer getCollectionId() {
        return collectionId;
    }

    /**
     * 设置 t_collection.collection_id
     *
     * @param collectionId t_collection.collection_id
     */
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * 获取 用户id t_collection.user_id
     *
     * @return 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 用户id t_collection.user_id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 大匠id t_collection.professional_id
     *
     * @return 大匠id
     */
    public Integer getProfessionalId() {
        return professionalId;
    }

    /**
     * 设置 大匠id t_collection.professional_id
     *
     * @param professionalId 大匠id
     */
    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * 获取 收藏时间 t_collection.collection_insertDT
     *
     * @return 收藏时间
     */
    public Date getCollectionInsertdt() {
        return collectionInsertdt;
    }

    /**
     * 设置 收藏时间 t_collection.collection_insertDT
     *
     * @param collectionInsertdt 收藏时间
     */
    public void setCollectionInsertdt(Date collectionInsertdt) {
        this.collectionInsertdt = collectionInsertdt;
    }
}