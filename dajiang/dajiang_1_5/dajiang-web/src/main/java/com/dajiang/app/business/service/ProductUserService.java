package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ProductUser;

public interface ProductUserService {
    ProductUser selectByPrimaryKey(Integer productUserId);

    int deleteByPrimaryKey(Integer productUserId);

    int updateByPrimaryKeySelective(ProductUser record);

    int insertSelective(ProductUser record);
}