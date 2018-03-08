package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProfessionalPhotoDAO;
import com.dajiang.app.business.po.dmo.ProfessionalPhoto;
import com.dajiang.app.business.service.ProfessionalPhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalPhotoServiceImpl implements ProfessionalPhotoService {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalPhotoServiceImpl.class);

    @Autowired
    private ProfessionalPhotoDAO professionalPhotoDAO;

    @Override
    public ProfessionalPhoto selectByPrimaryKey(Integer professionalPhotoId) {
        return this.professionalPhotoDAO.selectByPrimaryKey(professionalPhotoId);
    }

    @Override
    public int deleteByPrimaryKey(Integer professionalPhotoId) {
        return this.professionalPhotoDAO.deleteByPrimaryKey(professionalPhotoId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProfessionalPhoto record) {
        return this.professionalPhotoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(ProfessionalPhoto record) {
        return this.professionalPhotoDAO.insertSelective(record);
    }
}