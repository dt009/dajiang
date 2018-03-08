package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.CkoApply;
import com.dajiang.app.common.context.UserSession;

public interface CkoApplyService {
    CkoApply selectByPrimaryKey(Integer ckoApplyId);

    CkoApply selectByUserId(UserSession userSession);

    int deleteByPrimaryKey(Integer ckoApplyId);

    int updateByPrimaryKeySelective(CkoApply record);

    int insertSelective(UserSession userSession, CkoApply record);

}