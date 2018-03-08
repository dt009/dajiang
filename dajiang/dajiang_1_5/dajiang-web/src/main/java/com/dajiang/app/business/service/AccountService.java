package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Account;
import com.dajiang.app.business.po.dmo.AccountWithdraw;
import com.dajiang.app.business.po.req.RechargeReqDTO;
import com.dajiang.app.business.po.resp.AccountHisRespDTO;
import com.dajiang.app.business.po.resp.AccountOverviewRespDTO;
import com.dajiang.app.business.po.resp.AccountRespDTO;
import com.dajiang.app.common.context.UserSession;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    Account selectByPrimaryKey(Integer accountId);

    int deleteByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int insert(Account record);

    AccountRespDTO initRecharge(UserSession userSession);

    int rechargeAccount(UserSession userSession, RechargeReqDTO reqDTO);

    BigDecimal initWithdrawal(UserSession userSession);

    AccountOverviewRespDTO initBalance(UserSession userSession, String dayStr);

    List<AccountHisRespDTO> queryHisList(UserSession userSession, String dayStr);

    int withdrawal(UserSession userSession, AccountWithdraw reqDTO);

    int validInviteCode(String inviteCode);

}