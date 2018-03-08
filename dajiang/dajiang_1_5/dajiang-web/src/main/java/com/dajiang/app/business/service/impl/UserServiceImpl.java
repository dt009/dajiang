package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.dao.LoginDAO;
import com.dajiang.app.base.dao.UserDAO;
import com.dajiang.app.base.po.dmo.LoginDTO;
import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.business.po.dmo.VerificationLog;
import com.dajiang.app.business.po.req.PasswordEditReqDTO;
import com.dajiang.app.business.po.req.PasswordResetReqDTO;
import com.dajiang.app.business.po.req.RegisterReqDTO;
import com.dajiang.app.business.po.req.UserBankReqDTO;
import com.dajiang.app.business.service.UserService;
import com.dajiang.app.business.service.VerificationLogService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.util.ExceptionType;
import com.dajiang.app.common.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("userServiceImpl")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    @Qualifier("verificationLogServiceImpl")
    private VerificationLogService verificationLogService;

    @Override
    public User selectByPrimaryKey(Long userId) {
        return this.userDAO.selectByPrimaryKey(userId);
    }

    @Override
    public User selectBaseInfo(UserSession userSession) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectBaseInfo(userSession = [" + userSession + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        return this.userDAO.selectBaseInfo(userSession.getUserId());
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return this.userDAO.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKey(UserSession userSession, User record) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateByPrimaryKey(userSession = [" + userSession + "], record = [" + record + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        record.setUserId(userSession.getUserId());
        record.setUserUpdatedt(new Date());
//        record.setUserPhotoPath("");
        return this.userDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(User record) {
        return this.userDAO.insertSelective(record);
    }

    @Override
    @Transactional
    public int register(RegisterReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("register(reqDTO = [" + reqDTO + "]) -start");
        }
        if (reqDTO.getUserPhone() == null || reqDTO.getPassword() == null) {
            throw new BaseException(ExceptionType.Business_Query, "请输入手机号。");
        }
        VerificationLog verificationLog = verificationLogService.selectByUserPhone(reqDTO.getUserPhone());
        if (verificationLog == null || verificationLog.getVerificationCode() == null) {
            throw new BaseException(ExceptionType.Business_Query, "请重新获取验证码。");
        }
        if (!verificationLog.getVerificationCode().equals(reqDTO.getVertifCode())) {
            throw new BaseException(ExceptionType.Business_Query, "验证码错误。");
        }
        if (verificationLog.getLastTime().getTime() - new Date().getTime() > 10 * 60 * 1000) {
            throw new BaseException(ExceptionType.Business_Query, "验证码过期,请重新输入。");
        }
        List<User> userList = userDAO.selectByPhone(reqDTO.getUserPhone());
        if (userList != null && userList.size() > 0) {
            throw new BaseException(ExceptionType.SYSTEM_UNKNOWN, "该手机号已注册,请直接登录。");
        }
        LoginDTO record = new LoginDTO();
        record.setLoginName(reqDTO.getUserPhone());
        record.setLoginPasswd(MD5Utils.generate(reqDTO.getPassword()));
        loginDAO.insertSelective(record);
        User user = new User();
        user.setLoginId(record.getLoginId());
        user.setUserPhone(reqDTO.getUserPhone());
        user.setUserInsertdt(new Date());
        user.setUserType((byte) 0);
        return userDAO.insertSelective(user);
    }

    @Override
    public int resetPassword(PasswordResetReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("resetPassword(reqDTO = [" + reqDTO + "]) -start");
        }
        if (reqDTO.getUserPhone() == null || reqDTO.getPassword() == null) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "请输入手机号。");
        }
        List<User> userList = userDAO.selectByPhone(reqDTO.getUserPhone());
        if (userList == null && userList.size() == 0) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "该用户不存在,请查证。");
        }
        if (reqDTO.getPassword() == null || reqDTO.getConfirmPWD() == null || !reqDTO.getPassword().equals(reqDTO.getConfirmPWD())) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_PASSWD, "两次密码不一致。");
        }
        VerificationLog verificationLog = verificationLogService.selectByUserPhone(reqDTO.getUserPhone());
        if (verificationLog == null || verificationLog.getVerificationCode() == null) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_VC, "请重新获取验证码。");
        }
        if (!verificationLog.getVerificationCode().equals(reqDTO.getVertifCode())) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_VC, "验证码错误。");
        }
        if (verificationLog.getLastTime().getTime() - new Date().getTime() > 10 * 60 * 1000) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_VC, "验证码过期,请重新输入。");
        }
        LoginDTO record = new LoginDTO();
        record.setLoginName(reqDTO.getUserPhone());
        record.setLoginPasswd(MD5Utils.generate(reqDTO.getPassword()));
        return loginDAO.updatePasswordByUserPhone(record);
    }


    @Override
    public int editPassword(UserSession userSession, PasswordEditReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("editPassword(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        } else {
            reqDTO.setUserID(userSession.getUserId());
        }
        if (reqDTO.getUserID() == null || reqDTO.getOldPassword() == null || reqDTO.getNewPassword() == null) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "重要参数不能为空。");
        }
        if (reqDTO.getNewPassword() == null || reqDTO.getConfirmPWD() == null || !reqDTO.getNewPassword().equals(reqDTO.getConfirmPWD())) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_PASSWD, "两次密码不一致。");
        }
        User user = userDAO.selectByPrimaryKey(reqDTO.getUserID());
        if (user == null) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "该用户不存在,请查证。");
        }
        LoginDTO loginDTO = loginDAO.selectByPrimaryKey(user.getLoginId());
        if (loginDTO == null) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "该用户异常,请联系客服。");
        }
        if (!MD5Utils.verify(loginDTO.getLoginPasswd(), reqDTO.getOldPassword())) {
            throw new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "您输入的旧密码不正确,请重新输入。");
        }
        LoginDTO record = new LoginDTO();
        record.setLoginId(user.getLoginId());
        record.setLoginPasswd(MD5Utils.generate(reqDTO.getNewPassword()));
        return loginDAO.updateByPrimaryKeySelective(record);
    }


    @Override
    public int updateUserBank(UserSession userSession, UserBankReqDTO userBankReqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateUserBank(userSession = [" + userSession + "], userBankReqDTO = [" + userBankReqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        if (userBankReqDTO == null || userBankReqDTO.getBankNo() == null) {
            throw SystemExceptionFactory.keyException();
        }
        User record = new User();
        record.setUserId(userSession.getUserId());
        record.setUserBankAccname(userBankReqDTO.getBankAccName());
        record.setUserBankname(userBankReqDTO.getBankCode());
        record.setUserBankno(userBankReqDTO.getBankNo());
        return userDAO.updateByPrimaryKeySelective(record);
    }

}