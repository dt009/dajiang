package com.dajiang.app.kuaiqian.service.impl;

import com.dajiang.app.kuaiqian.dao.KqUserLogDAO;
import com.dajiang.app.kuaiqian.po.resp.KqUserLog;
import com.dajiang.app.kuaiqian.service.KqUserLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("kqUserLogServiceImpl")
@Scope("singleton")
public class KqUserLogServiceImpl implements KqUserLogService {
    private static final Logger logger = LoggerFactory.getLogger(KqUserLogServiceImpl.class);

    @Autowired
    private KqUserLogDAO kqUserLogDAO;

    @Override
    public KqUserLog selectByOrderIdDealId(String orderId, String dealId) {
        return this.kqUserLogDAO.selectByOrderIdDealId(orderId, dealId);
    }

    @Override
    public KqUserLog selectByPrimaryKey(Integer kqUserLogId) {
        return this.kqUserLogDAO.selectByPrimaryKey(kqUserLogId);
    }

    @Override
    public int deleteByPrimaryKey(Integer kqUserLogId) {
        return this.kqUserLogDAO.deleteByPrimaryKey(kqUserLogId);
    }

    @Override
    public int updateByPrimaryKeySelective(KqUserLog record) {
        return this.kqUserLogDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(KqUserLog record) {
        return this.kqUserLogDAO.insertSelective(record);
    }
}