package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class MessageContextReqDTO extends BaseDTO {

    /**
     * 收消息用户ID
     */
    private Long myId;

    /**
     * 发消息用户ID
     */
    private Long otherId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 取上一页的ID，需要传入当前页的最小ID
     */
    private Integer messageMinId;

    /**
     * 取下一页的ID，需要传入当前页的最大ID
     */
    private Integer messageMaxId;

    public Long getMyId() {
        return myId;
    }

    public void setMyId(Long myId) {
        this.myId = myId;
    }

    public Long getOtherId() {
        return otherId;
    }

    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMessageMinId() {
        return messageMinId;
    }

    public void setMessageMinId(Integer messageMinId) {
        this.messageMinId = messageMinId;
    }

    public Integer getMessageMaxId() {
        return messageMaxId;
    }

    public void setMessageMaxId(Integer messageMaxId) {
        this.messageMaxId = messageMaxId;
    }
}
