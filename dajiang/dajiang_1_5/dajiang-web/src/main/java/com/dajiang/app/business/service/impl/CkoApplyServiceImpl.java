package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.dao.UserDAO;
import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.business.dao.CkoApplyDAO;
import com.dajiang.app.business.po.dmo.CkoApply;
import com.dajiang.app.business.service.CkoApplyService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ckoApplyServiceImpl")
public class CkoApplyServiceImpl implements CkoApplyService {
    private static final Logger logger = LoggerFactory.getLogger(CkoApplyServiceImpl.class);

    @Autowired
    private CkoApplyDAO ckoApplyDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public CkoApply selectByPrimaryKey(Integer ckoApplyId) {
        return this.ckoApplyDAO.selectByPrimaryKey(ckoApplyId);
    }

    @Override
    public CkoApply selectByUserId(UserSession userSession) {
        CkoApply ckoApply = this.ckoApplyDAO.selectByUserId(userSession.getUserId());
        User user = userDAO.selectByPrimaryKey(ckoApply.getUserId());
        if (user != null) {
            ckoApply.setCkoNickname(user.getUserNickname());
            ckoApply.setUserPhotoPath(user.getUserPhotoPath());
        }
        return ckoApply;
    }

    @Override
    public int deleteByPrimaryKey(Integer ckoApplyId) {
        return this.ckoApplyDAO.deleteByPrimaryKey(ckoApplyId);
    }

    @Override
    public int updateByPrimaryKeySelective(CkoApply record) {
        return this.ckoApplyDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(UserSession userSession, CkoApply record) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertSelective(userSession = [" + userSession + "], record = [" + record + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        } else {
            record.setUserId(userSession.getUserId());
        }
        if (record.getCkoApplyStatus() == null) {
            record.setCkoApplyStatus(Byte.valueOf("0"));
        }
        CkoApply ckoApply = this.ckoApplyDAO.selectByUserId(record.getUserId());
        int i;
        if (ckoApply != null) {
            record.setCkoApplyId(ckoApply.getCkoApplyId());
            i = this.ckoApplyDAO.updateByPrimaryKeySelective(record);
        } else {
            i = this.ckoApplyDAO.insertSelective(record);
        }
        int callCKOApply = this.ckoApplyDAO.callCKOApply(record.getCkoApplyId());
        if (callCKOApply == SystemExceptionFactory.DB_CALL_FAIL) {
            throw SystemExceptionFactory.callProcedureException();
        }
        return i;
    }
}