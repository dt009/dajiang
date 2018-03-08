package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * Created by Joe on 2017/9/21.
 */
public class PasswordEditReqDTO extends BaseDTO {

    /**
     * 用户主键
     */
    private Long userID;
    /**
     * 旧密码
     */
    private String oldPassword;
    /**
     * 密码
     */
    private String newPassword;
    /**
     * 确认密码
     */
    private String confirmPWD;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPWD() {
        return confirmPWD;
    }

    public void setConfirmPWD(String confirmPWD) {
        this.confirmPWD = confirmPWD;
    }
}
