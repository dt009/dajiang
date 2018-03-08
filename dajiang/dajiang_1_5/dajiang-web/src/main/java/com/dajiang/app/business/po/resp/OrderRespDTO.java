package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class OrderRespDTO extends BaseDTO {


    /**
     * 主键自增
     */
    private Integer orderId;

    /**
     * 订单号码
     */
    private String orderCode;

    /**
     * 购买用户ID
     */
    private Long userIdBuyer;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 交易商品
     */
    private String productTitle;


    /**
     * 购买金额
     */
    private BigDecimal orderAmount;


    /**
     * 付款方式：1：微信；2、支付宝；3、银行账户
     */
    private Integer orderPaytype;


    /**
     * 发生时间
     */
    private Date orderDt;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderPaytype() {
        return orderPaytype;
    }

    public void setOrderPaytype(Integer orderPaytype) {
        this.orderPaytype = orderPaytype;
    }

    public Date getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(Date orderDt) {
        this.orderDt = orderDt;
    }

    /**
     * 获取 购买用户ID
     */
    public Long getUserIdBuyer() {
        return this.userIdBuyer;
    }

    /**
     * 设置 购买用户ID
     */
    public void setUserIdBuyer(Long userIdBuyer) {
        this.userIdBuyer = userIdBuyer;
    }

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
}
