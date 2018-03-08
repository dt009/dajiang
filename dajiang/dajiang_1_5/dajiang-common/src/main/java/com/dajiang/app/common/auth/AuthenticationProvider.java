package com.dajiang.app.common.auth;

import com.dajiang.app.base.service.AuthorizationService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.util.ExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationProvider.class);

    @Autowired
    @Qualifier("authorizationServiceImpl")
    private AuthorizationService authorizationService;

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsServiceImpl;

    /**
     * 验证用户登录信息
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getPrincipal() == null) {
            throw new BaseException(ExceptionType.Business_Query, "未提供用户名密码");
        }
        String username = authentication.getName();
        String passWord = (String) authentication.getCredentials();
        boolean success;
        try {
            success = authorizationService.authenticateUser(username, passWord);
        } catch (Throwable e) {
            logger.error("无法验证用户信息，用户名: " + username, e);
            throw new AuthenticationServiceException("无法验证用户信息，用户名: " + username, e);
        }
        if (!success) {
            logger.info("验证用户信息失败，用户名: " + username);
            throw new AuthenticationServiceException("验证用户信息失败，用户名: " + username);
        }
    }

    /**
     * 获取权限信息
     */
    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        UserDetails loadedUser;
        try {
            loadedUser = userDetailsServiceImpl.loadUserByUsername(username);
            if (loadedUser == null) {
                throw new AuthenticationServiceException("UserDetailsService 返回null，这是一个接口契约违背");
            }
            if (loadedUser.getAuthorities().size() < 0) {
                throw new UsernameNotFoundException("该用户不具备任何权限: " + username);
            }
        } catch (UsernameNotFoundException notFound) {
            logger.error("该用户不具备任何权限: " + username, notFound);
            throw notFound;
        } catch (Exception repositoryProblem) {
            logger.info("无法查询到用户信息: " + username, repositoryProblem);
            throw new AuthenticationServiceException(
                    repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }
}
