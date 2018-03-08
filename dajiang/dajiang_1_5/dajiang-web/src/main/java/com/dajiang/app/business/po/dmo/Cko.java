/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * cko信息表 t_cko
 *
 * @author zhouwd code generator
 */
public class Cko extends BaseDTO {

    private Integer ckoKey;

    private Long userId;

    private String ckoName;

    private String ckoNickname;

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

    private Date ckoInsertdt;

    private Date ckoUpdatedt;

    /**
     * 获取 t_cko.cko_key
     *
     * @return t_cko.cko_key
     */
    public Integer getCkoKey() {
        return ckoKey;
    }

    /**
     * 设置 t_cko.cko_key
     *
     * @param ckoKey t_cko.cko_key
     */
    public void setCkoKey(Integer ckoKey) {
        this.ckoKey = ckoKey;
    }

    /**
     * 获取 t_cko.user_id
     *
     * @return t_cko.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 t_cko.user_id
     *
     * @param userId t_cko.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 t_cko.cko_name
     *
     * @return t_cko.cko_name
     */
    public String getCkoName() {
        return ckoName;
    }

    /**
     * 设置 t_cko.cko_name
     *
     * @param ckoName t_cko.cko_name
     */
    public void setCkoName(String ckoName) {
        this.ckoName = ckoName == null ? null : ckoName.trim();
    }

    /**
     * 获取 t_cko.cko_nickname
     *
     * @return t_cko.cko_nickname
     */
    public String getCkoNickname() {
        return ckoNickname;
    }

    /**
     * 设置 t_cko.cko_nickname
     *
     * @param ckoNickname t_cko.cko_nickname
     */
    public void setCkoNickname(String ckoNickname) {
        this.ckoNickname = ckoNickname == null ? null : ckoNickname.trim();
    }

    /**
     * 获取 手机号码 t_cko.cko_phone
     *
     * @return 手机号码
     */
    public String getCkoPhone() {
        return ckoPhone;
    }

    /**
     * 设置 手机号码 t_cko.cko_phone
     *
     * @param ckoPhone 手机号码
     */
    public void setCkoPhone(String ckoPhone) {
        this.ckoPhone = ckoPhone == null ? null : ckoPhone.trim();
    }

    /**
     * 获取 知识经济人电子邮箱 t_cko.cko_email
     *
     * @return 知识经济人电子邮箱
     */
    public String getCkoEmail() {
        return ckoEmail;
    }

    /**
     * 设置 知识经济人电子邮箱 t_cko.cko_email
     *
     * @param ckoEmail 知识经济人电子邮箱
     */
    public void setCkoEmail(String ckoEmail) {
        this.ckoEmail = ckoEmail == null ? null : ckoEmail.trim();
    }

    /**
     * 获取 t_cko.region_id
     *
     * @return t_cko.region_id
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 设置 t_cko.region_id
     *
     * @param regionId t_cko.region_id
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * 获取 是否可查询：0：不可查询；1、可查询； t_cko.cko_issearch
     *
     * @return 是否可查询：0：不可查询；1、可查询；
     */
    public Byte getCkoIssearch() {
        return ckoIssearch;
    }

    /**
     * 设置 是否可查询：0：不可查询；1、可查询； t_cko.cko_issearch
     *
     * @param ckoIssearch 是否可查询：0：不可查询；1、可查询；
     */
    public void setCkoIssearch(Byte ckoIssearch) {
        this.ckoIssearch = ckoIssearch;
    }

    /**
     * 获取 是否实名认证:0:不是；1：是； t_cko.cko_iscertification
     *
     * @return 是否实名认证:0:不是；1：是；
     */
    public Byte getCkoIscertification() {
        return ckoIscertification;
    }

    /**
     * 设置 是否实名认证:0:不是；1：是； t_cko.cko_iscertification
     *
     * @param ckoIscertification 是否实名认证:0:不是；1：是；
     */
    public void setCkoIscertification(Byte ckoIscertification) {
        this.ckoIscertification = ckoIscertification;
    }

    /**
     * 获取 身份证号码 t_cko.cko_IDCard
     *
     * @return 身份证号码
     */
    public String getCkoIdcard() {
        return ckoIdcard;
    }

    /**
     * 设置 身份证号码 t_cko.cko_IDCard
     *
     * @param ckoIdcard 身份证号码
     */
    public void setCkoIdcard(String ckoIdcard) {
        this.ckoIdcard = ckoIdcard == null ? null : ckoIdcard.trim();
    }

    /**
     * 获取 身份证正面地址 t_cko.cko_ID_front
     *
     * @return 身份证正面地址
     */
    public String getCkoIdFront() {
        return ckoIdFront;
    }

    /**
     * 设置 身份证正面地址 t_cko.cko_ID_front
     *
     * @param ckoIdFront 身份证正面地址
     */
    public void setCkoIdFront(String ckoIdFront) {
        this.ckoIdFront = ckoIdFront == null ? null : ckoIdFront.trim();
    }

    /**
     * 获取 身份证反面 t_cko.cko_ID_back
     *
     * @return 身份证反面
     */
    public String getCkoIdBack() {
        return ckoIdBack;
    }

    /**
     * 设置 身份证反面 t_cko.cko_ID_back
     *
     * @param ckoIdBack 身份证反面
     */
    public void setCkoIdBack(String ckoIdBack) {
        this.ckoIdBack = ckoIdBack == null ? null : ckoIdBack.trim();
    }

    /**
     * 获取 t_cko.cko_insertDT
     *
     * @return t_cko.cko_insertDT
     */
    public Date getCkoInsertdt() {
        return ckoInsertdt;
    }

    /**
     * 设置 t_cko.cko_insertDT
     *
     * @param ckoInsertdt t_cko.cko_insertDT
     */
    public void setCkoInsertdt(Date ckoInsertdt) {
        this.ckoInsertdt = ckoInsertdt;
    }

    /**
     * 获取 t_cko.cko_updateDT
     *
     * @return t_cko.cko_updateDT
     */
    public Date getCkoUpdatedt() {
        return ckoUpdatedt;
    }

    /**
     * 设置 t_cko.cko_updateDT
     *
     * @param ckoUpdatedt t_cko.cko_updateDT
     */
    public void setCkoUpdatedt(Date ckoUpdatedt) {
        this.ckoUpdatedt = ckoUpdatedt;
    }
}