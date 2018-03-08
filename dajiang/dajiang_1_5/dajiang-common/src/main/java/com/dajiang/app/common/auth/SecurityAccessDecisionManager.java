package com.dajiang.app.common.auth;

import com.dajiang.app.base.po.dmo.BaseUserDTO;
import com.dajiang.app.base.po.dmo.UserDetailsDTO;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;

public class SecurityAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        if (null == configAttributes) {
            return;
        }
        // 获取资源与角色对应关系列表
        Iterator<ConfigAttribute> iterable = configAttributes.iterator();
        while (iterable.hasNext()) {

            ConfigAttribute configAttribute = iterable.next();
            // permitAll直接越过
            if (configAttribute.toString().equals("permitAll")) {
                return;
            }

            HttpServletRequest request = ((FilterInvocation) object).getRequest();
            String strContestPath = request.getContextPath();
            String strRequestURL = request.getRequestURI();
            String strUrl = strRequestURL.replace(strContestPath, "");

            // 登录检验
            BaseUserDTO sessionInfo;
            // 获取用户对象信息
            if ("anonymousUser".equals(authentication.getPrincipal())) {
                throw new AccessDeniedException("没有权限,请求地址: " + strUrl);
            }

            UserDetailsDTO aepUserDetailsDTO = (UserDetailsDTO) authentication.getPrincipal();
            sessionInfo = aepUserDetailsDTO.getBaseUserDTO();
            if (null == sessionInfo) {
                throw new AccessDeniedException("session错误,没有权限。");
            }
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}