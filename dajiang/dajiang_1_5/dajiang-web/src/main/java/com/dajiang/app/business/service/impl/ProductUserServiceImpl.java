package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProductUserDAO;
import com.dajiang.app.business.po.dmo.ProductUser;
import com.dajiang.app.business.service.ProductUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUserServiceImpl implements ProductUserService {
    private static final Logger logger = LoggerFactory.getLogger(ProductUserServiceImpl.class);

    @Autowired
    private ProductUserDAO productUserDAO;

    @Override
    public ProductUser selectByPrimaryKey(Integer productUserId) {
        return this.productUserDAO.selectByPrimaryKey(productUserId);
    }

    @Override
    public int deleteByPrimaryKey(Integer productUserId) {
        return this.productUserDAO.deleteByPrimaryKey(productUserId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductUser record) {
        return this.productUserDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(ProductUser record) {
        return this.productUserDAO.insertSelective(record);
    }
}