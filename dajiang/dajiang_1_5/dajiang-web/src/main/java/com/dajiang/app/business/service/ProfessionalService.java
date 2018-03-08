package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Professional;
import com.dajiang.app.business.po.req.ProfessionalQueryReqDTO;
import com.dajiang.app.business.po.req.ProfessionalReqDTO;
import com.dajiang.app.business.po.resp.ProfessionalBaseInfoRespDTO;
import com.dajiang.app.business.po.resp.ProfessionalRespDTO;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.page.PageReqBean;
import com.dajiang.app.common.page.PageRespBean;

import java.util.List;

public interface ProfessionalService {
    ProfessionalRespDTO selectByPrimaryKey(UserSession userSession, Integer professionalId);

    ProfessionalRespDTO selectByUserId(UserSession reqDTO);

    List<ProfessionalBaseInfoRespDTO> selectShowList();

    PageRespBean<ProfessionalBaseInfoRespDTO> selectForMore(PageReqBean<ProfessionalQueryReqDTO> reqDTO);

    int deleteByPrimaryKey(Integer professionalId);

    int updateByPrimaryKey(ProfessionalReqDTO record);

    int insertSelective(Professional record);

}