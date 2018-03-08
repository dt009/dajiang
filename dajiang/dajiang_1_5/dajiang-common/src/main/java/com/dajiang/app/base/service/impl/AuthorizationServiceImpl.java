package com.dajiang.app.base.service.impl;

import com.dajiang.app.base.po.dmo.LoginDTO;
import com.dajiang.app.base.service.AuthorizationService;
import com.dajiang.app.base.service.LoginService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.util.ExceptionType;
import com.dajiang.app.common.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("authorizationServiceImpl")
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean authenticateUser(String username, String password) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            logger.info("login username:{}", username);
            LoginDTO loginDTO = loginService.selectByLoginName(username);
            if (null != loginDTO) {
                //密码校验
                if (MD5Utils.verify(loginDTO.getLoginPasswd(), password)) {
//                    AepBaseUserLog aepBaseUserLog = new AepBaseUserLog();
//                    aepBaseUserLog.setCompanyId(aepBaseUser.getCompanyId());
//                    aepBaseUserLog.setGlobalUserId(aepBaseUser.getGlobalUserId());
//                    aepBaseUserLog.setLogType("SELF-IN");
//                    aepBaseUserLog.setIp(getIpAddr());
//                    aepBaseUserLogDAO.insert(aepBaseUserLog);
                    return true;
                }
            }
            return false;
        } else {
            throw new BaseException(ExceptionType.Business_Query, "authenticateUser查询的用户名和密码不能为空");
        }
    }

    private String getIpAddr() {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}