package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.req.PayOrderReqDTO;
import com.dajiang.app.business.service.OrderService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    /**
     * 查看订单详情。
     */
    @PostMapping("/private/order/initOrderInfo/{orderId}")
    @ResponseBody
    public ResponseBaseDTO<Object> initOrderInfo(@PathVariable("orderId") Integer orderId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, orderService.initOrderInfo(getUserSession(), orderId));
        } catch (BaseException e) {
            logger.error("/private/account/initOrderInfo：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/initOrderInfo：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 创建订单
     *
     * @param productId
     * @return
     */
    @RequestMapping("/private/order/createOrder/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> createOrder(@PathVariable Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, orderService.insertNewOrder(getUserSession(), productId));
        } catch (BaseException e) {
            logger.error("/private/order/createOrder：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/order/createOrder：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 通过余额支付
     */
    @RequestMapping("/private/order/payByBalance")
    @ResponseBody
    public ResponseBaseDTO<Object> payByBalance(@RequestBody PayOrderReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, orderService.payOrderByBalance(reqDTO));
        } catch (BaseException e) {
            logger.error("/private/payOrder：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/payOrder：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        }
    }

    /**
     * 通过第三方平台支付（目前是快钱）
     */
    @RequestMapping("/private/order/payByThird")
    @ResponseBody
    public ResponseBaseDTO<Object> payByThird(@RequestBody PayOrderReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, orderService.payOrderByThird(reqDTO));
        } catch (BaseException e) {
            logger.error("/private/order/payByThird：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/order/payByThird：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "");
        }
    }

}
