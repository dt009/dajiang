/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * cko信息表 t_cko_apply
 *
 * @author zhouwd code generator
 */
public class CkoApply extends BaseDTO {
    private Integer ckoApplyId;

    private Long userId;

    private String ckoName;

    /**
     * 知识经济人昵称
     */
    private String ckoNickname;

    private String userPhotoPath;

    private Integer regionId;


    /**
     * 手机号码
     */
    private String ckoPhone;

    /**
     * 知识经济人电子邮箱
     */
    private String ckoApplyEmail;

    /**
     * 是否可查询：0：不可查询；1、可查询；
     */
    private Byte ckoIssearch;

    /**
     * 是否实名认证:0:不是；1：是；
     */
    private Byte ckoIscertification;

    /**
     * 身份证号码
     */
    private String ckoIdcard;

    /**
     * 身份证正面地址
     */
    private String ckoIdFront;

    /**
     * 身份证反面
     */
    private String ckoIdBack;

    private Date ckoApplyInsertdt = new Date();

    private Date ckoApplyUpdatedt = new Date();

    /**
     * 申请知识经济人状态：0：提交申请；1：审批通过；2：审批驳回；
     */
    private Byte ckoApplyStatus;

    /**
     * 获取 t_cko_apply.cko_apply_id
     *
     * @return t_cko_apply.cko_apply_id
     */
    public Integer getCkoApplyId() {
        return ckoApplyId;
    }

    /**
     * 设置 t_cko_apply.cko_apply_id
     *
     * @param ckoApplyId t_cko_apply.cko_apply_id
     */
    public void setCkoApplyId(Integer ckoApplyId) {
        this.ckoApplyId = ckoApplyId;
    }

    /**
     * 获取 t_cko_apply.user_id
     *
     * @return t_cko_apply.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 t_cko_apply.user_id
     *
     * @param userId t_cko_apply.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 t_cko_apply.cko_name
     *
     * @return t_cko_apply.cko_name
     */
    public String getCkoName() {
        return ckoName;
    }

    /**
     * 设置 t_cko_apply.cko_name
     *
     * @param ckoName t_cko_apply.cko_name
     */
    public void setCkoName(String ckoName) {
        this.ckoName = ckoName == null ? null : ckoName.trim();
    }

    /**
     * 获取 知识经济人昵称 t_cko_apply.cko_nickname
     *
     * @return 知识经济人昵称
     */
    public String getCkoNickname() {
        return ckoNickname;
    }

    /**
     * 设置 知识经济人昵称 t_cko_apply.cko_nickname
     *
     * @param ckoNickname 知识经济人昵称
     */
    public void setCkoNickname(String ckoNickname) {
        this.ckoNickname = ckoNickname == null ? null : ckoNickname.trim();
    }

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    /**
     * 获取 t_cko_apply.region_id
     *
     * @return t_cko_apply.region_id
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 设置 t_cko_apply.region_id
     *
     * @param regionId t_cko_apply.region_id
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取 手机号码 t_cko_apply.cko_phone
     *
     * @return 手机号码
     */
    public String getCkoPhone() {
        return ckoPhone;
    }

    /**
     * 设置 手机号码 t_cko_apply.cko_phone
     *
     * @param ckoPhone 手机号码
     */
    public void setCkoPhone(String ckoPhone) {
        this.ckoPhone = ckoPhone == null ? null : ckoPhone.trim();
    }

    /**
     * 获取 知识经济人电子邮箱 t_cko_apply.cko_apply_email
     *
     * @return 知识经济人电子邮箱
     */
    public String getCkoApplyEmail() {
        return ckoApplyEmail;
    }

    /**
     * 设置 知识经济人电子邮箱 t_cko_apply.cko_apply_email
     *
     * @param ckoApplyEmail 知识经济人电子邮箱
     */
    public void setCkoApplyEmail(String ckoApplyEmail) {
        this.ckoApplyEmail = ckoApplyEmail == null ? null : ckoApplyEmail.trim();
    }

    /**
     * 获取 是否可查询：0：不可查询；1、可查询； t_cko_apply.cko_issearch
     *
     * @return 是否可查询：0：不可查询；1、可查询；
     */
    public Byte getCkoIssearch() {
        return ckoIssearch;
    }

