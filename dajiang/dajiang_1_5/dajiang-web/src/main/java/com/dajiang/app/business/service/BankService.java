package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Bank;

import java.util.List;

public interface BankService {
    Bank selectByPrimaryKey(Integer bankId);

    List<Bank> selectAll();
}