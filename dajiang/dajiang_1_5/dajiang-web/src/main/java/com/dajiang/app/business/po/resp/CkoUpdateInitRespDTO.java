package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class CkoUpdateInitRespDTO extends BaseDTO {

    private String ckoNickname;

    /**
     * 手机号码
     */
    private String ckoPhone;

    /**
     * 知识经济人电子邮箱
     */
    private String ckoEmail;

    /**
     * 是否可查询：0：不可查询；1、可查询；
     */
    private Byte ckoIssearch;

    /**
     * 是否实名认证:0:不是；1：是；
     */
    private Byte ckoIscertification;

    /**
     * 头像
     */
    private String userPhotoPath;

    private Integer regionId;

    private String regionName;


    public String getCkoNickname() {
        return ckoNickname;
    }

    public void setCkoNickname(String ckoNickname) {
        this.ckoNickname = ckoNickname;
    }

    public String getCkoPhone() {
        return ckoPhone;
    }

    public void setCkoPhone(String ckoPhone) {
        this.ckoPhone = ckoPhone;
    }

    public String getCkoEmail() {
        return ckoEmail;
    }

    public void setCkoEmail(String ckoEmail) {
        this.ckoEmail = ckoEmail;
    }

    public Byte getCkoIssearch() {
        return ckoIssearch;
    }

    public void setCkoIssearch(Byte ckoIssearch) {
        this.ckoIssearch = ckoIssearch;
    }

    public Byte getCkoIscertification() {
        return ckoIscertification;
    }

    public void setCkoIscertification(Byte ckoIscertification) {
        this.ckoIscertification = ckoIscertification;
    }

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
