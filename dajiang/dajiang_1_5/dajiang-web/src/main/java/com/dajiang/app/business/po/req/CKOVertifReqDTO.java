package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * Created by Joe on 2017/9/22.
 */
public class CKOVertifReqDTO extends BaseDTO {

    private Integer ckoApplyId;

    private Long userId;

    private String ckoName;

    private String ckoNickname;

    private Integer regionId;

    /**
     * 是否可查询：0：不可查询；1、可查询；
     */
    private Integer ckoIsSearch;

    /**
     * 是否实名认证:0:不是；1：是；
     */
    private Integer ckoIsCertification;

    /**
     * 身份证正面地址
     */
    private String ckoIdFront;

    /**
     * 身份证反面
     */
    private String ckoIdBack;

    /**
     * 手机号码
     */
    private String ckoPhone;

    private Date ckoApplyInsertdt;

    private Date ckoApplyUpdatedt;

    /**
     * 申请知识经济人状态：0：提交申请；1：审批通过；2：审批驳回；
     */
    private Byte ckoApplyStatus;

    /**
     * 身份证号码
     */
    private String ckoIdCard;

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
     * 获取 t_cko_apply.cko_nickname
     *
     * @return t_cko_apply.cko_nickname
     */
    public String getCkoNickname() {
        return ckoNickname;
    }

    /**
     * 设置 t_cko_apply.cko_nickname
     *
     * @param ckoNickname t_cko_apply.cko_nickname
     */
    public void setCkoNickname(String ckoNickname) {
        this.ckoNickname = ckoNickname == null ? null : ckoNickname.trim();
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

    public Integer getCkoIsCertification() {
        return ckoIsCertification;
    }

    public void setCkoIsCertification(Integer ckoIsCertification) {
        this.ckoIsCertification = ckoIsCertification;
    }

    public Integer getCkoIsSearch() {
        return ckoIsSearch;
    }

    public void setCkoIsSearch(Integer ckoIsSearch) {
        this.ckoIsSearch = ckoIsSearch;
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

    public String getCkoIdCard() {
        return ckoIdCard;
    }

    public void setCkoIdCard(String ckoIdCard) {
        this.ckoIdCard = ckoIdCard;
    }
}
