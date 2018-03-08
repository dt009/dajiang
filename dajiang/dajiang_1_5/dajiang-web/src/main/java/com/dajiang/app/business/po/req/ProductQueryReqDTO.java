package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.List;

public class ProductQueryReqDTO extends BaseDTO {

    /**
     * 专家的专业类型
     */
    private List<Integer> professionalTypeIds;

    /**
     * 商品发布类型
     */
    private List<Byte> productStyles;

    /**
     * 最高价格
     */
    private BigDecimal maxPrice;

    /**
     * 最低价格
     */
    private BigDecimal minPrice;

    /**
     * 关键字
     */
    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<Integer> getProfessionalTypeIds() {
        return professionalTypeIds;
    }

    public void setProfessionalTypeIds(List<Integer> professionalTypeIds) {
        this.professionalTypeIds = professionalTypeIds;
    }

    public List<Byte> getProductStyles() {
        return productStyles;
    }

    public void setProductStyles(List<Byte> productStyles) {
        this.productStyles = productStyles;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }
}
