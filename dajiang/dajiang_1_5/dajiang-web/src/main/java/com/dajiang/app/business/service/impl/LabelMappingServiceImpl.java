package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.LabelMappingDAO;
import com.dajiang.app.business.po.dmo.LabelMapping;
import com.dajiang.app.business.service.LabelMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelMappingServiceImpl implements LabelMappingService {
    private static final Logger logger = LoggerFactory.getLogger(LabelMappingServiceImpl.class);

    @Autowired
    private LabelMappingDAO labelMappingDAO;

    @Override
    public LabelMapping selectByPrimaryKey(Integer labelMappingId) {
        return this.labelMappingDAO.selectByPrimaryKey(labelMappingId);
    }

    @Override
    public int deleteByPrimaryKey(Integer labelMappingId) {
        return this.labelMappingDAO.deleteByPrimaryKey(labelMappingId);
    }

    @Override
    public int updateByPrimaryKeySelective(LabelMapping record) {
        return this.labelMappingDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(LabelMapping record) {
        return this.labelMappingDAO.insertSelective(record);
    }
}