package com.dajiang.app.business.service;


import com.dajiang.app.business.po.dmo.VerificationLog;

public interface VerificationLogService {

    VerificationLog selectByUserPhone(String phone);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VerificationLog record);

    int insertLog(VerificationLog record);
}