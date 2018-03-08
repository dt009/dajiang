package com.dajiang.app.base.service;

import com.dajiang.app.base.po.dmo.LoginDTO;
import com.dajiang.app.base.po.resp.UserRespDTO;

public interface LoginService {
    LoginDTO selectByPrimaryKey(Integer loginId);

    int deleteByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(LoginDTO record);

    int insertSelective(LoginDTO record);

    LoginDTO selectByLoginName(String loginName);

    UserRespDTO authLogin(LoginDTO reqDTO);
}