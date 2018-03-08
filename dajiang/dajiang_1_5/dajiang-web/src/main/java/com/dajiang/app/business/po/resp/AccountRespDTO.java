package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class AccountRespDTO extends BaseDTO {

    /**
     * 主键自增
     */
    private Integer accountId;

    /**
     * 资金类型：1、收款；2、提现；3、付款；
     */
    private byte[] accountType;

    /**
     * 发生订单id
     */
    private Integer orderId;

    /**
     * 金额
     */
    private BigDecimal accountAmount;

    /**
     * 余额
     */
    private BigDecimal accountBalance;

    /**
     * 描述
     */
    private String accountDesc;

    /**
     * 发生时间
     */
    private Date accountInsertdt;

    /**
     * 获取 主键自增 t_account.account_id
     *
     * @return 主键自增
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置 主键自增 t_account.account_id
     *
     * @param accountId 主键自增
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取 资金类型：1、收款；2、提现；3、付款； t_account.account_type
     *
     * @return 资金类型：1、收款；2、提现；3、付款；
     */
    public byte[] getAccountType() {
        return accountType;
    }

    /**
     * 设置 资金类型：1、收款；2、提现；3、付款； t_account.account_type
     *
     * @param accountType 资金类型：1、收款；2、提现；3、付款；
     */
    public void setAccountType(byte[] accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取 发生订单id t_account.order_id
     *
     * @return 发生订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置 发生订单id t_account.order_id
     *
     * @param orderId 发生订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 金额 t_account.account_amount
     *
     * @return 金额
     */
    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    /**
     * 设置 金额 t_account.account_amount
     *
     * @param accountAmount 金额
     */
    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    /**
     * 获取 余额 t_account.account_balance
     *
     * @return 余额
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * 设置 余额 t_account.account_balance
     *
     * @param accountBalance 余额
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * 获取 描述 t_account.account_desc
     *
     * @return 描述
     */
    public String getAccountDesc() {
        return accountDesc;
    }

    /**
     * 设置 描述 t_account.account_desc
     *
     * @param accountDesc 描述
     */
    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc == null ? null : accountDesc.trim();
    }

    /**
     * 获取 发生时间 t_account.account_insertDT
     *
     * @return 发生时间
     */
    public Date getAccountInsertdt() {
        return accountInsertdt;
    }

    /**
     * 设置 发生时间 t_account.account_insertDT
     *
     * @param accountInsertdt 发生时间
     */
    public void setAccountInsertdt(Date accountInsertdt) {
        this.accountInsertdt = accountInsertdt;
    }


}
