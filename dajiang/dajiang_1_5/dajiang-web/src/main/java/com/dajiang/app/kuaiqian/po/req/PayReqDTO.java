package com.dajiang.app.kuaiqian.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;

public class PayReqDTO extends BaseDTO {

    /**
     * order Id
     */
    private Integer orderId;

    /**
     * 购买用户的ID
     */
    private Integer userIdBuyer;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 商品数量。默认为1
     */
    private Integer productNum = 1;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品数量
     */
    private String orderNum;

    /**
     * 支付金额
     */
    private BigDecimal orderAmount;


    /**
     * 订单时间
     */
    private String orderTime;

    /**
     * 获取 商品ID
     */
    public Integer getProductId() {
        return this.productId;
    }

    /**
     * 设置 商品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取 商品数量。默认为1
     */
    public Integer getProductNum() {
        return this.productNum;
    }

    /**
     * 设置 商品数量。默认为1
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    /**
     * 获取 商品名称
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取 商品数量
     */
    public String getOrderNum() {
        return this.orderNum;
    }

    /**
     * 设置 商品数量
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取 支付金额
     */
    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    /**
     * 设置 支付金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取 订单时间
     */
    public String getOrderTime() {
        return this.orderTime;
    }

    /**
     * 设置 订单时间
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取 order Id
     */
    public Integer getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 order Id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    /**
     * 获取 购买用户的ID
     */
    public Integer getUserIdBuyer() {
        return this.userIdBuyer;
    }

    /**
     * 设置 购买用户的ID
     */
    public void setUserIdBuyer(Integer userIdBuyer) {
        this.userIdBuyer = userIdBuyer;
    }
}
