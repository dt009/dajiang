package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.req.MessageContextReqDTO;
import com.dajiang.app.business.po.req.MessageReqDTO;
import org.junit.Test;

public class MessageControllerTest extends BaseControllerTest {
    @Test
    public void initMessage() throws Exception {
        doPostTest(getNullSession(), "/private/message/initMessage", null);
    }

    @Test
    public void addTradeMessage() throws Exception {
        MessageReqDTO reqDTO = new MessageReqDTO();
        reqDTO.setOtherId(2L);
        reqDTO.setProductId(1);
        reqDTO.setMessageContent("你好，商品不能砍价啊。");
        doPostTest(getDJSession(), "/private/message/addTradeMessage", reqDTO);
    }

    @Test
    public void querySender() throws Exception {
        doPostTest(getDJSession(), "/private/message/querySender/5", null);
    }

    @Test
    public void queryCurrentMessages() throws Exception {
        MessageContextReqDTO reqDTO = new MessageContextReqDTO();
        reqDTO.setOtherId(2L);
        reqDTO.setProductId(1);
        doPostTest(getDJSession(), "/private/message/queryCurrentMessages", reqDTO);
    }

    @Test
    public void queryPrevMessages() throws Exception {
        MessageContextReqDTO reqDTO = new MessageContextReqDTO();
        reqDTO.setOtherId(2L);
        reqDTO.setProductId(1);
        reqDTO.setMessageMinId(1);
        doPostTest(getDJSession(), "/private/message/queryPrevMessages", reqDTO);
    }

    @Test
    public void queryNextMessages() throws Exception {
        MessageContextReqDTO reqDTO = new MessageContextReqDTO();
        reqDTO.setOtherId(2L);
        reqDTO.setProductId(1);
        doPostTest(getDJSession(), "/private/message/queryNextMessages", reqDTO);
    }



}