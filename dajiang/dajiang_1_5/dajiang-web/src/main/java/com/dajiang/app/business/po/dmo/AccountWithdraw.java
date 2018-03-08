package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 提现表 t_account_withdraw
 *
 * @author zhouwd code generator
 */
public class AccountWithdraw extends BaseDTO {
    private Integer withdrawId;

    /**
     * 提现用户id
     */
    private Long userId;

    /**
     * 提现人名
     */
    private String withdrawName;

    /**
     * 提现银行名称
     */
    private String withdrawBankname;

    /**
     * 提现银行账号
     */
    private String withdrawBankno;

    /**
     * 提现金额
     */
    private BigDecimal withdrawAmount;

    /**
     * 提现状态 1:提出申请 ; 2:处理中;3:完成
     */
    private Integer withdrawStatus;

    /**
     * 提交时间
     */
    private Date withdrawApplydt;

    /**
     * 完成时间
     */
    private Date withdrawFinishdt;

    /**
     * 获取 t_account_withdraw.withdraw_id
     *
     * @return t_account_withdraw.withdraw_id
     */
    public Integer getWithdrawId() {
        return withdrawId;
    }

    /**
     * 设置 t_account_withdraw.withdraw_id
     *
     * @param withdrawId t_account_withdraw.withdraw_id
     */
    public void setWithdrawId(Integer withdrawId) {
        this.withdrawId = withdrawId;
    }

    /**
     * 获取 提现用户id t_account_withdraw.user_id
     *
     * @return 提现用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 提现用户id t_account_withdraw.user_id
     *
     * @param userId 提现用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 提现人名 t_account_withdraw.withdraw_name
     *
     * @return 提现人名
     */
    public String getWithdrawName() {
        return withdrawName;
    }

    /**
     * 设置 提现人名 t_account_withdraw.withdraw_name
     *
     * @param withdrawName 提现人名
     */
    public void setWithdrawName(String withdrawName) {
        this.withdrawName = withdrawName == null ? null : withdrawName.trim();
    }

    /**
     * 获取 提现银行名称 t_account_withdraw.withdraw_bankname
     *
     * @return 提现银行名称
     */
    public String getWithdrawBankname() {
        return withdrawBankname;
    }

    /**
     * 设置 提现银行名称 t_account_withdraw.withdraw_bankname
     *
     * @param withdrawBankname 提现银行名称
     */
    public void setWithdrawBankname(String withdrawBankname) {
        this.withdrawBankname = withdrawBankname == null ? null : withdrawBankname.trim();
    }

    /**
     * 获取 提现银行账号 t_account_withdraw.withdraw_bankno
     *
     * @return 提现银行账号
     */
    public String getWithdrawBankno() {
        return withdrawBankno;
    }

    /**
     * 设置 提现银行账号 t_account_withdraw.withdraw_bankno
     *
     * @param withdrawBankno 提现银行账号
     */
    public void setWithdrawBankno(String withdrawBankno) {
        this.withdrawBankno = withdrawBankno == null ? null : withdrawBankno.trim();
    }

    /**
     * 获取 提现金额 t_account_withdraw.withdraw_amount
     *
     * @return 提现金额
     */
    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    /**
     * 设置 提现金额 t_account_withdraw.withdraw_amount
     *
     * @param withdrawAmount 提现金额
     */
    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    /**
     * 获取 提现状态 1:提出申请 ; 2:处理中;3:完成 t_account_withdraw.withdraw_status
     *
     * @return 提现状态 1:提出申请 ; 2:处理中;3:完成
     */
    public Integer getWithdrawStatus() {
        return withdrawStatus;
    }

    /**
     * 设置 提现状态 1:提出申请 ; 2:处理中;3:完成 t_account_withdraw.withdraw_status
     *
     * @param withdrawStatus 提现状态 1:提出申请 ; 2:处理中;3:完成
     */
    public void setWithdrawStatus(Integer withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    /**
     * 获取 提交时间 t_account_withdraw.withdraw_applydt
     *
     * @return 提交时间
     */
    public Date getWithdrawApplydt() {
        return withdrawApplydt;
    }

    /**
     * 设置 提交时间 t_account_withdraw.withdraw_applydt
     *
     * @param withdrawApplydt 提交时间
     */
    public void setWithdrawApplydt(Date withdrawApplydt) {
        this.withdrawApplydt = withdrawApplydt;
    }

    /**
     * 获取 完成时间 t_account_withdraw.withdraw_finishdt
     *
     * @return 完成时间
     */
    public Date getWithdrawFinishdt() {
        return withdrawFinishdt;
    }

    /**
     * 设置 完成时间 t_account_withdraw.withdraw_finishdt
     *
     * @param withdrawFinishdt 完成时间
     */
    public void setWithdrawFinishdt(Date withdrawFinishdt) {
        this.withdrawFinishdt = withdrawFinishdt;
    }
}