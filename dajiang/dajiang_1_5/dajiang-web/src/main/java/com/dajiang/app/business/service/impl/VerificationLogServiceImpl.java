package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.dao.UserDAO;
import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.business.dao.VerificationLogDAO;
import com.dajiang.app.business.message.MessageApi;
import com.dajiang.app.business.po.dmo.VerificationLog;
import com.dajiang.app.business.service.VerificationLogService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.util.ExceptionType;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("verificationLogServiceImpl")
@Scope("singleton")
public class VerificationLogServiceImpl implements VerificationLogService {
    private static final Logger logger = LoggerFactory.getLogger(VerificationLogServiceImpl.class);

    @Autowired
    private VerificationLogDAO verificationLogDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public VerificationLog selectByUserPhone(String phone) {
        return verificationLogDAO.selectByUserPhone(phone);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.verificationLogDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(VerificationLog record) {
        return this.verificationLogDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int insertLog(VerificationLog record) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertLog(record = [" + record + "]) -start");
        }

        if (record.getUseType() == null) {
            record.setUseType(VerificationLog.USE_REGISTER);
        }

        String userPhone = record.getUserPhone();
        if (userPhone == null || userPhone.equals("")) {
            throw new BaseException(ExceptionType.Business_Insert, "请输入手机号重试。");
        }

        if (VerificationLog.USE_REGISTER.equals(record.getUseType())) {
            List<User> userList = userDAO.selectByPhone(userPhone);
            if (userList != null && userList.size() > 0) {
                throw new BaseException(ExceptionType.SYSTEM_UNKNOWN, userPhone + ": 该手机号已注册,请直接登录。");
            }
        }
        VerificationLog verificationLog = this.verificationLogDAO.selectByUserPhone(userPhone);
        int result;
        Date opTime = new Date();
        if (verificationLog == null) {
            record.setFirstTime(opTime);
            record.setLastTime(opTime);
            record.setSendTimes(1);
            record.setUseType(record.getUseType());
            result = this.verificationLogDAO.insertSelective(record);
        } else {
            if ((opTime.getTime() - verificationLog.getLastTime().getTime()) < 1000 * 60) {
                throw new BaseException(ExceptionType.SYSTEM_UNKNOWN, "验证码已发送成功，请稍后重试。");
            }
            if (!DateFormatUtils.format(new Date(), "yyyyMMdd").equals(DateFormatUtils.format(verificationLog.getLastTime(), "yyyyMMdd"))) {
                verificationLog.setSendTimes(1);
            } else {
                verificationLog.setSendTimes(verificationLog.getSendTimes() + 1);
            }
            if (verificationLog.getSendTimes() > 10) {
                throw new BaseException(ExceptionType.SYSTEM_UNKNOWN, "验证码发送次数超过当日上限（10次），请明日再试。");
            }
            verificationLog.setLastTime(opTime);
            verificationLog.setVerificationCode(record.getVerificationCode());
            verificationLog.setUseType(record.getUseType());
            result = this.verificationLogDAO.updateByPrimaryKeySelective(verificationLog);
        }
        int i = MessageApi.sendMsg(userPhone, "您的验证码是:" + record.getVerificationCode() + "。验证码10分钟内有效。");
        if (i != 0) {
            throw new BaseException(ExceptionType.SYSTEM_UNKNOWN, "验证码发送失败,请稍后重试。");
        }
        return result;
    }
}