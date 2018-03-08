package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class UserBankReqDTO extends BaseDTO {

    private String bankAccName;

    private String bankCode;

    private String bankNo;

    public String getBankAccName() {
        return bankAccName;
    }

    public void setBankAccName(String bankAccName) {
        this.bankAccName = bankAccName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }
}
