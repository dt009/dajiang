package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.CollectionDAO;
import com.dajiang.app.business.dao.ProfessionalDAO;
import com.dajiang.app.business.dao.ProfessionalPhotoDAO;
import com.dajiang.app.business.po.dmo.Collection;
import com.dajiang.app.business.po.resp.CollectionRespDTO;
import com.dajiang.app.business.po.resp.ProfessionalRespDTO;
import com.dajiang.app.business.service.CollectionService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.util.ExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("collectionServiceImpl")
@Scope("singleton")
public class CollectionServiceImpl implements CollectionService {
    private static final Logger logger = LoggerFactory.getLogger(CollectionServiceImpl.class);

    @Autowired
    private CollectionDAO collectionDAO;

    @Autowired
    private ProfessionalDAO professionalDAO;

    @Autowired
    private ProfessionalPhotoDAO professionalPhotoDAO;

    @Override
    public ProfessionalRespDTO selectByPrimaryKey(UserSession userSession, Integer collectionId) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByPrimaryKey(userSession = [" + userSession + "], collectionId = [" + collectionId + "]) -start");
        }
        Collection collection = this.collectionDAO.selectByPrimaryKey(collectionId);
        if (collection == null) {
            throw SystemExceptionFactory.nullException();
        }
        if (!collection.getUserId().equals(userSession.getUserId())) {
            throw SystemExceptionFactory.authorityException();
        }
        ProfessionalRespDTO professionalRespDTO = professionalDAO.selectBaseInfoByPrimaryKey(collection.getProfessionalId());
        if (professionalRespDTO == null) {
            throw new BaseException(ExceptionType.Business_Query, "没有找到对应的大匠。");
        }
        professionalRespDTO.setQualificationPicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("1")));
        professionalRespDTO.setCertificatePicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("2")));
        professionalRespDTO.setOtherPicList(professionalPhotoDAO.selectByProfessionalId(professionalRespDTO.getProfessionalId(), Byte.valueOf("3")));
        return professionalRespDTO;
    }

    @Override
    public List<CollectionRespDTO> selectByUserId(UserSession reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByUserId(reqDTO = [" + reqDTO + "]) -start");
        }
        if (reqDTO == null) {
            throw SystemExceptionFactory.loginException();
        }
        return this.collectionDAO.selectByUserId(reqDTO.getUserId());
    }

    @Override
    public int deleteByPrimaryKey(UserSession userSession, Integer professionalId) {
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        return this.collectionDAO.deleteByPrimaryKey(userSession.getUserId(), professionalId);
    }

    @Override
    public int updateByPrimaryKeySelective(Collection record) {
        return this.collectionDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(UserSession userSession, Integer professionalId) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertSelective(userSession = [" + userSession + "], professionalId = [" + professionalId + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        Collection collection = collectionDAO.selectByUserIdProId(userSession.getUserId(), professionalId);
        if (collection != null) {
            return 0;
        }
        Collection record = new Collection();
        record.setCollectionInsertdt(new Date());
        record.setUserId(userSession.getUserId());
        record.setProfessionalId(professionalId);
        return this.collectionDAO.insertSelective(record);
    }
}