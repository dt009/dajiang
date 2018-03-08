package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProfessionalTypeDAO;
import com.dajiang.app.business.po.dmo.ProfessionalType;
import com.dajiang.app.business.po.resp.ProfessionalTypeRespDTO;
import com.dajiang.app.business.service.ProfessionalTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("professionalTypeServiceImpl")
@Scope("singleton")
public class ProfessionalTypeServiceImpl implements ProfessionalTypeService {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalTypeServiceImpl.class);

    @Autowired
    private ProfessionalTypeDAO professionalTypeDAO;

    @Override
    public ProfessionalType selectByPrimaryKey(Integer professionalTypeId) {
        return this.professionalTypeDAO.selectByPrimaryKey(professionalTypeId);
    }

    @Override
    public int deleteByPrimaryKey(Integer professionalTypeId) {
        return this.professionalTypeDAO.deleteByPrimaryKey(professionalTypeId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProfessionalType record) {
        return this.professionalTypeDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(ProfessionalType record) {
        return this.professionalTypeDAO.insertSelective(record);
    }

    @Override
    public List<ProfessionalTypeRespDTO> selectByParentId(Integer reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByParentId(reqDTO = [" + reqDTO + "]) -start");
        }
        return this.professionalTypeDAO.selectByParentId(reqDTO);
    }
}