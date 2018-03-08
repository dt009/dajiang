package com.dajiang.app.base.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * Created by Joe on 2017/9/21.
 */
public class UserRespDTO extends BaseDTO {

    private Long userId;

    /**
     * 角色：1：大匠;2:知识经纪人；3、普通用户；
     */
    private Integer userType;

    /**
     * 登录id
     */
    private Long loginId;

    /**
     * 手机号码
     */
    private String userPhone;


    /**
     * 联系邮箱
     */
    private String userEmail;

    /**
     * 头像图片路径
     */
    private String userPhotoPath;


    /**
     * 用户创建时间
     */
    private Date userInsertdt;

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
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置 角色：1：大匠;2:知识经纪人；3、普通用户； t_user.user_type
     *
     * @param userType 角色：1：大匠;2:知识经纪人；3、普通用户；
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取 登录id t_user.login_id
     *
     * @return 登录id
     */
    public Long getLoginId() {
        return loginId;
    }

    /**
     * 设置 登录id t_user.login_id
     *
     * @param loginId 登录id
     */
    public void setLoginId(Long loginId) {
        this.loginId = loginId;
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

}
