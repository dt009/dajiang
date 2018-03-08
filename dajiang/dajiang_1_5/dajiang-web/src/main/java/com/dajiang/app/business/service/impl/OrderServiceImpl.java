package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.OrderDAO;
import com.dajiang.app.business.po.dmo.Order;
import com.dajiang.app.business.po.req.PayOrderReqDTO;
import com.dajiang.app.business.po.resp.OrderRespDTO;
import com.dajiang.app.business.service.OrderService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.util.ExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("orderServiceImpl")
@Scope("singleton")
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public Order selectByPrimaryKey(Integer orderId) {
        return this.orderDAO.selectByPrimaryKey(orderId);
    }

    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return this.orderDAO.deleteByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return this.orderDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Order record) {
        return this.orderDAO.insertSelective(record);
    }

    @Override
    public OrderRespDTO initOrderInfo(UserSession userIdBuyer, Integer orderId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-initOrderInfo(userIdBuyer = [" + userIdBuyer + "], orderId = [" + orderId + "])");
        }
        OrderRespDTO respDTO = this.orderDAO.selectOrderById(orderId);
        if (userIdBuyer == null || userIdBuyer.getUserId() != respDTO.getUserIdBuyer()) {
            throw SystemExceptionFactory.authorityException();
        }
        return respDTO;
    }

    @Override
    public OrderRespDTO insertNewOrder(UserSession userSession, Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-insertNewOrder(userSession = [" + userSession + "], productId = [" + productId + "])");
        }

        OrderRespDTO orderRespDTO = this.orderDAO.insertNewOrder(userSession.getUserId(), productId);
        if (orderRespDTO == null || orderRespDTO.getOrderId() == -1) {
            throw new BaseException(ExceptionType.Illegal_Parameter, "创建订单失败。");
        }
        return orderRespDTO;
    }

    @Override
    public int payOrderByBalance(PayOrderReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-payOrder(reqDTO = [" + reqDTO + "])");
        }
        int lockResult = this.orderDAO.lockPayOrder(reqDTO.getOrderId());
        if (SystemExceptionFactory.DB_CALL_FAIL == lockResult) {
            throw new BaseException(ExceptionType.Illegal_Parameter, "订单支付失败，账户金额未发生变化。");
        }
        int i = this.orderDAO.payOrder(reqDTO.getInviteCode(), reqDTO.getOrderId());
        if (SystemExceptionFactory.DB_CALL_FAIL == i) {
            throw new BaseException(ExceptionType.Illegal_Parameter, "订单支付失败，账户金额未发生变化。");
        }
        return i;
    }

    @Override
    public int payOrderByThird(PayOrderReqDTO reqDTO) {
        return 0;
    }
}