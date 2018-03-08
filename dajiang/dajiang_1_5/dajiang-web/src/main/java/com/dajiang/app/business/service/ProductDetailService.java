package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ProductDetail;

public interface ProductDetailService {
    ProductDetail selectByPrimaryKey(Integer productDetailId);

    int deleteByPrimaryKey(Integer productDetailId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int insertSelective(ProductDetail record);
}