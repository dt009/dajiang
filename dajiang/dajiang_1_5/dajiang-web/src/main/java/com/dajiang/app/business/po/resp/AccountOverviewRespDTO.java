package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.List;

public class AccountOverviewRespDTO extends BaseDTO {

    private BigDecimal accountBalance;


    private List<AccountHisRespDTO> accountList;

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<AccountHisRespDTO> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountHisRespDTO> accountList) {
        this.accountList = accountList;
    }
}
