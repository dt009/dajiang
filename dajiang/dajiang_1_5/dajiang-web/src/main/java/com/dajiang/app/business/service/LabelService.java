package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Label;

public interface LabelService {
    Label selectByPrimaryKey(Integer labelId);

    int deleteByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(Label record);

    int insertSelective(Label record);
}