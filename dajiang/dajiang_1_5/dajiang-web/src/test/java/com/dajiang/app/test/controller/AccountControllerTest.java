package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.dmo.Account;
import com.dajiang.app.business.po.dmo.AccountWithdraw;
import com.dajiang.app.business.po.req.RechargeReqDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joe on 2017/9/11.
 */
public class AccountControllerTest extends BaseControllerTest {

    @Test
    public void initRecharge() throws Exception {
        doPostTest(getDJSession(), "/private/account/initRecharge", null);
    }

    @Test
    public void rechargeAccount() throws Exception {


        RechargeReqDTO reqDTO = new RechargeReqDTO();
        reqDTO.setAmount(100);
        doPostTest(getDJSession(), "/private/account/rechargeAccount", reqDTO);
    }

    @Test
    public void initWithdrawal() throws Exception {
    }

    @Test
    public void withdrawal() throws Exception {
        AccountWithdraw reqDTO = new AccountWithdraw();
        reqDTO.setWithdrawBankname("中国银行");
        reqDTO.setWithdrawBankno("1999392992921");
        reqDTO.setWithdrawName("周文冬");
        reqDTO.setWithdrawAmount(BigDecimal.valueOf(100));
        doPostTest(getDJSession(), "/private/account/withdrawal", reqDTO);
    }

    @Test
    public void initBalance() throws Exception {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("dayStr", "2017-11");
        doPostTest(getDJSession(), "/private/account/initBalance", resultMap);
    }

    @Test
    public void insert() throws Exception {
        Account reqDTO = new Account();
        doPostTest(null, "/account/insert", reqDTO);
    }

}