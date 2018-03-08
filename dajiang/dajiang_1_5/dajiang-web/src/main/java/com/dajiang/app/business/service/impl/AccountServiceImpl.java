package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.AccountDAO;
import com.dajiang.app.business.po.dmo.Account;
import com.dajiang.app.business.po.dmo.AccountWithdraw;
import com.dajiang.app.business.po.req.RechargeReqDTO;
import com.dajiang.app.business.po.resp.AccountHisRespDTO;
import com.dajiang.app.business.po.resp.AccountOverviewRespDTO;
import com.dajiang.app.business.po.resp.AccountRespDTO;
import com.dajiang.app.business.service.AccountService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.util.ExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("accountServiceImpl")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public Account selectByPrimaryKey(Integer accountId) {
        return this.accountDAO.selectByPrimaryKey(accountId);
    }

    @Override
    public int deleteByPrimaryKey(Integer accountId) {
        return this.accountDAO.deleteByPrimaryKey(accountId);
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return this.accountDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insert(Account record) {
        return this.accountDAO.insertSelective(record);
    }

    @Override
    public AccountRespDTO initRecharge(UserSession userSession) {
//        if (userSession == null) {
//            throw SystemExceptionFactory.loginException();
//        }
        BigDecimal accountBalance = this.accountDAO.initAllBalance(userSession.getUserId());
        AccountRespDTO account = new AccountRespDTO();
        account.setAccountBalance(accountBalance);
        return account;
    }


    @Override
    public int rechargeAccount(UserSession userSession, RechargeReqDTO reqDTO) {
//        if (userSession == null) {
//            throw SystemExceptionFactory.loginException();
//        }
        if (reqDTO.getAmount() <= 0) {
            throw new BaseException(ExceptionType.Illegal_Parameter, "充值金额需大于0。");
        }
        reqDTO.setUserId(userSession.getUserId());
        int result = this.accountDAO.rechargeAccount(reqDTO);
        if (result == SystemExceptionFactory.DB_CALL_FAIL) {
            throw new BaseException(ExceptionType.Business_Insert, "充值失败。");
        }
        return 1;
    }

    @Override
    public BigDecimal initWithdrawal(UserSession userSession) {
//        if (userSession == null) {
//            throw SystemExceptionFactory.loginException();
//        }
        return this.accountDAO.initWithdrawal(userSession.getUserId());
    }

    @Override
    public AccountOverviewRespDTO initBalance(UserSession userSession, String dayStr) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-initBalance(userSession = [" + userSession + "], dayStr = [" + dayStr + "])");
        }
        if (dayStr == null) {
            throw new BaseException(ExceptionType.Business_Query, "日期不能为空。");
        }
        AccountOverviewRespDTO respDTO = new AccountOverviewRespDTO();
        respDTO.setAccountBalance(this.accountDAO.initAllBalance(userSession.getUserId()));
        respDTO.setAccountList(this.accountDAO.selectAccountHistList(userSession.getUserId(), dayStr));
        return respDTO;
    }

    @Override
    public List<AccountHisRespDTO> queryHisList(UserSession userSession, String dayStr) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-queryHisList(userSession = [" + userSession + "], dayStr = [" + dayStr + "])");
        }
        return this.accountDAO.selectAccountHistList(userSession.getUserId(), dayStr);
    }

    @Override
    public int withdrawal(UserSession userSession, AccountWithdraw reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-withdrawal(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "])");
        }
        BigDecimal bigDecimal = this.accountDAO.initWithdrawal(userSession.getUserId());
        if (reqDTO.getWithdrawAmount().compareTo(bigDecimal) > 0) {
            throw new BaseException(ExceptionType.Illegal_Parameter, "最多能提现：" + bigDecimal + " 元。");
        }
        int withdrawal = this.accountDAO.withdrawal(userSession.getUserId(), reqDTO);
        if (withdrawal == SystemExceptionFactory.DB_CALL_FAIL) {
            throw SystemExceptionFactory.callProcedureException();
        }
        return withdrawal;
    }

    @Override
    public int validInviteCode(String inviteCode) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-validInviteCode(inviteCode = [" + inviteCode + "])");
        }
        int i = this.accountDAO.validInviteCode(inviteCode);
        if (i == SystemExceptionFactory.DB_CALL_FAIL) {
            throw SystemExceptionFactory.callProcedureException();
        }
        return i;
    }

}