package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.ArrayList;
import java.util.List;

public class MessageContextRespDTO extends BaseDTO {

    /**
     * 待读消息总数
     */
    private Integer messageWaitCount;

    /**
     *
     */
    private Long myId;

    /**
     *
     */
    private String myIcon;

    /**
     *
     */
    private Long otherId;

    /**
     *
     */
    private String otherIcon;

    /**
     *
     */
    private Integer messageMinId;

    /**
     *
     */
    private Integer messageMaxId;

    private List<MessageContextDTO> list = new ArrayList<>();

    public Integer getMessageWaitCount() {
        return messageWaitCount;
    }

    public void setMessageWaitCount(Integer messageWaitCount) {
        this.messageWaitCount = messageWaitCount;
    }

    public Long getMyId() {
        return myId;
    }

    public void setMyId(Long myId) {
        this.myId = myId;
    }

    public String getMyIcon() {
        return myIcon;
    }

    public void setMyIcon(String myIcon) {
        this.myIcon = myIcon;
    }

    public Long getOtherId() {
        return otherId;
    }

    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }

    public String getOtherIcon() {
        return otherIcon;
    }

    public void setOtherIcon(String otherIcon) {
        this.otherIcon = otherIcon;
    }

    public List<MessageContextDTO> getList() {
        return list;
    }

    public void setList(List<MessageContextDTO> list) {
        if (list == null) {
            this.list = null;
            return;
        }
        messageMaxId = 0;
        messageMinId = 0;
        for (MessageContextDTO dto : list) {
            if (dto.getMessageId().compareTo(messageMaxId) > 0) {
                messageMaxId = dto.getMessageId();
            }
            if (dto.getMessageId().compareTo(messageMinId) < 0) {
                messageMinId = dto.getMessageId();
            }
        }
        this.list = list;
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
