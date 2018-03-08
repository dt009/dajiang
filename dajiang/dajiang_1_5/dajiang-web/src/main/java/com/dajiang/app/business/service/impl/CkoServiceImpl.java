package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.dao.UserDAO;
import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.business.dao.CkoDAO;
import com.dajiang.app.business.po.dmo.Cko;
import com.dajiang.app.business.po.req.CKOQueryReqDTO;
import com.dajiang.app.business.po.req.CkoUpdateReqDTO;
import com.dajiang.app.business.po.resp.CkoBaseInfoRespDTO;
import com.dajiang.app.business.po.resp.CkoRespDTO;
import com.dajiang.app.business.po.resp.CkoUpdateInitRespDTO;
import com.dajiang.app.business.service.CkoService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.page.PageReqBean;
import com.dajiang.app.common.page.PageRespBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("ckoServiceImpl")
@Scope("singleton")
public class CkoServiceImpl implements CkoService {
    private static final Logger logger = LoggerFactory.getLogger(CkoServiceImpl.class);

    @Autowired
    private CkoDAO ckoDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Cko selectByPrimaryKey(Integer ckoKey) {
        return this.ckoDAO.selectByPrimaryKey(ckoKey);
    }

    @Override
    public CkoBaseInfoRespDTO selectBaseInfoByPrimaryKey(Integer ckoKey) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-selectBaseInfoByPrimaryKey(ckoKey = [" + ckoKey + "])");
        }
        CkoBaseInfoRespDTO ckoBaseInfoRespDTO = this.ckoDAO.selectBaseInfoByPrimaryKey(ckoKey);
        User user = userDAO.selectByPrimaryKey(ckoBaseInfoRespDTO.getUserId());
        if (user != null) {
            ckoBaseInfoRespDTO.setUserPhotoPath(user.getUserPhotoPath());
            ckoBaseInfoRespDTO.setCkoNickname(user.getUserNickname());
        }
        return ckoBaseInfoRespDTO;
    }

    @Override
    public PageRespBean<CkoRespDTO> selectForMore(PageReqBean<CKOQueryReqDTO> reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectForMore(reqDTO = [" + reqDTO + "]) -start");
        }
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        return new PageRespBean<>(this.ckoDAO.selectForMore(reqDTO.getCondition()));
    }

    @Override
    public CkoUpdateInitRespDTO selectByUserId(UserSession userSession) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByUserId(userSession = [" + userSession + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.nullException();
        }
        Cko cko = this.ckoDAO.selectByUserId(userSession.getUserId());
        if (cko == null) {
            throw SystemExceptionFactory.nullException();
        }
        User user = this.userDAO.selectByPrimaryKey(cko.getUserId());
        if (user == null) {
            throw SystemExceptionFactory.nullException();
        }
        CkoUpdateInitRespDTO respDTO = new CkoUpdateInitRespDTO();
        respDTO.setCkoEmail(cko.getCkoEmail());
        respDTO.setCkoIscertification(cko.getCkoIscertification());
        respDTO.setCkoIssearch(cko.getCkoIssearch());
        respDTO.setCkoNickname(user.getUserNickname());
        respDTO.setCkoPhone(cko.getCkoPhone());
        respDTO.setUserPhotoPath(user.getUserPhotoPath());
        respDTO.setRegionId(cko.getRegionId());
        respDTO.setRegionName(cko.getRegionName());
        return respDTO;
    }

    @Override
    public int deleteByPrimaryKey(Integer ckoKey) {
        return this.ckoDAO.deleteByPrimaryKey(ckoKey);
    }

    @Override
    public int updateByPrimaryKeySelective(Cko record) {
        return this.ckoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Cko record) {
        return this.ckoDAO.insertSelective(record);
    }

    @Override
    public int updateByUserId(UserSession userSession, CkoUpdateReqDTO reqDTO) {

        if (logger.isDebugEnabled()) {
            logger.debug("updateByUserId(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }

        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        Cko record = this.ckoDAO.selectByUserId(userSession.getUserId());
        if (record == null) {
            throw SystemExceptionFactory.nullException();
        }
        record.setCkoEmail(reqDTO.getCkoEmail());
//        record.setCkoIscertification(reqDTO.getCkoIscertification());
        record.setCkoIssearch(reqDTO.getCkoIssearch());
        record.setCkoUpdatedt(new Date());
        record.setRegionId(reqDTO.getRegionId());
        return this.ckoDAO.updateByPrimaryKeySelective(record);
    }
}