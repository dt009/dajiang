package com.dajiang.app.business.po.resp;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

public class CollectionRespDTO extends BaseDTO {

    private Integer collectionId;
    private Long userId;
    private Integer professionalId;
    private String professionalName;
    private String professionalPosition;
    private String userPhotoPath;
    private String professionalIntroduction;
    private Date collectionInsertdt;


    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
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

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    public String getProfessionalIntroduction() {
        return professionalIntroduction;
    }

    public void setProfessionalIntroduction(String professionalIntroduction) {
        this.professionalIntroduction = professionalIntroduction;
    }

    public Date getCollectionInsertdt() {
        return collectionInsertdt;
    }

    public void setCollectionInsertdt(Date collectionInsertdt) {
        this.collectionInsertdt = collectionInsertdt;
    }
}
