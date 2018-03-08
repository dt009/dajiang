package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.LabelMapping;

public interface LabelMappingService {
    LabelMapping selectByPrimaryKey(Integer labelMappingId);

    int deleteByPrimaryKey(Integer labelMappingId);

    int updateByPrimaryKeySelective(LabelMapping record);

    int insertSelective(LabelMapping record);
}