package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;

public class ProductReqDTO extends BaseDTO {

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 价格
     */
    private BigDecimal productPrice;

    /**
     * 产品类型：1、共享知识；2、授权知识
     */
    private Byte productType;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }
}
