package com.dajiang.app.business.service;

import com.dajiang.app.base.po.dmo.User;
import com.dajiang.app.business.po.req.PasswordEditReqDTO;
import com.dajiang.app.business.po.req.PasswordResetReqDTO;
import com.dajiang.app.business.po.req.RegisterReqDTO;
import com.dajiang.app.business.po.req.UserBankReqDTO;
import com.dajiang.app.common.context.UserSession;

public interface UserService {
    User selectByPrimaryKey(Long userId);

    User selectBaseInfo(UserSession userId);

    int deleteByPrimaryKey(Long userId);

    int updateByPrimaryKey(UserSession userSession, User record);

    int insertSelective(User record);

    /**
     * 用户注册
     *
     * @param reqDTO
     * @return
     */
    int register(RegisterReqDTO reqDTO);

    /**
     * 用户更新密码
     *
     * @param reqDTO
     * @return
     */
    int resetPassword(PasswordResetReqDTO reqDTO);

    /**
     * 用户修改密码
     *
     *
     * @param userSession
     * @param reqDTO
     * @return
     */
    int editPassword(UserSession userSession, PasswordEditReqDTO reqDTO);

    /**
     * 更新用户设置
     *
     * @param userSession
     * @param userBankReqDTO
     * @return
     */
    int updateUserBank(UserSession userSession, UserBankReqDTO userBankReqDTO);
}