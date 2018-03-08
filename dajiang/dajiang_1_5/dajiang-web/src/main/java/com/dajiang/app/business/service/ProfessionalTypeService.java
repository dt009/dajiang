package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ProfessionalType;
import com.dajiang.app.business.po.resp.ProfessionalTypeRespDTO;

import java.util.List;

public interface ProfessionalTypeService {
    ProfessionalType selectByPrimaryKey(Integer professionalTypeId);

    int deleteByPrimaryKey(Integer professionalTypeId);

    int updateByPrimaryKeySelective(ProfessionalType record);

    int insertSelective(ProfessionalType record);

    List<ProfessionalTypeRespDTO> selectByParentId(Integer reqDTO);
}