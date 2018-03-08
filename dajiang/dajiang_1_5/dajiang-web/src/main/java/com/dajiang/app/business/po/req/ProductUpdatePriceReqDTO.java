package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;

public class ProductUpdatePriceReqDTO extends BaseDTO {

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 价格
     */
    private BigDecimal productPrice;

    /**
     * 产品类型：1 共享； 2 授权
     */
    private Byte productType;

    /**
     * 产品状态：5：保存，不上架（无需审核）；6：保存并上架
     */
    private Byte productStatus;

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

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }
}
