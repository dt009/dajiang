/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * @author zhouwd code generator
 */
public class Bank extends BaseDTO {
    private Integer bankId;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行编号
     */
    private String bankCode;

    /**
     * 账号基本长度
     */
    private Integer bankNumLength;

    private Byte bankSort;

    /**
     * 获取 t_bank.bank_id
     *
     * @return t_bank.bank_id
     */
    public Integer getBankId() {
        return bankId;
    }

    /**
     * 设置 t_bank.bank_id
     *
     * @param bankId t_bank.bank_id
     */
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取 银行名称 t_bank.bank_name
     *
     * @return 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置 银行名称 t_bank.bank_name
     *
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取 银行编号 t_bank.bank_code
     *
     * @return 银行编号
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置 银行编号 t_bank.bank_code
     *
     * @param bankCode 银行编号
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * 获取 账号基本长度 t_bank.bank_num_length
     *
     * @return 账号基本长度
     */
    public Integer getBankNumLength() {
        return bankNumLength;
    }

    /**
     * 设置 账号基本长度 t_bank.bank_num_length
     *
     * @param bankNumLength 账号基本长度
     */
    public void setBankNumLength(Integer bankNumLength) {
        this.bankNumLength = bankNumLength;
    }

    /**
     * 获取 t_bank.bank_sort
     *
     * @return t_bank.bank_sort
     */
    public Byte getBankSort() {
        return bankSort;
    }

    /**
     * 设置 t_bank.bank_sort
     *
     * @param bankSort t_bank.bank_sort
     */
    public void setBankSort(Byte bankSort) {
        this.bankSort = bankSort;
    }
}