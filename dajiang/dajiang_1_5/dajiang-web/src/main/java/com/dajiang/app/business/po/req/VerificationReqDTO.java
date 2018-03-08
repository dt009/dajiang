package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * Created by Joe on 2017/9/20.
 */
public class VerificationReqDTO extends BaseDTO {

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 验证码用途
     */
    private String useType;

    /**
     * 请求时间
     */
    private Date reqTime;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }
}
