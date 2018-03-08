package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.LoginDTO;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.base.po.resp.UserRespDTO;
import com.dajiang.app.base.service.LoginService;
import com.dajiang.app.business.po.resp.LoginStatusRespDTO;
import com.dajiang.app.business.service.UserService;
import com.dajiang.app.common.context.StaticContext;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Joe on 2017/9/11.
 */
@RestController
public class LoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     *
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public ResponseBaseDTO<LoginStatusRespDTO> isLogin() {
        try {
            UserSession userSession = getUserSession();
            LoginStatusRespDTO loginStatusRespDTO = new LoginStatusRespDTO();
            if (userSession == null) {
                loginStatusRespDTO.setLoginStatus("N");
            } else {
                updateUserSession(userSession);
                loginStatusRespDTO.setLoginStatus("Y");
                loginStatusRespDTO.getDataMap().put("user", userSession);
            }
            if (logger.isDebugEnabled()) {
                logger.debug("isLogin() -loginStatusRespDTO={}", loginStatusRespDTO);
            }
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, loginStatusRespDTO);
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    @RequestMapping("/login")
    public ResponseBaseDTO<Object> login(HttpServletResponse response, @RequestBody LoginDTO reqDTO) {
        try {
            Date loginTime = new Date();
            UserRespDTO loginDTO = loginService.authLogin(reqDTO);
            if (loginDTO != null) {
                response.addCookie(new Cookie(StaticContext.X_KEY, MD5Utils.generate(loginDTO.getLoginId(), reqDTO.getLoginName())));
                String token = MD5Utils.generate(loginDTO.getLoginId(), loginDTO.getUserId(), loginTime);
                response.addHeader(StaticContext.X_TOKEN, token);
                UserSession userSession = initUserSession(loginDTO, token, loginTime);
                return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "登录成功。", userSession);
            }
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "登录失败。");
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "登录失败。");
        }
    }

    @RequestMapping("/loginOut")
    public ResponseBaseDTO<Object> loginOut() {
        try {
            RequestContextHolder.getRequestAttributes().setAttribute(StaticContext.USER_SESSION, null, RequestAttributes.SCOPE_SESSION);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "登出成功。");
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "登出失败。");
        }
    }


    private UserSession initUserSession(UserRespDTO loginDTO, String token, Date loginTime) {
        UserSession userSession = new UserSession();
        userSession.setLoginId(loginDTO.getLoginId());
        userSession.setUserId(loginDTO.getUserId());
        userSession.setLoginTime(loginTime);
        userSession.setUserToken(token);
        updateUserSession(userSession);
        RequestContextHolder.getRequestAttributes().setAttribute(StaticContext.USER_SESSION, userSession, RequestAttributes.SCOPE_SESSION);
        return userSession;
    }

    private void updateUserSession(UserSession userSession) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-updateUserSession(userSession = [" + userSession + "])");
        }

        User user = userService.selectByPrimaryKey(userSession.getUserId());
        if (user != null) {
            userSession.setUserNickname(user.getUserNickname());
        }
        userSession.setUserPhotoPath(user.getUserPhotoPath());
        userSession.setUserType(user.getUserType().intValue());
        if (logger.isDebugEnabled()) {
            logger.debug("End-updateUserSession(userSession = [" + userSession + "])");
        }
    }


}
