package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class PayOrderReqDTO extends BaseDTO {

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 获取 邀请码
     */
    public String getInviteCode() {
        return this.inviteCode;
    }

    /**
     * 设置 邀请码
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    /**
     * 获取 订单ID
     */
    public Integer getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