    /**
     * 设置 是否可查询：0：不可查询；1、可查询； t_cko_apply.cko_issearch
     *
     * @param ckoIssearch 是否可查询：0：不可查询；1、可查询；
     */
    public void setCkoIssearch(Byte ckoIssearch) {
        this.ckoIssearch = ckoIssearch;
    }

    /**
     * 获取 是否实名认证:0:不是；1：是； t_cko_apply.cko_iscertification
     *
     * @return 是否实名认证:0:不是；1：是；
     */
    public Byte getCkoIscertification() {
        return ckoIscertification;
    }

    /**
     * 设置 是否实名认证:0:不是；1：是； t_cko_apply.cko_iscertification
     *
     * @param ckoIscertification 是否实名认证:0:不是；1：是；
     */
    public void setCkoIscertification(Byte ckoIscertification) {
        this.ckoIscertification = ckoIscertification;
    }

    /**
     * 获取 身份证号码 t_cko_apply.cko_IDCard
     *
     * @return 身份证号码
     */
    public String getCkoIdcard() {
        return ckoIdcard;
    }

    /**
     * 设置 身份证号码 t_cko_apply.cko_IDCard
     *
     * @param ckoIdcard 身份证号码
     */
    public void setCkoIdcard(String ckoIdcard) {
        this.ckoIdcard = ckoIdcard == null ? null : ckoIdcard.trim();
    }

    /**
     * 获取 身份证正面地址 t_cko_apply.cko_ID_front
     *
     * @return 身份证正面地址
     */
    public String getCkoIdFront() {
        return ckoIdFront;
    }

    /**
     * 设置 身份证正面地址 t_cko_apply.cko_ID_front
     *
     * @param ckoIdFront 身份证正面地址
     */
    public void setCkoIdFront(String ckoIdFront) {
        this.ckoIdFront = ckoIdFront == null ? null : ckoIdFront.trim();
    }

    /**
     * 获取 身份证反面 t_cko_apply.cko_ID_back
     *
     * @return 身份证反面
     */
    public String getCkoIdBack() {
        return ckoIdBack;
    }

    /**
     * 设置 身份证反面 t_cko_apply.cko_ID_back
     *
     * @param ckoIdBack 身份证反面
     */
    public void setCkoIdBack(String ckoIdBack) {
        this.ckoIdBack = ckoIdBack == null ? null : ckoIdBack.trim();
    }

    /**
     * 获取 t_cko_apply.cko_apply_insertDT
     *
     * @return t_cko_apply.cko_apply_insertDT
     */
    public Date getCkoApplyInsertdt() {
        return ckoApplyInsertdt;
    }

    /**
     * 设置 t_cko_apply.cko_apply_insertDT
     *
     * @param ckoApplyInsertdt t_cko_apply.cko_apply_insertDT
     */
    public void setCkoApplyInsertdt(Date ckoApplyInsertdt) {
        this.ckoApplyInsertdt = ckoApplyInsertdt;
    }

    /**
     * 获取 t_cko_apply.cko_apply_updateDT
     *
     * @return t_cko_apply.cko_apply_updateDT
     */
    public Date getCkoApplyUpdatedt() {
        return ckoApplyUpdatedt;
    }

    /**
     * 设置 t_cko_apply.cko_apply_updateDT
     *
     * @param ckoApplyUpdatedt t_cko_apply.cko_apply_updateDT
     */
    public void setCkoApplyUpdatedt(Date ckoApplyUpdatedt) {
        this.ckoApplyUpdatedt = ckoApplyUpdatedt;
    }

    /**
     * 获取 申请知识经济人状态：0：提交申请；1：审批通过；2：审批驳回； t_cko_apply.cko_apply_status
     *
     * @return 申请知识经济人状态：0：提交申请；1：审批通过；2：审批驳回；
     */
    public Byte getCkoApplyStatus() {
        return ckoApplyStatus;
    }

    /**
     * 设置 申请知识经济人状态：0：提交申请；1：审批通过；2：审批驳回； t_cko_apply.cko_apply_status
     *
     * @param ckoApplyStatus 申请知识经济人状态：0：提交申请；1：审批通过；2：审批驳回；
     */
    public void setCkoApplyStatus(Byte ckoApplyStatus) {
        this.ckoApplyStatus = ckoApplyStatus;
    }
}