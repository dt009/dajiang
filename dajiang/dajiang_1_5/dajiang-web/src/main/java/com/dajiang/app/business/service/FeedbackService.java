package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Feedback;
import com.dajiang.app.common.context.UserSession;

public interface FeedbackService {
    Feedback selectByPrimaryKey(Integer feedbackId);

    int deleteByPrimaryKey(Integer feedbackId);

    int updateByPrimaryKeySelective(Feedback record);

    int insertSelective(UserSession userSession, Feedback record);
}