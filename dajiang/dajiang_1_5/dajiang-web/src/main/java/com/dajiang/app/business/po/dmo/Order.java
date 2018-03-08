/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息 t_order
 *
 * @author zhouwd code generator
 */
public class Order extends BaseDTO {
    /**
     * 主键自增
     */
    private Integer orderId;

    /**
     * 订单号码
     */
    private String orderCode;

    /**
     * 卖出用户id
     */
    private Long userIdSales;

    /**
     * 购买用户id
     */
    private Long userIdPurchase;

    /**
     * 交易商品id
     */
    private Integer productId;

    private BigDecimal orderAmount;

    /**
     * 佣金
     */
    private BigDecimal orderCommission;

    /**
     * 付款方式：1：微信；2、支付宝；3、银行账户
     */
    private Integer orderPaytype;

    /**
     * 付款返回码
     */
    private String orderPayreturn;

    /**
     * 发生时间
     */
    private Date orderDt;

    /**
     * 获取 主键自增 t_order.order_id
     *
     * @return 主键自增
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置 主键自增 t_order.order_id
     *
     * @param orderId 主键自增
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 订单号码 t_order.order_Code
     *
     * @return 订单号码
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置 订单号码 t_order.order_Code
     *
     * @param orderCode 订单号码
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * 获取 卖出用户id t_order.user_id_sales
     *
     * @return 卖出用户id
     */
    public Long getUserIdSales() {
        return userIdSales;
    }

    /**
     * 设置 卖出用户id t_order.user_id_sales
     *
     * @param userIdSales 卖出用户id
     */
    public void setUserIdSales(Long userIdSales) {
        this.userIdSales = userIdSales;
    }

    /**
     * 获取 购买用户id t_order.user_id_purchase
     *
     * @return 购买用户id
     */
    public Long getUserIdPurchase() {
        return userIdPurchase;
    }

    /**
     * 设置 购买用户id t_order.user_id_purchase
     *
     * @param userIdPurchase 购买用户id
     */
    public void setUserIdPurchase(Long userIdPurchase) {
        this.userIdPurchase = userIdPurchase;
    }

    /**
     * 获取 交易商品id t_order.product_id
     *
     * @return 交易商品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置 交易商品id t_order.product_id
     *
     * @param productId 交易商品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取 t_order.order_amount
     *
     * @return t_order.order_amount
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置 t_order.order_amount
     *
     * @param orderAmount t_order.order_amount
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取 佣金 t_order.order_commission
     *
     * @return 佣金
     */
    public BigDecimal getOrderCommission() {
        return orderCommission;
    }

    /**
     * 设置 佣金 t_order.order_commission
     *
     * @param orderCommission 佣金
     */
    public void setOrderCommission(BigDecimal orderCommission) {
        this.orderCommission = orderCommission;
    }

    /**
     * 获取 付款方式：1：微信；2、支付宝；3、银行账户 t_order.order_paytype
     *
     * @return 付款方式：1：微信；2、支付宝；3、银行账户
     */
    public Integer getOrderPaytype() {
        return orderPaytype;
    }

    /**
     * 设置 付款方式：1：微信；2、支付宝；3、银行账户 t_order.order_paytype
     *
     * @param orderPaytype 付款方式：1：微信；2、支付宝；3、银行账户
     */
    public void setOrderPaytype(Integer orderPaytype) {
        this.orderPaytype = orderPaytype;
    }

    /**
     * 获取 付款返回码 t_order.order_payreturn
     *
     * @return 付款返回码
     */
    public String getOrderPayreturn() {
        return orderPayreturn;
    }

    /**
     * 设置 付款返回码 t_order.order_payreturn
     *
     * @param orderPayreturn 付款返回码
     */
    public void setOrderPayreturn(String orderPayreturn) {
        this.orderPayreturn = orderPayreturn == null ? null : orderPayreturn.trim();
    }

    /**
     * 获取 发生时间 t_order.order_DT
     *
     * @return 发生时间
     */
    public Date getOrderDt() {
        return orderDt;
    }

    /**
     * 设置 发生时间 t_order.order_DT
     *
     * @param orderDt 发生时间
     */
    public void setOrderDt(Date orderDt) {
        this.orderDt = orderDt;
    }
}