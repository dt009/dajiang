package com.dajiang.app.kuaiqian.service;


import com.dajiang.app.kuaiqian.po.resp.KqUserLog;

public interface KqUserLogService {
    KqUserLog selectByOrderIdDealId(String orderId, String dealId);

    KqUserLog selectByPrimaryKey(Integer kqUserLogId);

    int deleteByPrimaryKey(Integer kqUserLogId);

    int updateByPrimaryKeySelective(KqUserLog record);

    int insertSelective(KqUserLog record);
}