package com.dajiang.app.kuaiqian.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.resp.OrderRespDTO;
import com.dajiang.app.business.service.OrderService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.kuaiqian.util.ParamUtils;
import com.dajiang.app.kuaiqian.util.Pkipair;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Bill99Controller extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(Bill99Controller.class);

    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;


    /**
     * 支付订单接口
     */
    @RequestMapping("/private/bill99/createSign/{orderId}")
    @ResponseBody
    public ResponseBaseDTO<Object> sendPayReq(@PathVariable("orderId") Integer orderId) {
        try {

            OrderRespDTO respDTO = orderService.initOrderInfo(getUserSession(), orderId);
            if (respDTO == null) {
                return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "支付失败，没有找到该订单。");
            }
            String merchantAcctId = "1020997698001";
            //编码方式，1代表 UTF-8; 2 代表 GBK; 3代表 GB2312 默认为1,该参数必填。
            String inputCharset = "1";
            //接收支付结果的页面地址，该参数一般置为空即可。
            String pageUrl = "";
            //服务器接收支付结果的后台地址，该参数务必填写，不能为空。
            String bgUrl = "http://apidev.dajiangzaixian.com/dj-api/public/bill99/callReturn";
            //网关版本，固定值：v2.0,该参数必填。
            String version = "mobile1.0";

            String mobileGateway = "phone";

            //语言种类，1代表中文显示，2代表英文显示。默认为1,该参数必填。
            String language = "1";
            //签名类型,该值为4，代表PKI加密方式,该参数必填。
            String signType = "4";
            //支付人姓名,可以为空。
            String payerName = "";
            //支付人联系类型，1 代表电子邮件方式；2 代表手机联系方式。可以为空。
            String payerContactType = "";
            //支付人联系方式，与payerContactType设置对应，payerContactType为1，则填写邮箱地址；payerContactType为2，则填写手机号码。可以为空。
            String payerContact = "";
            //商户订单号，以下采用时间来定义订单号，商户可以根据自己订单号的定义规则来定义该值，不能为空。
//            String orderId = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()) + "ts";
            //订单金额，金额以“分”为单位，商户测试以1分测试即可，切勿以大金额测试。该参数必填。
            String orderAmount = respDTO.getOrderAmount().multiply(BigDecimal.valueOf(100)).intValue() + "";
            //订单提交时间，格式：yyyyMMddHHmmss，如：20071117020101，不能为空。
            String orderTime = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
            //商品名称，可以为空。
            String productName = respDTO.getProductTitle();
            //商品数量，可以为空。
            String productNum = "1";
            //商品代码，可以为空。
            String productId = "" + respDTO.getProductId();
            //商品描述，可以为空。
            String productDesc = "";
            //扩展字段1，商户可以传递自己需要的参数，支付完快钱会原值返回，可以为空。
            String ext1 = "";
            //扩展自段2，商户可以传递自己需要的参数，支付完快钱会原值返回，可以为空。
            String ext2 = "";
            //支付方式，一般为00，代表所有的支付方式。如果是银行直连商户，该值为10，必填。
            String payType = "00";
            String aggregatePay = "";
            //银行代码，如果payType为00，该值可以为空；如果payType为10，该值必须填写，具体请参考银行列表。
            String bankId = "";
            //同一订单禁止重复提交标志，实物购物车填1，虚拟产品用0。1代表只能提交一次，0代表在支付不成功情况下可以再提交。可为空。
            String redoFlag = "0";
            //快钱合作伙伴的帐户号，即商户编号，可为空。
            String pid = "";
            //指定付款人
            String payerIdType = "3";
            //付款人标识
            String payerId = getUserSession().getUserId() + "";

            //和快钱的技术联系之后，确定该参数暂时不用。


            // signMsg 签名字符串 不可空，生成加密签名串
            String signMsgVal = "";
            signMsgVal = ParamUtils.appendParam(signMsgVal, "inputCharset", inputCharset);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "pageUrl", pageUrl);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "bgUrl", bgUrl);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "version", version);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "language", language);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "signType", signType);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "merchantAcctId", merchantAcctId);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "payerName", payerName);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "payerContactType", payerContactType);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "payerContact", payerContact);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "payerIdType", payerIdType);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "payerId", payerId);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "orderId", orderId + "");
            signMsgVal = ParamUtils.appendParam(signMsgVal, "orderAmount", orderAmount);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "orderTime", orderTime);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "productName", productName);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "productNum", productNum);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "productId", productId);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "productDesc", productDesc);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "ext1", ext1);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "ext2", ext2);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "payType", payType);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "bankId", bankId);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "redoFlag", redoFlag);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "pid", pid);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "mobileGateway", mobileGateway);
            signMsgVal = ParamUtils.appendParam(signMsgVal, "aggregatePay", aggregatePay);
            Pkipair pki = new Pkipair();
            logger.info(signMsgVal);
            String signMsg = pki.signMsg(signMsgVal);
            logger.info("sign.msg=", signMsg);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("inputCharset", inputCharset);
            paramMap.put("pageUrl", pageUrl);
            paramMap.put("bgUrl", bgUrl);
            paramMap.put("version", version);
            paramMap.put("mobileGateway", mobileGateway);
            paramMap.put("language", language);
            paramMap.put("signType", signType);
            paramMap.put("signMsg", signMsg);
            paramMap.put("merchantAcctId", merchantAcctId);
            paramMap.put("payerName", payerName);
            paramMap.put("payerContactType", payerContactType);
            paramMap.put("payerContact", payerContact);
            paramMap.put("payerIdType", payerIdType);
            paramMap.put("payerId", payerId);
            paramMap.put("orderCode", respDTO.getOrderCode());
            paramMap.put("orderId", orderId);
            paramMap.put("orderAmount", orderAmount);
            paramMap.put("orderTime", orderTime);
            paramMap.put("productName", productName);
            paramMap.put("productNum", productNum);
            paramMap.put("productId", productId);
            paramMap.put("productDesc", productDesc);
            paramMap.put("ext1", ext1);
            paramMap.put("ext2", ext2);
            paramMap.put("payType", payType);
            paramMap.put("bankId", bankId);
            paramMap.put("redoFlag", redoFlag);
            paramMap.put("pid", pid);
            paramMap.put("aggregatePay", aggregatePay);

            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "", paramMap);
        } catch (BaseException e) {
            logger.error("/private/bill99/sendPayReq：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/bill99/private/sendPayReq：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        }
    }
}
