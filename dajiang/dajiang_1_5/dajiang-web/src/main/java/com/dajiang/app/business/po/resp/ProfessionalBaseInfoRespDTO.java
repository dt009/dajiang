package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

public class ProfessionalBaseInfoRespDTO extends BaseDTO {


    private Integer professionalId;

    /**
     * 大匠的用户id
     */
    private Long userId;

    /**
     * 头像地址
     */
    private String userPhotoPath;

    /**
     * 大匠姓名
     */
    private String professionalName;

    /**
     * 区域
     */
    private String regionStr;

    /**
     * 职位
     */
    private String professionalPosition;

    /**
     * 任职机构
     */
    private String professionalWorkunit;
    /**
     * 自我介绍
     */
    private String professionalIndroduction;

    /**
     * 关注人数
     */
    private Integer collectionNum;

    /**
     * 创建时间
     */
    private Date professionalInsertdt;

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public String getProfessionalPosition() {
        return professionalPosition;
    }

    public void setProfessionalPosition(String professionalPosition) {
        this.professionalPosition = professionalPosition;
    }

    /**
     * 获取 任职机构 t_professional_apply.professional_workunit
     *
     * @return 任职机构
     */
    public String getProfessionalWorkunit() {
        return professionalWorkunit;
    }

    /**
     * 设置 任职机构 t_professional_apply.professional_workunit
     *
     * @param professionalWorkunit 任职机构
     */
    public void setProfessionalWorkunit(String professionalWorkunit) {
        this.professionalWorkunit = professionalWorkunit == null ? null : professionalWorkunit.trim();
    }


    public String getRegionStr() {
        return regionStr;
    }

    public void setRegionStr(String regionStr) {
        this.regionStr = regionStr;
    }

    public String getProfessionalIndroduction() {
        return professionalIndroduction;
    }

    public void setProfessionalIndroduction(String professionalIndroduction) {
        this.professionalIndroduction = professionalIndroduction;
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Date getProfessionalInsertdt() {
        return professionalInsertdt;
    }

    public void setProfessionalInsertdt(Date professionalInsertdt) {
        this.professionalInsertdt = professionalInsertdt;
    }
}
