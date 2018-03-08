/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 有意向购买 t_shoppingcart
 *
 * @author zhouwd code generator
 */
public class ShoppingCart extends BaseDTO {
    private Integer shoppingcartId;

    private Long userId;

    private Integer productId;

    private Date shoppingcartInsertdt;

    /**
     * 如果有对话，修改该值
     */
    private Date shoppingcartUpdatedt;

    /**
     * 获取 t_shoppingcart.shoppingcart_id
     *
     * @return t_shoppingcart.shoppingcart_id
     */
    public Integer getShoppingcartId() {
        return shoppingcartId;
    }

    /**
     * 设置 t_shoppingcart.shoppingcart_id
     *
     * @param shoppingcartId t_shoppingcart.shoppingcart_id
     */
    public void setShoppingcartId(Integer shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    /**
     * 获取 t_shoppingcart.user_id
     *
     * @return t_shoppingcart.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 t_shoppingcart.user_id
     *
     * @param userId t_shoppingcart.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 t_shoppingcart.product_id
     *
     * @return t_shoppingcart.product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置 t_shoppingcart.product_id
     *
     * @param productId t_shoppingcart.product_id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取 t_shoppingcart.shoppingcart_insertDT
     *
     * @return t_shoppingcart.shoppingcart_insertDT
     */
    public Date getShoppingcartInsertdt() {
        return shoppingcartInsertdt;
    }

    /**
     * 设置 t_shoppingcart.shoppingcart_insertDT
     *
     * @param shoppingcartInsertdt t_shoppingcart.shoppingcart_insertDT
     */
    public void setShoppingcartInsertdt(Date shoppingcartInsertdt) {
        this.shoppingcartInsertdt = shoppingcartInsertdt;
    }

    /**
     * 获取 如果有对话，修改该值 t_shoppingcart.shoppingcart_updateDT
     *
     * @return 如果有对话，修改该值
     */
    public Date getShoppingcartUpdatedt() {
        return shoppingcartUpdatedt;
    }

    /**
     * 设置 如果有对话，修改该值 t_shoppingcart.shoppingcart_updateDT
     *
     * @param shoppingcartUpdatedt 如果有对话，修改该值
     */
    public void setShoppingcartUpdatedt(Date shoppingcartUpdatedt) {
        this.shoppingcartUpdatedt = shoppingcartUpdatedt;
    }
}