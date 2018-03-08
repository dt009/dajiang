package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Message;
import com.dajiang.app.business.po.req.MessageContextReqDTO;
import com.dajiang.app.business.po.req.MessageReqDTO;
import com.dajiang.app.business.po.resp.MessageContextRespDTO;
import com.dajiang.app.business.po.resp.MessageProductRespDTO;
import com.dajiang.app.business.po.resp.MessageSenderRespDTO;
import com.dajiang.app.common.context.UserSession;

import java.util.List;

public interface MessageService {
    Message selectByPrimaryKey(Integer messageId);

    /**
     * 查询大匠有消息的产品
     *
     * @param userId
     * @return
     */
    List<MessageProductRespDTO> selectByReceivedUserId(UserSession userId);

    /**
     * 查询用户
     *
     * @param userId
     * @param productId
     * @return
     */
    List<MessageSenderRespDTO> selectBySendUserId(UserSession userId, Integer productId);

    int deleteByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    MessageContextRespDTO selectCurrentMessages(UserSession userSession, MessageContextReqDTO reqDTO);

    MessageContextRespDTO selectPrevMessages(UserSession userSession, MessageContextReqDTO reqDTO);

    MessageContextRespDTO selectNextMessages(UserSession userSession, MessageContextReqDTO reqDTO);

    int insertTradeMessage(UserSession userSession, MessageReqDTO reqDTO);

    int selectMessageTotal(UserSession userSession);

}