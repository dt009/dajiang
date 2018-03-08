package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ProductDetailApply;

public interface ProductDetailApplyService {
    ProductDetailApply selectByPrimaryKey(Integer productDetailId);

    int deleteByPrimaryKey(Integer productDetailId);

    int updateByPrimaryKeySelective(ProductDetailApply record);

    int insertSelective(ProductDetailApply record);
}