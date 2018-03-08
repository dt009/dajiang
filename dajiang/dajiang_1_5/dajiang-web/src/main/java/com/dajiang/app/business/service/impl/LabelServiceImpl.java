package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.LabelDAO;
import com.dajiang.app.business.po.dmo.Label;
import com.dajiang.app.business.service.LabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {
    private static final Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);

    @Autowired
    private LabelDAO labelDAO;

    @Override
    public Label selectByPrimaryKey(Integer labelId) {
        return this.labelDAO.selectByPrimaryKey(labelId);
    }

    @Override
    public int deleteByPrimaryKey(Integer labelId) {
        return this.labelDAO.deleteByPrimaryKey(labelId);
    }

    @Override
    public int updateByPrimaryKeySelective(Label record) {
        return this.labelDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Label record) {
        return this.labelDAO.insertSelective(record);
    }
}