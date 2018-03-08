package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProductDetailDAO;
import com.dajiang.app.business.po.dmo.ProductDetail;
import com.dajiang.app.business.service.ProductDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailServiceImpl.class);

    @Autowired
    private ProductDetailDAO productDetailDAO;

    @Override
    public ProductDetail selectByPrimaryKey(Integer productDetailId) {
        return this.productDetailDAO.selectByPrimaryKey(productDetailId);
    }

    @Override
    public int deleteByPrimaryKey(Integer productDetailId) {
        return this.productDetailDAO.deleteByPrimaryKey(productDetailId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductDetail record) {
        return this.productDetailDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(ProductDetail record) {
        return this.productDetailDAO.insertSelective(record);
    }
}