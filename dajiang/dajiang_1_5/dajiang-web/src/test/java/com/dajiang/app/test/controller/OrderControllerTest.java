package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.req.PayOrderReqDTO;
import org.junit.Test;

public class OrderControllerTest extends BaseControllerTest {
    @Test
    public void initOrderInfo() throws Exception {

    }

    @Test
    public void createOrder() throws Exception {

        doPostTest(getDJSession(), "/private/order/createOrder/8", null);

    }

    @Test
    public void payByBalance() throws Exception {
        PayOrderReqDTO reqDTO = new PayOrderReqDTO();
        reqDTO.setOrderId(41);
        reqDTO.setInviteCode("zhtied");
        doPostTest(getDJSession(), "/private/order/payByBalance", reqDTO);
    }

}