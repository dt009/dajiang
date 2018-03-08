package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCartRespDTO extends BaseDTO {

    private Integer shoppingcartId;

    private Long userId;

    private Integer productId;

    private String productTitle;

    /**
     * 原创作者
     */
    private String productAuthorName;

    /**
     * 商品描述
     */
    private String productDesc;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 是否拥有该商品
     */
    private Byte haveFlag = 2;

    /**
     * 购买数量
     */
    private Integer orderNum = 0;

    /**
     * 商品种类编码：专利，图文，视频
     */
    private Byte productStyle;

    /**
     * 商品种类名称：专利，图文，视频
     */
    private String productStyleStr;

    private Date shoppingcartInsertdt;

    /**
     * 如果有对话，修改该值
     */
    private Date shoppingcartUpdatedt;


    public Integer getShoppingcartId() {
        return shoppingcartId;
    }

    public void setShoppingcartId(Integer shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductAuthorName() {
        return productAuthorName;
    }

    public void setProductAuthorName(String productAuthorName) {
        this.productAuthorName = productAuthorName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Byte getHaveFlag() {
        return haveFlag;
    }

    public void setHaveFlag(Byte haveFlag) {
        this.haveFlag = haveFlag;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Byte getProductStyle() {
        return productStyle;
    }

    public void setProductStyle(Byte productStyle) {
        this.productStyle = productStyle;
    }

    public String getProductStyleStr() {
        return productStyleStr;
    }

    public void setProductStyleStr(String productStyleStr) {
        this.productStyleStr = productStyleStr;
    }

    public Date getShoppingcartInsertdt() {
        return shoppingcartInsertdt;
    }

    public void setShoppingcartInsertdt(Date shoppingcartInsertdt) {
        this.shoppingcartInsertdt = shoppingcartInsertdt;
    }

    public Date getShoppingcartUpdatedt() {
        return shoppingcartUpdatedt;
    }

    public void setShoppingcartUpdatedt(Date shoppingcartUpdatedt) {
        this.shoppingcartUpdatedt = shoppingcartUpdatedt;
    }
}
