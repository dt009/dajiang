/* github.com/zhouwd */
package com.dajiang.app.base.po.dmo;

import java.util.Date;

/**
 * 用户表（包括大匠、知识经纪人） t_user
 *
 * @author zhouwd code generator
 */
public class User extends BaseDTO {
    private Long userId;

    /**
     * 角色：1：大匠;2:知识经纪人；3、普通用户；
     */
    private Byte userType;

    /**
     * 登录id
     */
    private Integer loginId;

    /**
     * 头像图片路径
     */
    private String userPhotoPath;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 联系邮箱
     */
    private String userEmail;

    /**
     * 手机号码
     */
    private String userPhone;

    /**
     * 用户设置账号的银行账号名称
     */
    private String userBankAccname;

    private String userBankname;

    /**
     * 用户设置的银行卡号码
     */
    private String userBankno;

    /**
     * 微信号码
     */
    private String userWeixin;

    /**
     * 用户创建时间
     */
    private Date userInsertdt;

    /**
     * 用户信息修改时间
     */
    private Date userUpdatedt;

    /**
     * 获取 t_user.user_id
     *
     * @return t_user.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 t_user.user_id
     *
     * @param userId t_user.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 角色：1：大匠;2:知识经纪人；3、普通用户； t_user.user_type
     *
     * @return 角色：1：大匠;2:知识经纪人；3、普通用户；
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * 设置 角色：1：大匠;2:知识经纪人；3、普通用户； t_user.user_type
     *
     * @param userType 角色：1：大匠;2:知识经纪人；3、普通用户；
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取 登录id t_user.login_id
     *
     * @return 登录id
     */
    public Integer getLoginId() {
        return loginId;
    }

    /**
     * 设置 登录id t_user.login_id
     *
     * @param loginId 登录id
     */
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    /**
     * 获取 头像图片路径 t_user.user_photo_path
     *
     * @return 头像图片路径
     */
    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    /**
     * 设置 头像图片路径 t_user.user_photo_path
     *
     * @param userPhotoPath 头像图片路径
     */
    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath == null ? null : userPhotoPath.trim();
    }

    /**
     * 获取 用户昵称 t_user.user_nickname
     *
     * @return 用户昵称
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 设置 用户昵称 t_user.user_nickname
     *
     * @param userNickname 用户昵称
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    /**
     * 获取 联系邮箱 t_user.user_email
     *
     * @return 联系邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置 联系邮箱 t_user.user_email
     *
     * @param userEmail 联系邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 获取 手机号码 t_user.user_phone
     *
     * @return 手机号码
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置 手机号码 t_user.user_phone
     *
     * @param userPhone 手机号码
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 获取 用户设置账号的银行账号名称 t_user.user_bank_accname
     *
     * @return 用户设置账号的银行账号名称
     */
    public String getUserBankAccname() {
        return userBankAccname;
    }

    /**
     * 设置 用户设置账号的银行账号名称 t_user.user_bank_accname
     *
     * @param userBankAccname 用户设置账号的银行账号名称
     */
    public void setUserBankAccname(String userBankAccname) {
        this.userBankAccname = userBankAccname == null ? null : userBankAccname.trim();
    }

    /**
     * 获取 t_user.user_bankname
     *
     * @return t_user.user_bankname
     */
    public String getUserBankname() {
        return userBankname;
    }

    /**
     * 设置 t_user.user_bankname
     *
     * @param userBankname t_user.user_bankname
     */
    public void setUserBankname(String userBankname) {
        this.userBankname = userBankname == null ? null : userBankname.trim();
    }

    /**
     * 获取 用户设置的银行卡号码 t_user.user_bankno
     *
     * @return 用户设置的银行卡号码
     */
    public String getUserBankno() {
        return userBankno;
    }

    /**
     * 设置 用户设置的银行卡号码 t_user.user_bankno
     *
     * @param userBankno 用户设置的银行卡号码
     */
    public void setUserBankno(String userBankno) {
        this.userBankno = userBankno == null ? null : userBankno.trim();
    }

    /**
     * 获取 微信号码 t_user.user_weixin
     *
     * @return 微信号码
     */
    public String getUserWeixin() {
        return userWeixin;
    }

    /**
     * 设置 微信号码 t_user.user_weixin
     *
     * @param userWeixin 微信号码
     */
    public void setUserWeixin(String userWeixin) {
        this.userWeixin = userWeixin == null ? null : userWeixin.trim();
    }

    /**
     * 获取 用户创建时间 t_user.user_insertDT
     *
     * @return 用户创建时间
     */
    public Date getUserInsertdt() {
        return userInsertdt;
    }

    /**
     * 设置 用户创建时间 t_user.user_insertDT
     *
     * @param userInsertdt 用户创建时间
     */
    public void setUserInsertdt(Date userInsertdt) {
        this.userInsertdt = userInsertdt;
    }

    /**
     * 获取 用户信息修改时间 t_user.user_updateDT
     *
     * @return 用户信息修改时间
     */
    public Date getUserUpdatedt() {
        return userUpdatedt;
    }

    /**
     * 设置 用户信息修改时间 t_user.user_updateDT
     *
     * @param userUpdatedt 用户信息修改时间
     */
    public void setUserUpdatedt(Date userUpdatedt) {
        this.userUpdatedt = userUpdatedt;
    }
}