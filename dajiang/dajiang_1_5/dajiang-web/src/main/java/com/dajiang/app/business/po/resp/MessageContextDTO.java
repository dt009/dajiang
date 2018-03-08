package com.dajiang.app.business.po.resp;

import java.util.Date;

public class MessageContextDTO {

    /**
     * 收信人ID。当发起方是买家的时候，收信人是卖家。发起方是卖家的时候，收信人是买家
     */
    private Long myId;

    /**
     * 发信人ID。当发起方是买家的时候，发信人是买家。发起方是卖家的时候，发信人是卖家
     */
    private Long otherId;

    /**
     * 消息内容
     */
    private String messageContent;

    /**
     * 消息发送时间
     */
    private Date messageSendDT;

    /**
     * 消息ID
     */
    private Integer messageId;

    /**
     * 消息来源标记，0：卖家，1：买家
     */
    private Integer fromFlag;

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

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageSendDT() {
        return messageSendDT;
    }

    public void setMessageSendDT(Date messageSendDT) {
        this.messageSendDT = messageSendDT;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getFromFlag() {
        return fromFlag;
    }

    public void setFromFlag(Integer fromFlag) {
        this.fromFlag = fromFlag;
    }
}
