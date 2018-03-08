package com.dajiang.app.base.service.impl;

import com.dajiang.app.base.dao.LoginDAO;
import com.dajiang.app.base.dao.UserDAO;
import com.dajiang.app.base.po.dmo.LoginDTO;
import com.dajiang.app.base.po.resp.UserRespDTO;
import com.dajiang.app.base.service.LoginService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.util.ExceptionType;
import com.dajiang.app.common.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public LoginDTO selectByPrimaryKey(Integer loginId) {
        return this.loginDAO.selectByPrimaryKey(loginId);
    }

    @Override
    public int deleteByPrimaryKey(Integer loginId) {
        return this.loginDAO.deleteByPrimaryKey(loginId);
    }

    @Override
    public int updateByPrimaryKeySelective(LoginDTO record) {
        return this.loginDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(LoginDTO record) {
        return this.loginDAO.insertSelective(record);
    }

    @Override
    public LoginDTO selectByLoginName(String loginName) {
        return this.loginDAO.selectByLoginName(loginName);
    }

    @Override
    public UserRespDTO authLogin(LoginDTO reqDTO) {
        LoginDTO loginDTO = this.loginDAO.selectByLoginName(reqDTO.getLoginName());
        if (loginDTO == null) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "用户不存在, 请检查用户名。");
        }
        boolean verify = MD5Utils.verify(loginDTO.getLoginPasswd(), reqDTO.getLoginPasswd());
        if (!verify) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "用户名和密码不匹配，请检查用户名和密码。");
        }
        UserRespDTO userRespDTO = userDAO.selectByLoginId(loginDTO.getLoginId());
        if (userRespDTO == null) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "用户信息异常,请联系客服。");
        }
        return userRespDTO;
    }
}