package com.dajiang.app.base.service.impl;

import com.dajiang.app.base.po.dmo.BaseUserDTO;
import com.dajiang.app.base.po.dmo.LoginDTO;
import com.dajiang.app.base.po.dmo.RoleDTO;
import com.dajiang.app.base.po.dmo.UserDetailsDTO;
import com.dajiang.app.base.service.FuncService;
import com.dajiang.app.base.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;
    @Autowired
    @Qualifier("funcServiceImpl")
    private FuncService funcService;

    //超级管理员
    public static final String SUPER_ADMIN_KEY = "SUPER_ADMIN";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            List<GrantedAuthority> authorities = new ArrayList<>();
            UserDetailsDTO userDetails;
            List<String> funcNames;
            // 获取用户信息
            LoginDTO loginDTO = loginService.selectByLoginName(username);
            BaseUserDTO baseUserDTO = new BaseUserDTO();
            // 如果是超级管理员加载所有权限
            if (isSuperAdmin(username)) {
                funcNames = funcService.selectAllFuncList();
            } else {
                funcNames = funcService.selectUserRoleFuncListByUserId(username);
            }
            baseUserDTO.setLoginDTO(loginDTO);
            baseUserDTO.setRoleDTO(new RoleDTO());
            // 将查询到funName赋值
            for (String funcName : funcNames) {
                authorities.add(new SimpleGrantedAuthority(funcName));
            }
            userDetails = new UserDetailsDTO(baseUserDTO, authorities);
            return userDetails;
        } catch (Throwable t) {
            logger.error("loadUserByUsername(String)", t);
            throw new UsernameNotFoundException("加载用户失败：" + username, t);
        }
    }

    /**
     * 功能描述：判断是否是超级管理员
     *
     * @param username
     * @return
     */
    private boolean isSuperAdmin(String username) {

        return true;
    }
}