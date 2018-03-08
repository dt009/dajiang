package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class RechargeReqDTO extends BaseDTO {

    private Integer amount;

    private Long userId;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
