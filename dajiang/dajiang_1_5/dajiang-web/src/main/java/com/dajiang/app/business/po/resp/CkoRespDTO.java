package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

public class CkoRespDTO extends BaseDTO {

    private String ckoKey;

    private String ckoName;

    private String ckoNickname;

    /**
     * 头像地址
     */
    private String userPhotoPath;

    private Long userId;

    /**
     * 手机号码
     */
    private String ckoPhone;

    /**
     * 知识经济人电子邮箱
     */
    private String ckoEmail;

    private Integer regionId;

    private String regionName;

    public String getCkoKey() {
        return ckoKey;
    }

    public void setCkoKey(String ckoKey) {
        this.ckoKey = ckoKey;
    }

    public String getCkoName() {
        return ckoName;
    }

    public void setCkoName(String ckoName) {
        this.ckoName = ckoName;
    }

    public String getCkoNickname() {
        return ckoNickname;
    }

    public void setCkoNickname(String ckoNickname) {
        this.ckoNickname = ckoNickname;
    }

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
