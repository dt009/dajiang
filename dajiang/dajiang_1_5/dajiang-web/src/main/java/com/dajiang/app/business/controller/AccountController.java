package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.dmo.Account;
import com.dajiang.app.business.po.dmo.AccountWithdraw;
import com.dajiang.app.business.po.req.RechargeReqDTO;
import com.dajiang.app.business.service.AccountService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 我的账户
 * Created by Joe on 2017/9/10.
 */
@RestController
public class AccountController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;


    /**
     * 账户添加
     */
    @PostMapping("/private/account/insert")
    @ResponseBody
    public ResponseBaseDTO<Object> insert(@RequestBody Account reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.insert(reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 初始化充值 p_back_init_recharge
     */
    @PostMapping("/private/account/initRecharge")
    @ResponseBody
    public ResponseBaseDTO<Object> initRecharge() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.initRecharge(getUserSession()));
        } catch (BaseException e) {
            logger.error("/private/account/initRecharge：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/initRecharge：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 充值 p_back_recharge
     */
    @PostMapping("/private/account/rechargeAccount")
    @ResponseBody
    public ResponseBaseDTO<Object> rechargeAccount(@RequestBody RechargeReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-rechargeAccount(reqDTO = [" + reqDTO + "])");
        }

        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.rechargeAccount(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error("/private/account/rechargeAccount：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/rechargeAccount：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 初始化提现 p_back_init_balance
     */
    @PostMapping("/private/account/initWithdrawal")
    @ResponseBody
    public ResponseBaseDTO<Object> initWithdrawal() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.initWithdrawal(getUserSession()));
        } catch (BaseException e) {
            logger.error("/private/account/initCaseOut：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/initCaseOut：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 提现
     */
    @RequestMapping("/private/account/withdrawal")
    @ResponseBody
    public ResponseBaseDTO<Object> withdrawal(@RequestBody AccountWithdraw reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-withdrawal(reqDTO = [" + reqDTO + "])");
        }

        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.withdrawal(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error("/private/account/withdrawal：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/withdrawal：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 初始化账户余额
     */
    @PostMapping("/private/account/initBalance")
    @ResponseBody
    public ResponseBaseDTO<Object> initBalance(@RequestBody Map<String, String> dayStr) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-initBalance(dayStr = [" + dayStr + "])");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.initBalance(getUserSession(), dayStr.get("dayStr")));
        } catch (BaseException e) {
            logger.error("/private/account/initBalance：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/initBalance：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 个人资金历史记录
     */
    @PostMapping("/private/account/queryHisList")
    @ResponseBody
    public ResponseBaseDTO<Object> queryHisList(@RequestBody Map<String, String> dayStr) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-queryHisList(dayStr = [" + dayStr + "])");
        }

        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.queryHisList(getUserSession(), dayStr.get("dayStr")));
        } catch (BaseException e) {
            logger.error("/private/account/initBalance：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/initBalance：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 邀请码校验
     */
    @PostMapping("/private/account/validInviteCode")
    @ResponseBody
    public ResponseBaseDTO<Object> validInviteCode(@RequestBody Map<String, String> reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-validInviteCode(reqDTO = [" + reqDTO + "])");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, accountService.validInviteCode(reqDTO.get("inviteCode")));
        } catch (BaseException e) {
            logger.error("/private/account/validInviteCode：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/account/validInviteCode：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "");
        }
    }



}
