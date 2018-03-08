package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.CollectionDAO;
import com.dajiang.app.business.dao.ProfessionalDAO;
import com.dajiang.app.business.dao.ProfessionalPhotoDAO;
import com.dajiang.app.business.po.dmo.Professional;
import com.dajiang.app.business.po.req.ProfessionalQueryReqDTO;
import com.dajiang.app.business.po.req.ProfessionalReqDTO;
import com.dajiang.app.business.po.resp.ProfessionalBaseInfoRespDTO;
import com.dajiang.app.business.po.resp.ProfessionalRespDTO;
import com.dajiang.app.business.service.ProfessionalService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.page.PageReqBean;
import com.dajiang.app.common.page.PageRespBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("professionalServiceImpl")
@Scope("singleton")
public class ProfessionalServiceImpl implements ProfessionalService {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalServiceImpl.class);

    @Autowired
    private ProfessionalDAO professionalDAO;

    @Autowired
    private ProfessionalPhotoDAO professionalPhotoDAO;

    @Autowired
    private CollectionDAO collectionDAO;

    @Override
    public ProfessionalRespDTO selectByPrimaryKey(UserSession userSession, Integer professionalId) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByPrimaryKey(professionalId = [" + professionalId + "]) -start");
        }
        ProfessionalRespDTO professionalRespDTO = this.professionalDAO.selectBaseInfoByPrimaryKey(professionalId);
        if (professionalRespDTO == null) {
            throw SystemExceptionFactory.nullException();
        }
        if (userSession == null) {
            professionalRespDTO.setCollectionState(0);
        } else {
            professionalRespDTO.setCollectionState(1);
            if (collectionDAO.selectByUserIdProId(userSession.getUserId(), professionalRespDTO.getProfessionalId()) != null) {
                professionalRespDTO.setCollectionState(2);
            }
        }
        professionalRespDTO.setCollectionCount(collectionDAO.selectCountByProId(professionalRespDTO.getProfessionalId()));
        professionalRespDTO.setQualificationPicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("1")));
        professionalRespDTO.setCertificatePicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("2")));
        professionalRespDTO.setOtherPicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("3")));
        return professionalRespDTO;
    }

    @Override
    public ProfessionalRespDTO selectByUserId(UserSession user) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByUserId(user = [" + user + "]) -start");
        }
        if (user == null) {
            throw SystemExceptionFactory.loginException();
        }
        ProfessionalRespDTO professionalRespDTO = this.professionalDAO.selectByUserId(user.getUserId());
        if (professionalRespDTO == null) {
            throw SystemExceptionFactory.nullException();
        }
        professionalRespDTO.setQualificationPicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("1")));
        professionalRespDTO.setCertificatePicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("2")));
        professionalRespDTO.setOtherPicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("3")));
        return professionalRespDTO;
    }

    @Override
    public List<ProfessionalBaseInfoRespDTO> selectShowList() {
        if (logger.isDebugEnabled()) {
            logger.debug("selectShowList() -start");
        }
        PageHelper.startPage(1, 5);
        return this.professionalDAO.selectShowList(null);
    }

    @Override
    public PageRespBean<ProfessionalBaseInfoRespDTO> selectForMore(PageReqBean<ProfessionalQueryReqDTO> reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectForMore(reqDTO = [" + reqDTO + "]) -start");
        }
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        return new PageRespBean<>(this.professionalDAO.selectShowList(reqDTO.getCondition()));
    }

    @Override
    public int deleteByPrimaryKey(Integer professionalId) {
        if (logger.isDebugEnabled()) {
            logger.debug("deleteByPrimaryKey(professionalId = [" + professionalId + "]) -start");
        }
        return this.professionalDAO.deleteByPrimaryKey(professionalId);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(ProfessionalReqDTO record) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateByPrimaryKey(record = [" + record + "]) -start");
        }

        Professional professional = new Professional();
        BeanUtils.copyProperties(record, professional);
        professional.setProfessionalIndroduction(record.getProfessionalIntroduction());
//        Date insertDT = new Date();
        int result = this.professionalDAO.updateByPrimaryKeySelective(professional);
//        List<String> qualificationPicList = record.getQualificationPicList();
//        professionalPhotoDAO.deleteByProfessionalId(professional.getProfessionalId());//产出改用户所有的ID
//        for (int i = 0; i < qualificationPicList.size(); i++) {
//            ProfessionalPhoto professionalPhoto = new ProfessionalPhoto();
//            professionalPhoto.setProfessionalId(professional.getProfessionalId());
//            professionalPhoto.setUserId(professional.getUserId());
//            professionalPhoto.setProfessionalPhotePath(qualificationPicList.get(i));
//            professionalPhoto.setProfessionalPhoteSort(i + 1);
//            professionalPhoto.setProfessionalPhoteType(Byte.valueOf("1"));
//            professionalPhoto.setProfessionalPhoteInsertdt(insertDT);
//            professionalPhotoDAO.insertSelective(professionalPhoto);
//        }
//
//        List<String> certificatePicList = record.getCertificatePicList();
//        for (int i = 0; i < certificatePicList.size(); i++) {
//            ProfessionalPhoto photoApply = new ProfessionalPhoto();
//            photoApply.setProfessionalId(professional.getProfessionalId());
//            photoApply.setUserId(professional.getUserId());
//            photoApply.setProfessionalPhotePath(certificatePicList.get(i));
//            photoApply.setProfessionalPhoteSort(i + 1);
//            photoApply.setProfessionalPhoteType(Byte.valueOf("2"));
//            photoApply.setProfessionalPhoteInsertdt(insertDT);
//            professionalPhotoDAO.insertSelective(photoApply);
//        }
//
//        List<String> otherPicList = record.getOtherPicList();
//        for (int i = 0; i < otherPicList.size(); i++) {
//            ProfessionalPhoto photoApply = new ProfessionalPhoto();
//            photoApply.setProfessionalId(professional.getProfessionalId());
//            photoApply.setUserId(professional.getUserId());
//            photoApply.setProfessionalPhotePath(otherPicList.get(i));
//            photoApply.setProfessionalPhoteSort(i + 1);
//            photoApply.setProfessionalPhoteType(Byte.valueOf("3"));
//            photoApply.setProfessionalPhoteInsertdt(insertDT);
//            professionalPhotoDAO.insertSelective(photoApply);
//        }
        return result;
    }

    @Override
    public int insertSelective(Professional record) {
        return this.professionalDAO.insertSelective(record);
    }

}