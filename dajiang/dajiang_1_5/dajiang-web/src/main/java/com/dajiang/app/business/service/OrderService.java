package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Order;
import com.dajiang.app.business.po.req.PayOrderReqDTO;
import com.dajiang.app.business.po.resp.OrderRespDTO;
import com.dajiang.app.common.context.UserSession;

public interface OrderService {
    Order selectByPrimaryKey(Integer orderId);

    int deleteByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int insertSelective(Order record);

    OrderRespDTO initOrderInfo(UserSession userIdBuyer, Integer orderId);

    OrderRespDTO insertNewOrder(UserSession userSession, Integer productId);

    int payOrderByBalance(PayOrderReqDTO reqDTO);

    int payOrderByThird(PayOrderReqDTO reqDTO);
}