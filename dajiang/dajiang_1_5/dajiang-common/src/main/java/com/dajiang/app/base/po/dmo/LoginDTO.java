/* github.com/zhouwd */
package com.dajiang.app.base.po.dmo;

import java.util.Date;

/**
 * 登录信息表 t_login
 *
 * @author zhouwd code generator
 */
public class LoginDTO extends BaseDTO {
    private Integer loginId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPasswd;

    /**
     * 登录错误允许次数
     */
    private Integer loginErrornum;

    private Date loginInsertdt;

    /**
     * 最后一次登录的时间
     */
    private Date loginLastdt;

    /**
     * 获取 t_login.login_id
     *
     * @return t_login.login_id
     */
    public Integer getLoginId() {
        return loginId;
    }

    /**
     * 设置 t_login.login_id
     *
     * @param loginId t_login.login_id
     */
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    /**
     * 获取 登录名 t_login.login_name
     *
     * @return 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置 登录名 t_login.login_name
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取 登录密码 t_login.login_passwd
     *
     * @return 登录密码
     */
    public String getLoginPasswd() {
        return loginPasswd;
    }

    /**
     * 设置 登录密码 t_login.login_passwd
     *
     * @param loginPasswd 登录密码
     */
    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd == null ? null : loginPasswd.trim();
    }

    /**
     * 获取 登录错误允许次数 t_login.login_errornum
     *
     * @return 登录错误允许次数
     */
    public Integer getLoginErrornum() {
        return loginErrornum;
    }

    /**
     * 设置 登录错误允许次数 t_login.login_errornum
     *
     * @param loginErrornum 登录错误允许次数
     */
    public void setLoginErrornum(Integer loginErrornum) {
        this.loginErrornum = loginErrornum;
    }

    /**
     * 获取 t_login.login_insertDT
     *
     * @return t_login.login_insertDT
     */
    public Date getLoginInsertdt() {
        return loginInsertdt;
    }

    /**
     * 设置 t_login.login_insertDT
     *
     * @param loginInsertdt t_login.login_insertDT
     */
    public void setLoginInsertdt(Date loginInsertdt) {
        this.loginInsertdt = loginInsertdt;
    }

    /**
     * 获取 最后一次登录的时间 t_login.login_lastDT
     *
     * @return 最后一次登录的时间
     */
    public Date getLoginLastdt() {
        return loginLastdt;
    }

    /**
     * 设置 最后一次登录的时间 t_login.login_lastDT
     *
     * @param loginLastdt 最后一次登录的时间
     */
    public void setLoginLastdt(Date loginLastdt) {
        this.loginLastdt = loginLastdt;
    }
}