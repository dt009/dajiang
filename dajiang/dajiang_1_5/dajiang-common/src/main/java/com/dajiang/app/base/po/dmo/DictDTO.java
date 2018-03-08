package com.dajiang.app.base.po.dmo;

/**
 * Created by Joe on 2017/9/23.
 */
public class DictDTO extends BaseDTO {

    private Integer itemCode;

    private String itemValue;

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
