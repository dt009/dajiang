package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.dao.UserDAO;
import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.business.dao.MessageDAO;
import com.dajiang.app.business.po.dmo.Message;
import com.dajiang.app.business.po.req.MessageContextReqDTO;
import com.dajiang.app.business.po.req.MessageReqDTO;
import com.dajiang.app.business.po.resp.MessageContextDTO;
import com.dajiang.app.business.po.resp.MessageContextRespDTO;
import com.dajiang.app.business.po.resp.MessageProductRespDTO;
import com.dajiang.app.business.po.resp.MessageSenderRespDTO;
import com.dajiang.app.business.service.MessageService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageServiceImpl")
@Scope("singleton")
public class MessageServiceImpl implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Message selectByPrimaryKey(Integer messageId) {
        return this.messageDAO.selectByPrimaryKey(messageId);
    }

    @Override
    public List<MessageProductRespDTO> selectByReceivedUserId(UserSession userSession) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByReceivedUserId(userSession = [" + userSession + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        return this.messageDAO.selectByReceivedUserId(userSession.getUserId());
    }

    @Override
    public List<MessageSenderRespDTO> selectBySendUserId(UserSession userSession, Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectBySendUserId(userSession = [" + userSession + "], productId = [" + productId + "]) -start");
        }

        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        return this.messageDAO.selectByUserId(userSession.getUserId(), productId);
    }

    @Override
    public MessageContextRespDTO selectCurrentMessages(UserSession userSession, MessageContextReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectCurrentMessages(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        reqDTO.setMyId(userSession.getUserId());
        List<MessageContextDTO> messageContextDTOS = this.messageDAO.selectCurrentMessages(reqDTO);
        for (MessageContextDTO messageContextDTO : messageContextDTOS) {
            if (messageContextDTO.getFromFlag().equals(1)) {
                Long otherId = messageContextDTO.getMyId();
                Long myId = messageContextDTO.getOtherId();
                messageContextDTO.setMyId(myId);
                messageContextDTO.setOtherId(otherId);
            }
        }
        MessageContextRespDTO respDTO = this.messageDAO.selectMessageTotal(reqDTO);
        respDTO.setList(messageContextDTOS);
        respDTO.setMyId(userSession.getUserId());
        User seller = userDAO.selectByPrimaryKey(reqDTO.getMyId());
        if (seller != null) {
            respDTO.setMyIcon(seller.getUserPhotoPath());
        }
        respDTO.setOtherId(reqDTO.getOtherId());
        User buyer = userDAO.selectByPrimaryKey(reqDTO.getOtherId());
        if (buyer != null) {
            respDTO.setOtherIcon(buyer.getUserPhotoPath());
        }
        return respDTO;
    }

    @Override
    public MessageContextRespDTO selectPrevMessages(UserSession userSession, MessageContextReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectPrevMessages(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        reqDTO.setMyId(userSession.getUserId());
        List<MessageContextDTO> messageContextDTOS = this.messageDAO.selectPrevMessages(reqDTO);
        for (MessageContextDTO messageContextDTO : messageContextDTOS) {
            if (messageContextDTO.getFromFlag().equals(1)) {
                Long otherId = messageContextDTO.getMyId();
                Long myId = messageContextDTO.getOtherId();
                messageContextDTO.setMyId(myId);
                messageContextDTO.setOtherId(otherId);
            }
        }

        MessageContextRespDTO respDTO = this.messageDAO.selectMessageTotal(reqDTO);
        respDTO.setList(messageContextDTOS);
        respDTO.setMyId(reqDTO.getMyId());
        User seller = userDAO.selectByPrimaryKey(reqDTO.getMyId());
        if (seller != null) {
            respDTO.setMyIcon(seller.getUserPhotoPath());
        }
        respDTO.setOtherId(reqDTO.getOtherId());
        User buyer = userDAO.selectByPrimaryKey(reqDTO.getOtherId());
        if (buyer != null) {
            respDTO.setOtherIcon(buyer.getUserPhotoPath());
        }
        return respDTO;
    }

    @Override
    public MessageContextRespDTO selectNextMessages(UserSession userSession, MessageContextReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectNextMessages(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        reqDTO.setMyId(userSession.getUserId());
        List<MessageContextDTO> messageContextDTOS = this.messageDAO.selectNextMessages(reqDTO);
        for (MessageContextDTO messageContextDTO : messageContextDTOS) {
            if (messageContextDTO.getFromFlag().equals(1)) {
                Long otherId = messageContextDTO.getMyId();
                Long myId = messageContextDTO.getOtherId();
                messageContextDTO.setMyId(myId);
                messageContextDTO.setOtherId(otherId);
            }
        }
        MessageContextRespDTO respDTO = this.messageDAO.selectMessageTotal(reqDTO);
        respDTO.setList(messageContextDTOS);
        respDTO.setMyId(reqDTO.getMyId());
        User seller = userDAO.selectByPrimaryKey(reqDTO.getMyId());
        if (seller != null) {
            respDTO.setMyIcon(seller.getUserPhotoPath());
        }
        respDTO.setOtherId(reqDTO.getOtherId());
        User buyer = userDAO.selectByPrimaryKey(reqDTO.getOtherId());
        if (buyer != null) {
            respDTO.setOtherIcon(buyer.getUserPhotoPath());
        }
        return respDTO;
    }

    @Override
    public int deleteByPrimaryKey(Integer messageId) {
        return this.messageDAO.deleteByPrimaryKey(messageId);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return this.messageDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertTradeMessage(UserSession userSession, MessageReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertTradeMessage(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        if (reqDTO == null || reqDTO.getOtherId() == null || StringUtils.isEmpty(reqDTO.getMessageContent())) {
            throw SystemExceptionFactory.nullException();
        }
        Message message = new Message();
        message.setProductId(reqDTO.getProductId());
        message.setSendUserId(userSession.getUserId());
        message.setReceivedUserId(reqDTO.getOtherId());
        message.setMessageContent(reqDTO.getMessageContent());
        return this.messageDAO.insertSelective(message);
    }

    @Override
    public int selectMessageTotal(UserSession userSession) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectMessageTotal(userSession = [" + userSession + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        return this.messageDAO.callMessageTotal(userSession.getUserId());
    }
}