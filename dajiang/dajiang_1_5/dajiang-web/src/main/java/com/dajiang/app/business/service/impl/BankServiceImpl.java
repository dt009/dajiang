package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.BankDAO;
import com.dajiang.app.business.po.dmo.Bank;
import com.dajiang.app.business.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bankServiceImpl")
@Scope("singleton")
public class BankServiceImpl implements BankService {
    private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankDAO bankDAO;

    @Override
    public Bank selectByPrimaryKey(Integer bankId) {
        return this.bankDAO.selectByPrimaryKey(bankId);
    }

    @Override
    public List<Bank> selectAll() {
        return this.bankDAO.selectAll();
    }
}