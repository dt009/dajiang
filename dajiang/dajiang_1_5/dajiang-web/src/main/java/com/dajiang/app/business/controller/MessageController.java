package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.req.MessageContextReqDTO;
import com.dajiang.app.business.po.req.MessageReqDTO;
import com.dajiang.app.business.service.MessageService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController extends BaseController {


    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);


    @Autowired
    @Qualifier("messageServiceImpl")
    private MessageService messageService;

    /**
     * 根究用户ID查询该用户的聊天分组
     */
    @RequestMapping("/private/message/initMessage")
    @ResponseBody
    public ResponseBaseDTO<Object> initMessage() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, messageService.selectByReceivedUserId(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     *
     */
    @RequestMapping("/private/message/querySender/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> querySender(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, messageService.selectBySendUserId(getUserSession(), productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     *
     */
    @RequestMapping("/private/message/addTradeMessage")
    @ResponseBody
    public ResponseBaseDTO<Object> addTradeMessage(@RequestBody MessageReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, messageService.insertTradeMessage(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 消息当前页消息
     */
    @RequestMapping("/private/message/queryCurrentMessages")
    @ResponseBody
    public ResponseBaseDTO<Object> queryCurrentMessages(@RequestBody MessageContextReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, messageService.selectCurrentMessages(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 获取上一页消息
     */
    @RequestMapping("/private/message/queryPrevMessages")
    @ResponseBody
    public ResponseBaseDTO<Object> queryPrevMessages(@RequestBody MessageContextReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, messageService.selectPrevMessages(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 获取下一页消息
     */
    @RequestMapping("/private/message/queryNextMessages")
    @ResponseBody
    public ResponseBaseDTO<Object> queryNextMessages(@RequestBody MessageContextReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, messageService.selectNextMessages(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

}
