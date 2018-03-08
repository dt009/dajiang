package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ProfessionalPhoto;

public interface ProfessionalPhotoService {
    ProfessionalPhoto selectByPrimaryKey(Integer professionalPhotoId);

    int deleteByPrimaryKey(Integer professionalPhotoId);

    int updateByPrimaryKeySelective(ProfessionalPhoto record);

    int insertSelective(ProfessionalPhoto record);
}