package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProductDetailApplyDAO;
import com.dajiang.app.business.po.dmo.ProductDetailApply;
import com.dajiang.app.business.service.ProductDetailApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailApplyServiceImpl implements ProductDetailApplyService {
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailApplyServiceImpl.class);

    @Autowired
    private ProductDetailApplyDAO productDetailApplyDAO;

    @Override
    public ProductDetailApply selectByPrimaryKey(Integer productDetailId) {
        return this.productDetailApplyDAO.selectByPrimaryKey(productDetailId);
    }

    @Override
    public int deleteByPrimaryKey(Integer productDetailId) {
        return this.productDetailApplyDAO.deleteByPrimaryKey(productDetailId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductDetailApply record) {
        return this.productDetailApplyDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(ProductDetailApply record) {
        return this.productDetailApplyDAO.insertSelective(record);
    }
}