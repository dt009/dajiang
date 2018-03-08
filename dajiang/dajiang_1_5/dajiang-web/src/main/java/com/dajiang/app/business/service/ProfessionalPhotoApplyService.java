package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ProfessionalPhotoApply;

public interface ProfessionalPhotoApplyService {
    ProfessionalPhotoApply selectByPrimaryKey(Integer professionalPhotoApplyId);

    int deleteByPrimaryKey(Integer professionalPhotoApplyId);

    int updateByPrimaryKeySelective(ProfessionalPhotoApply record);

    int insertSelective(ProfessionalPhotoApply record);
}