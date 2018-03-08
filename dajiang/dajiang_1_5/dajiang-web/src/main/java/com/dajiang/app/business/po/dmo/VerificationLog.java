/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * @author zhouwd code generator
 */
public class VerificationLog extends BaseDTO {


    public static final String USE_REGISTER = "USE_REGISTER";
    public static final String USE_RESETPWD = "USE_RESETPWD";


    private Integer id;

    private String userPhone;

    private String useType;

    private String verificationCode;

    private Date firstTime;

    private Date lastTime;

    private Integer sendTimes;

    /**
     * 获取 t_verification_log.id
     *
     * @return t_verification_log.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 t_verification_log.id
     *
     * @param id t_verification_log.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 t_verification_log.user_phone
     *
     * @return t_verification_log.user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置 t_verification_log.user_phone
     *
     * @param userPhone t_verification_log.user_phone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    /**
     * 获取 t_verification_log.verification_code
     *
     * @return t_verification_log.verification_code
     */
    public String getVerificationCode() {
        return verificationCode;
    }

    /**
     * 设置 t_verification_log.verification_code
     *
     * @param verificationCode t_verification_log.verification_code
     */
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode == null ? null : verificationCode.trim();
    }

    /**
     * 获取 t_verification_log.first_time
     *
     * @return t_verification_log.first_time
     */
    public Date getFirstTime() {
        return firstTime;
    }

    /**
     * 设置 t_verification_log.first_time
     *
     * @param firstTime t_verification_log.first_time
     */
    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    /**
     * 获取 t_verification_log.last_time
     *
     * @return t_verification_log.last_time
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 设置 t_verification_log.last_time
     *
     * @param lastTime t_verification_log.last_time
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取 t_verification_log.send_times
     *
     * @return t_verification_log.send_times
     */
    public Integer getSendTimes() {
        return sendTimes;
    }

    /**
     * 设置 t_verification_log.send_times
     *
     * @param sendTimes t_verification_log.send_times
     */
    public void setSendTimes(Integer sendTimes) {
        this.sendTimes = sendTimes;
    }
}