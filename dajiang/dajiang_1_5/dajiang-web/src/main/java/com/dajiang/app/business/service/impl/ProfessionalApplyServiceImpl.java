package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProfessionalApplyDAO;
import com.dajiang.app.business.dao.ProfessionalPhotoApplyDAO;
import com.dajiang.app.business.po.dmo.ProfessionalApply;
import com.dajiang.app.business.po.dmo.ProfessionalPhotoApply;
import com.dajiang.app.business.po.req.ProfessionalApplyReqDTO;
import com.dajiang.app.business.service.ProfessionalApplyService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("professionalApplyServiceImpl")
@Scope("singleton")
public class ProfessionalApplyServiceImpl implements ProfessionalApplyService {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalApplyServiceImpl.class);

    @Autowired
    private ProfessionalApplyDAO professionalApplyDAO;

    @Autowired
    private ProfessionalPhotoApplyDAO professionalPhotoApplyDAO;

    @Override
    public ProfessionalApply selectByPrimaryKey(Integer professionalApplyId) {
        return this.professionalApplyDAO.selectByPrimaryKey(professionalApplyId);
    }

    @Override
    public ProfessionalApply selectByUserId(UserSession userSession) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByUserId(userSession = [" + userSession + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        return this.professionalApplyDAO.selectByUserId(userSession.getUserId());
    }

    @Override
    public int deleteByPrimaryKey(Integer professionalApplyId) {
        return this.professionalApplyDAO.deleteByPrimaryKey(professionalApplyId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProfessionalApply record) {
        return this.professionalApplyDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int insertSelective(UserSession userSession, ProfessionalApplyReqDTO record) {

        if (logger.isDebugEnabled()) {
            logger.debug("insertSelective(userSession = [" + userSession + "], record = [" + record + "]) -start");
        }
        Date insertdt = new Date();
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        } else {
            record.setUserId(userSession.getUserId());
        }

        if (record.getProfessionalApplyInsertdt() == null) {
            record.setProfessionalApplyInsertdt(insertdt);
        }

        ProfessionalApply professionalApply = new ProfessionalApply();
        BeanUtils.copyProperties(record, professionalApply);

        int result = this.professionalApplyDAO.insertSelective(professionalApply);
        List<String> qualificationPicList = record.getQualificationPicList();
        for (int i = 0; i < qualificationPicList.size(); i++) {
            ProfessionalPhotoApply photoApply = new ProfessionalPhotoApply();
            photoApply.setProfessionalApplyId(professionalApply.getProfessionalApplyId());
            photoApply.setUserId(professionalApply.getUserId());
            photoApply.setProfessionalPhotePath(qualificationPicList.get(i));
            photoApply.setProfessionalPhoteSort(i + 1);
            photoApply.setProfessionalPhoteType(Byte.valueOf("1"));
            photoApply.setProfessionalPhoteInsertdt(insertdt);
            professionalPhotoApplyDAO.insertSelective(photoApply);
        }

        List<String> certificatePicList = record.getCertificatePicList();
        for (int i = 0; i < certificatePicList.size(); i++) {
            ProfessionalPhotoApply photoApply = new ProfessionalPhotoApply();
            photoApply.setProfessionalApplyId(professionalApply.getProfessionalApplyId());
            photoApply.setUserId(professionalApply.getUserId());
            photoApply.setProfessionalPhotePath(certificatePicList.get(i));
            photoApply.setProfessionalPhoteSort(i + 1);
            photoApply.setProfessionalPhoteType(Byte.valueOf("2"));
            photoApply.setProfessionalPhoteInsertdt(insertdt);
            professionalPhotoApplyDAO.insertSelective(photoApply);
        }

        List<String> otherPicList = record.getOtherPicList();
        for (int i = 0; i < otherPicList.size(); i++) {
            ProfessionalPhotoApply photoApply = new ProfessionalPhotoApply();
            photoApply.setProfessionalApplyId(professionalApply.getProfessionalApplyId());
            photoApply.setUserId(professionalApply.getUserId());
            photoApply.setProfessionalPhotePath(otherPicList.get(i));
            photoApply.setProfessionalPhoteSort(i + 1);
            photoApply.setProfessionalPhoteType(Byte.valueOf("3"));
            photoApply.setProfessionalPhoteInsertdt(insertdt);
            professionalPhotoApplyDAO.insertSelective(photoApply);
        }
        int callProfApply = professionalPhotoApplyDAO.callProfApply(professionalApply.getProfessionalApplyId());
        if (callProfApply == SystemExceptionFactory.DB_CALL_FAIL) {
            throw SystemExceptionFactory.callProcedureException();
        }
        return result;
    }
}