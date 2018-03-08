package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class AccountHisRespDTO extends BaseDTO {

    private Integer accountType;

    private Integer orderId;

    private BigDecimal accountAmount;

    private String accountDesc;

    private Date accountInsertDT;

    private String productTypeName;

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public Date getAccountInsertDT() {
        return accountInsertDT;
    }

    public void setAccountInsertDT(Date accountInsertDT) {
        this.accountInsertDT = accountInsertDT;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
