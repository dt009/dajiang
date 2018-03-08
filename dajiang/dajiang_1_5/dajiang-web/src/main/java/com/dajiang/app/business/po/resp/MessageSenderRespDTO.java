package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

public class MessageSenderRespDTO extends BaseDTO {

    private Integer productId;
    private Long otherId;
    private String otherNickName;
    private String otherPhotoPath;
    private Date sendDt;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getOtherId() {
        return otherId;
    }

    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }

    public String getOtherNickName() {
        return otherNickName;
    }

    public void setOtherNickName(String otherNickName) {
        this.otherNickName = otherNickName;
    }

    public String getOtherPhotoPath() {
        return otherPhotoPath;
    }

    public void setOtherPhotoPath(String otherPhotoPath) {
        this.otherPhotoPath = otherPhotoPath;
    }

    public Date getSendDt() {
        return sendDt;
    }

    public void setSendDt(Date sendDt) {
        this.sendDt = sendDt;
    }
}
