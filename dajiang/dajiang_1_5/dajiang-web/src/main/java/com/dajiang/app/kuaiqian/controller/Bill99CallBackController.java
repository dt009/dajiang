package com.dajiang.app.kuaiqian.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.kuaiqian.po.resp.KqUserLog;
import com.dajiang.app.kuaiqian.service.KqUserLogService;
import com.dajiang.app.kuaiqian.util.ParamUtils;
import com.dajiang.app.kuaiqian.util.Pkipair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Bill99CallBackController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(Bill99CallBackController.class);


    @Autowired
    @Qualifier("kqUserLogServiceImpl")
    private KqUserLogService kqUserLogService;

    /**
     * 支付回调接口
     */
    @ResponseBody
    @GetMapping(value = "/public/bill99/callReturn")
    public String callReturn(HttpServletRequest request, HttpServletResponse response) {
        try {
            //商户订单号，该值与提交时相同。
            KqUserLog respDTO = new KqUserLog();
            String orderId = request.getParameter("orderId");
            // 快钱交易号，商户每一笔交易都会在快钱生成一个交易号。
            String dealId = request.getParameter("dealId");
            respDTO.setDealId(dealId);
            if (orderId == null || dealId == null) {
                return "<result>0</result> <redirecturl>http://apidev.dajiangzaixian.com/#/index/home</redirecturl>";
            }
            KqUserLog kqUserLog = kqUserLogService.selectByOrderIdDealId(orderId, dealId);
            if (kqUserLog != null) {
                respDTO = kqUserLog;
            }
            respDTO.setOrderId(orderId);

            //人民币网关账号，该账号为11位人民币网关商户编号+01,该值与提交时相同。
            String merchantAcctId = request.getParameter("merchantAcctId");
            respDTO.setMerchantAcctid(merchantAcctId);
            //网关版本，固定值：v2.0,该值与提交时相同。
            String version = request.getParameter("version");
            respDTO.setVersion(version);
            //语言种类，1代表中文显示，2代表英文显示。默认为1,该值与提交时相同。
            String language = request.getParameter("language");
            respDTO.setLanguage(language);
            //签名类型,该值为4，代表PKI加密方式,该值与提交时相同。
            String signType = request.getParameter("signType");
            respDTO.setSignType(signType);
            //支付方式，一般为00，代表所有的支付方式。如果是银行直连商户，该值为10,该值与提交时相同。
            String payType = request.getParameter("payType");
            respDTO.setPayType(payType);
            //银行代码，如果payType为00，该值为空；如果payType为10,该值与提交时相同。
            String bankId = request.getParameter("bankId");
            respDTO.setBankId(bankId);

            //订单提交时间，格式：yyyyMMddHHmmss，如：20071117020101,该值与提交时相同。
            String orderTime = request.getParameter("orderTime");
            respDTO.setOrderTime(orderTime);
            //订单金额，金额以“分”为单位，商户测试以1分测试即可，切勿以大金额测试,该值与支付时相同。
            String orderAmount = request.getParameter("orderAmount");
            respDTO.setOrderAmount(orderAmount);

            //银行交易号 ，快钱交易在银行支付时对应的交易号，如果不是通过银行卡支付，则为空
            String bankDealId = request.getParameter("bankDealId");
            respDTO.setBankDealId(bankDealId);
            //快钱交易时间，快钱对交易进行处理的时间,格式：yyyyMMddHHmmss，如：20071117020101
            String dealTime = request.getParameter("dealTime");
            respDTO.setDealTime(request.getParameter("dealTime"));
            //商户实际支付金额 以分为单位。比方10元，提交时金额应为1000。该金额代表商户快钱账户最终收到的金额。
            String payAmount = request.getParameter("payAmount");
            respDTO.setPayAmount(payAmount);
            //费用，快钱收取商户的手续费，单位为分。
            String fee = request.getParameter("fee");
            respDTO.setFee(fee);
            //扩展字段1，该值与提交时相同。
            String ext1 = request.getParameter("ext1");
            respDTO.setExt1(ext1);
            //扩展字段2，该值与提交时相同。
            String ext2 = request.getParameter("ext2");
            respDTO.setExt2(ext2);
            //处理结果， 10支付成功，11 支付失败，00订单申请成功，01 订单申请失败
            String payResult = request.getParameter("payResult");
            respDTO.setPayResult(payResult);
            //错误代码 ，请参照《人民币网关接口文档》最后部分的详细解释。
            String errCode = request.getParameter("errCode");
            respDTO.setErrCode(errCode);
            //签名字符串
            String signMsg = request.getParameter("signMsg");
            respDTO.setSignMsg(signMsg);
            //短卡号
            String bindCard = request.getParameter("bindCard");
            respDTO.setBindCard(bindCard);
            //短手机尾号
            String bindMobile = request.getParameter("bindMobile");
            respDTO.setBindMobile(bindMobile);
            logger.info("/public/bill99/callReturn: respDTO:{}", respDTO);
            if (respDTO.getKqUserLogId() == null) {
                kqUserLogService.insertSelective(respDTO);

            } else {
                kqUserLogService.updateByPrimaryKeySelective(respDTO);
            }
            String merchantSignMsgVal = "";
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "merchantAcctId", merchantAcctId);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "version", version);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "language", language);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "signType", signType);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "payType", payType);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "bankId", bankId);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "orderId", orderId);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "orderTime", orderTime);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "orderAmount", orderAmount);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "bindCard", bindCard);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "bindMobile", bindMobile);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "dealId", dealId);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "bankDealId", bankDealId);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "dealTime", dealTime);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "payAmount", payAmount);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "fee", fee);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "ext1", ext1);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "ext2", ext2);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "payResult", payResult);
            merchantSignMsgVal = ParamUtils.appendParam(merchantSignMsgVal, "errCode", errCode);
            Pkipair pki = new Pkipair();
            boolean flag = pki.enCodeByCer(merchantSignMsgVal, signMsg);
            String out = null;
            int rtnOK = 0;
            String url = "http://apidev.dajiangzaixian.com/#/index/home";
            String msg = "支付失败。";
            if (flag) {
                switch (Integer.parseInt(payResult)) {
                    case 10:
                      /*
                      此处商户可以做业务逻辑处理
  					*/
                        rtnOK = 1;
                        //以下是我们快钱设置的show页面，商户需要自己定义该页面。
                        msg = "支付成功。";
                        break;
                    default:
                        rtnOK = 1;
                        //以下是我们快钱设置的show页面，商户需要自己定义该页面。
                        msg = "支付成功。";
                        break;
                }
            } else {
                rtnOK = 1;
                //以下是我们快钱设置的show页面，商户需要自己定义该页面。
            }
            out = "<result>" + rtnOK + "</result><redirecturl>" + url + "</redirecturl>";
//            String orderId = (String) request.getParameter("orderId").trim();
//            String orderAmount = (String) request.getParameter("orderAmount").trim();
//            String dealId = (String) request.getParameter("dealId").trim();
//            String orderTime = (String) request.getParameter("orderTime").trim();
//            String payResult = (String) request.getParameter("payResult").trim();
//            String msg = (String) request.getParameter("msg").trim();
            logger.info("out={}", out);
            logger.info("return.url=" + url);
            return out;
        } catch (BaseException e) {
            logger.error("/public/bill99/callReturn：" + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("/public/bill99/callReturn：" + e.getMessage(), e);
        }
        return "";
    }


}
