package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProfessionalPhotoApplyDAO;
import com.dajiang.app.business.po.dmo.ProfessionalPhotoApply;
import com.dajiang.app.business.service.ProfessionalPhotoApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalPhotoApplyServiceImpl implements ProfessionalPhotoApplyService {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalPhotoApplyServiceImpl.class);

    @Autowired
    private ProfessionalPhotoApplyDAO professionalPhotoApplyDAO;

    @Override
    public ProfessionalPhotoApply selectByPrimaryKey(Integer professionalPhotoApplyId) {
        return this.professionalPhotoApplyDAO.selectByPrimaryKey(professionalPhotoApplyId);
    }

    @Override
    public int deleteByPrimaryKey(Integer professionalPhotoApplyId) {
        return this.professionalPhotoApplyDAO.deleteByPrimaryKey(professionalPhotoApplyId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProfessionalPhotoApply record) {
        return this.professionalPhotoApplyDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(ProfessionalPhotoApply record) {
        return this.professionalPhotoApplyDAO.insertSelective(record);
    }
}