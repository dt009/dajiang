/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * @author zhouwd code generator
 */
public class ProductUser extends BaseDTO {
    private Integer productUserId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 授权产品：从谁手里购买;共享
     */
    private Long productUserParentId;

    /**
     * 产品类型：1、共享知识；2、授权知识
     */
    private Byte productType;

    /**
     * 是否当前所有者:0:不是；1：是
     */
    private Byte productUserIsowner;

    /**
     * 插入日期
     */
    private Date productUserInsertDt;

    /**
     * 获取 t_product_user.product_user_id
     *
     * @return t_product_user.product_user_id
     */
    public Integer getProductUserId() {
        return productUserId;
    }

    /**
     * 设置 t_product_user.product_user_id
     *
     * @param productUserId t_product_user.product_user_id
     */
    public void setProductUserId(Integer productUserId) {
        this.productUserId = productUserId;
    }

    /**
     * 获取 用户id t_product_user.user_id
     *
     * @return 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 用户id t_product_user.user_id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 产品id t_product_user.product_id
     *
     * @return 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置 产品id t_product_user.product_id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取 授权产品：从谁手里购买;共享 t_product_user.product_user_parent_id
     *
     * @return 授权产品：从谁手里购买;共享
     */
    public Long getProductUserParentId() {
        return productUserParentId;
    }

    /**
     * 设置 授权产品：从谁手里购买;共享 t_product_user.product_user_parent_id
     *
     * @param productUserParentId 授权产品：从谁手里购买;共享
     */
    public void setProductUserParentId(Long productUserParentId) {
        this.productUserParentId = productUserParentId;
    }

    /**
     * 获取 产品类型：1、共享知识；2、授权知识 t_product_user.product_type
     *
     * @return 产品类型：1、共享知识；2、授权知识
     */
    public Byte getProductType() {
        return productType;
    }

    /**
     * 设置 产品类型：1、共享知识；2、授权知识 t_product_user.product_type
     *
     * @param productType 产品类型：1、共享知识；2、授权知识
     */
    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    /**
     * 获取 是否当前所有者:0:不是；1：是 t_product_user.product_user_isowner
     *
     * @return 是否当前所有者:0:不是；1：是
     */
    public Byte getProductUserIsowner() {
        return productUserIsowner;
    }

    /**
     * 设置 是否当前所有者:0:不是；1：是 t_product_user.product_user_isowner
     *
     * @param productUserIsowner 是否当前所有者:0:不是；1：是
     */
    public void setProductUserIsowner(Byte productUserIsowner) {
        this.productUserIsowner = productUserIsowner;
    }

    /**
     * 获取 插入日期 t_product_user.product_user_insert_dt
     *
     * @return 插入日期
     */
    public Date getProductUserInsertDt() {
        return productUserInsertDt;
    }

    /**
     * 设置 插入日期 t_product_user.product_user_insert_dt
     *
     * @param productUserInsertDt 插入日期
     */
    public void setProductUserInsertDt(Date productUserInsertDt) {
        this.productUserInsertDt = productUserInsertDt;
    }
}