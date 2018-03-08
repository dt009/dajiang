/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 消息推送，议价 t_message
 *
 * @author zhouwd code generator
 */
public class Message extends BaseDTO {
    private Integer messageId;

    /**
     * 信息接收人
     */
    private Long receivedUserId;

    /**
     * 讨论商品id,如果是系统发送值为-1
     */
    private Integer productId;

    /**
     * 发送消息人
     */
    private Long sendUserId;

    /**
     * 消息种类：1：购物私聊；2、系统推送消息
     */
    private Integer messageType;

    private String messageContent;

    /**
     * 是否查看：0：未接收；1：接收
     */
    private Integer messageStatus;

    /**
     * 发送时间
     */
    private Date messageSenddt;

    /**
     * 获取 t_message.message_id
     *
     * @return t_message.message_id
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * 设置 t_message.message_id
     *
     * @param messageId t_message.message_id
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * 获取 信息接收人 t_message.received_user_id
     *
     * @return 信息接收人
     */
    public Long getReceivedUserId() {
        return receivedUserId;
    }

    /**
     * 设置 信息接收人 t_message.received_user_id
     *
     * @param receivedUserId 信息接收人
     */
    public void setReceivedUserId(Long receivedUserId) {
        this.receivedUserId = receivedUserId;
    }

    /**
     * 获取 讨论商品id,如果是系统发送值为-1 t_message.product_id
     *
     * @return 讨论商品id, 如果是系统发送值为-1
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置 讨论商品id,如果是系统发送值为-1 t_message.product_id
     *
     * @param productId 讨论商品id,如果是系统发送值为-1
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取 发送消息人 t_message.send_user_id
     *
     * @return 发送消息人
     */
    public Long getSendUserId() {
        return sendUserId;
    }

    /**
     * 设置 发送消息人 t_message.send_user_id
     *
     * @param sendUserId 发送消息人
     */
    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    /**
     * 获取 消息种类：1：购物私聊；2、系统推送消息 t_message.message_type
     *
     * @return 消息种类：1：购物私聊；2、系统推送消息
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     * 设置 消息种类：1：购物私聊；2、系统推送消息 t_message.message_type
     *
     * @param messageType 消息种类：1：购物私聊；2、系统推送消息
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     * 获取 t_message.message_content
     *
     * @return t_message.message_content
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 设置 t_message.message_content
     *
     * @param messageContent t_message.message_content
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    /**
     * 获取 是否接收：0：未接收；1：接收 t_message.message_status
     *
     * @return 是否接收：0：未接收；1：接收
     */
    public Integer getMessageStatus() {
        return messageStatus;
    }

    /**
     * 设置 是否接收：0：未接收；1：接收 t_message.message_status
     *
     * @param messageStatus 是否接收：0：未接收；1：接收
     */
    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    /**
     * 获取 发送时间 t_message.message_sendDT
     *
     * @return 发送时间
     */
    public Date getMessageSenddt() {
        return messageSenddt;
    }

    /**
     * 设置 发送时间 t_message.message_sendDT
     *
     * @param messageSenddt 发送时间
     */
    public void setMessageSenddt(Date messageSenddt) {
        this.messageSenddt = messageSenddt;
    }
}