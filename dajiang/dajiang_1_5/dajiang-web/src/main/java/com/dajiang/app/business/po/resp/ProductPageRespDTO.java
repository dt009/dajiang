package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class ProductPageRespDTO extends BaseDTO {


    private Integer productId;

    /**
     * 标题说明
     */
    private String productTitle;

    /**
     * 价格
     */
    private BigDecimal productPrice;

    /**
     * 原创人姓名
     */
    private String productAuthorName;

    /**
     * 产品说明
     */
    private String productDesc;

    /**
     * 购买量
     */
    private Integer orderNum = 0;

    /**
     * 商品类别
     */
    private Byte productStyle;

    /**
     * 商品类别名称
     */
    private String productStyleStr;

    /**
     * 是否拥有该商品
     */
    private Byte haveFlag = 2;

    /**
     * 修改时间
     */
    private Date productUpdatedt;

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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
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

    public Byte getHaveFlag() {
        return haveFlag;
    }

    public void setHaveFlag(Byte haveFlag) {
        this.haveFlag = haveFlag;
    }

    public Date getProductUpdatedt() {
        return productUpdatedt;
    }

    public void setProductUpdatedt(Date productUpdatedt) {
        this.productUpdatedt = productUpdatedt;
    }
}
