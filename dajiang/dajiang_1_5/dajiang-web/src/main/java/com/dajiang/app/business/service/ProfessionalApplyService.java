package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ProfessionalApply;
import com.dajiang.app.business.po.req.ProfessionalApplyReqDTO;
import com.dajiang.app.common.context.UserSession;

public interface ProfessionalApplyService {
    ProfessionalApply selectByPrimaryKey(Integer professionalApplyId);

    ProfessionalApply selectByUserId(UserSession userSession);

    int deleteByPrimaryKey(Integer professionalApplyId);

    int updateByPrimaryKeySelective(ProfessionalApply record);

    int insertSelective(UserSession userSession, ProfessionalApplyReqDTO record);
}