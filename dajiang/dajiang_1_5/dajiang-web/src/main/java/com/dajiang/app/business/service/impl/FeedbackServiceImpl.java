package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.FeedbackDAO;
import com.dajiang.app.business.po.dmo.Feedback;
import com.dajiang.app.business.service.FeedbackService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.util.ExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("feedbackServiceImpl")
@Scope("singleton")
public class FeedbackServiceImpl implements FeedbackService {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private FeedbackDAO feedbackDAO;

    @Override
    public Feedback selectByPrimaryKey(Integer feedbackId) {
        return this.feedbackDAO.selectByPrimaryKey(feedbackId);
    }

    @Override
    public int deleteByPrimaryKey(Integer feedbackId) {
        return this.feedbackDAO.deleteByPrimaryKey(feedbackId);
    }

    @Override
    public int updateByPrimaryKeySelective(Feedback record) {
        return this.feedbackDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(UserSession userSession, Feedback record) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertSelective(record = [" + record + "]) -start");
        }

        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        } else {
            record.setUserId(userSession.getUserId());
        }

        if (record.getUserId() == null) {
            throw new BaseException(ExceptionType.Business_Insert, "用户不能为空。");
        }
        if (record.getFeedbackInsertdt() == null) {
            record.setFeedbackInsertdt(new Date());
        }
        return this.feedbackDAO.insertSelective(record);
    }
}