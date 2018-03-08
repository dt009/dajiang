package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;
import java.util.List;

public class ProfessionalReqDTO extends BaseDTO {

    private Integer professionalId;

    /**
     * 大匠的用户id
     */
    private Long userId;

    /**
     * 大匠姓名
     */
    private String professionalName;

    /**
     * 大匠专业id
     */
    private Integer professionalTypeId;

    /**
     * 大匠常驻地区id
     */
    private Integer regionId;

    /**
     * 任职机构
     */
    private String professionalWorkunit;

    /**
     * 从业时间
     */
    private Date professionalWorkdt;

    /**
     * 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他；
     */
    private Byte professionalHighEduc;

    /**
     * 职位
     */
    private String professionalPosition;

    /**
     * 大匠背景照片路径
     */
    private String professionalPhotoPath;

    /**
     * 身份证正面
     */
    private String professionalIdFront;

    /**
     * 身份证反面
     */
    private String professionalIdBack;

    /**
     * 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级
     */
    private Byte professionalLevel;

    /**
     * 性别：1：男；2：女；
     */
    private Byte professionalGender;

    /**
     * 电子邮箱
     */
    private String professionalEmail;

    /**
     * 手机号码
     */
    private String professionalPhone;

    /**
     * 生日
     */
    private Date professionalBirth;

    /**
     * 专业领域
     */
    private String professionalField;

    /**
     * 身份证号码
     */
    private String professionalIdcard;

    /**
     * 自我介绍
     */
    private String professionalIntroduction;

    /**
     * 职业资格证书路径
     */
    private List<String> qualificationPicList;

    /**
     * 获奖证书
     */
    private List<String> certificatePicList;

    /**
     * 其他图片
     */
    private List<String> otherPicList;

    /**
     * 创建时间
     */
    private Date professionalApplyInsertdt;

    /**
     * 申请大匠状态：0：提交申请；1：审核通过；2：审核驳回；
     */
    private Byte professionalApplyStatus;

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * 获取 大匠的用户id t_professional_apply.user_id
     *
     * @return 大匠的用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 大匠的用户id t_professional_apply.user_id
     *
     * @param userId 大匠的用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 大匠姓名 t_professional_apply.professional_name
     *
     * @return 大匠姓名
     */
    public String getProfessionalName() {
        return professionalName;
    }

    /**
     * 设置 大匠姓名 t_professional_apply.professional_name
     *
     * @param professionalName 大匠姓名
     */
    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName == null ? null : professionalName.trim();
    }

    /**
     * 获取 大匠专业id t_professional_apply.professional_type_id
     *
     * @return 大匠专业id
     */
    public Integer getProfessionalTypeId() {
        return professionalTypeId;
    }

    /**
     * 设置 大匠专业id t_professional_apply.professional_type_id
     *
     * @param professionalTypeId 大匠专业id
     */
    public void setProfessionalTypeId(Integer professionalTypeId) {
        this.professionalTypeId = professionalTypeId;
    }

    /**
     * 获取 大匠常驻地区id t_professional_apply.region_id
     *
     * @return 大匠常驻地区id
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 设置 大匠常驻地区id t_professional_apply.region_id
     *
     * @param regionId 大匠常驻地区id
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
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

    /**
     * 获取 从业时间 t_professional_apply.professional_workDT
     *
     * @return 从业时间
     */
    public Date getProfessionalWorkdt() {
        return professionalWorkdt;
    }

    /**
     * 设置 从业时间 t_professional_apply.professional_workDT
     *
     * @param professionalWorkdt 从业时间
     */
    public void setProfessionalWorkdt(Date professionalWorkdt) {
        this.professionalWorkdt = professionalWorkdt;
    }

    /**
     * 获取 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他； t_professional_apply.professional_high_educ
     *
     * @return 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他；
     */
    public Byte getProfessionalHighEduc() {
        return professionalHighEduc;
    }

    /**
     * 设置 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他； t_professional_apply.professional_high_educ
     *
     * @param professionalHighEduc 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他；
     */
    public void setProfessionalHighEduc(Byte professionalHighEduc) {
        this.professionalHighEduc = professionalHighEduc;
    }

    /**
     * 获取 职位 t_professional_apply.professional_position
     *
     * @return 职位
     */
    public String getProfessionalPosition() {
        return professionalPosition;
    }

    /**
     * 设置 职位 t_professional_apply.professional_position
     *
     * @param professionalPosition 职位
     */
    public void setProfessionalPosition(String professionalPosition) {
        this.professionalPosition = professionalPosition == null ? null : professionalPosition.trim();
    }

    /**
     * 获取 大匠背景照片路径 t_professional_apply.professional_photo_path
     *
     * @return 大匠背景照片路径
     */
    public String getProfessionalPhotoPath() {
        return professionalPhotoPath;
    }

    /**
     * 设置 大匠背景照片路径 t_professional_apply.professional_photo_path
     *
     * @param professionalPhotoPath 大匠背景照片路径
     */
    public void setProfessionalPhotoPath(String professionalPhotoPath) {
        this.professionalPhotoPath = professionalPhotoPath == null ? null : professionalPhotoPath.trim();
    }

    /**
     * 获取 身份证正面 t_professional_apply.professional_ID_front
     *
     * @return 身份证正面
     */
    public String getProfessionalIdFront() {
        return professionalIdFront;
    }

    /**
     * 设置 身份证正面 t_professional_apply.professional_ID_front
     *
     * @param professionalIdFront 身份证正面
     */
    public void setProfessionalIdFront(String professionalIdFront) {
        this.professionalIdFront = professionalIdFront == null ? null : professionalIdFront.trim();
    }

    /**
     * 获取 身份证反面 t_professional_apply.professional_ID_back
     *
     * @return 身份证反面
     */
    public String getProfessionalIdBack() {
        return professionalIdBack;
    }

    /**
     * 设置 身份证反面 t_professional_apply.professional_ID_back
     *
     * @param professionalIdBack 身份证反面
     */
    public void setProfessionalIdBack(String professionalIdBack) {
        this.professionalIdBack = professionalIdBack == null ? null : professionalIdBack.trim();
    }

    /**
     * 获取 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级 t_professional_apply.professional_level
     *
     * @return 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级
     */
    public Byte getProfessionalLevel() {
        return professionalLevel;
    }

    /**
     * 设置 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级 t_professional_apply.professional_level
     *
     * @param professionalLevel 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级
     */
    public void setProfessionalLevel(Byte professionalLevel) {
        this.professionalLevel = professionalLevel;
    }

    /**
     * 获取 性别：1：男；2：女； t_professional_apply.professional_gender
     *
     * @return 性别：1：男；2：女；
     */
    public Byte getProfessionalGender() {
        return professionalGender;
    }

    /**
     * 设置 性别：1：男；2：女； t_professional_apply.professional_gender
     *
     * @param professionalGender 性别：1：男；2：女；
     */
    public void setProfessionalGender(Byte professionalGender) {
        this.professionalGender = professionalGender;
    }

    /**
     * 获取 电子邮箱 t_professional_apply.professional_email
     *
     * @return 电子邮箱
     */
    public String getProfessionalEmail() {
        return professionalEmail;
    }

    /**
     * 设置 电子邮箱 t_professional_apply.professional_email
     *
     * @param professionalEmail 电子邮箱
     */
    public void setProfessionalEmail(String professionalEmail) {
        this.professionalEmail = professionalEmail == null ? null : professionalEmail.trim();
    }

    /**
     * 获取 手机号码 t_professional_apply.professional_phone
     *
     * @return 手机号码
     */
    public String getProfessionalPhone() {
        return professionalPhone;
    }

    /**
     * 设置 手机号码 t_professional_apply.professional_phone
     *
     * @param professionalPhone 手机号码
     */
    public void setProfessionalPhone(String professionalPhone) {
        this.professionalPhone = professionalPhone == null ? null : professionalPhone.trim();
    }

    /**
     * 获取 生日 t_professional_apply.professional_birth
     *
     * @return 生日
     */
    public Date getProfessionalBirth() {
        return professionalBirth;
    }

    /**
     * 设置 生日 t_professional_apply.professional_birth
     *
     * @param professionalBirth 生日
     */
    public void setProfessionalBirth(Date professionalBirth) {
        this.professionalBirth = professionalBirth;
    }

    /**
     * 获取 专业领域 t_professional_apply.professional_field
     *
     * @return 专业领域
     */
    public String getProfessionalField() {
        return professionalField;
    }

    /**
     * 设置 专业领域 t_professional_apply.professional_field
     *
     * @param professionalField 专业领域
     */
    public void setProfessionalField(String professionalField) {
        this.professionalField = professionalField == null ? null : professionalField.trim();
    }

    /**
     * 获取 身份证号码 t_professional_apply.professional_IDCard
     *
     * @return 身份证号码
     */
    public String getProfessionalIdcard() {
        return professionalIdcard;
    }

    /**
     * 设置 身份证号码 t_professional_apply.professional_IDCard
     *
     * @param professionalIdcard 身份证号码
     */
    public void setProfessionalIdcard(String professionalIdcard) {
        this.professionalIdcard = professionalIdcard == null ? null : professionalIdcard.trim();
    }

    public String getProfessionalIntroduction() {
        return professionalIntroduction;
    }

    public void setProfessionalIntroduction(String professionalIntroduction) {
        this.professionalIntroduction = professionalIntroduction;
    }

    public List<String> getQualificationPicList() {
        return qualificationPicList;
    }

    public void setQualificationPicList(List<String> qualificationPicList) {
        this.qualificationPicList = qualificationPicList;
    }

    public List<String> getCertificatePicList() {
        return certificatePicList;
    }

    public void setCertificatePicList(List<String> certificatePicList) {
        this.certificatePicList = certificatePicList;
    }

    public List<String> getOtherPicList() {
        return otherPicList;
    }

    public void setOtherPicList(List<String> otherPicList) {
        this.otherPicList = otherPicList;
    }

    /**
     * 获取 创建时间 t_professional_apply.professional_apply_insertDT
     *
     * @return 创建时间
     */
    public Date getProfessionalApplyInsertdt() {
        return professionalApplyInsertdt;
    }

    /**
     * 设置 创建时间 t_professional_apply.professional_apply_insertDT
     *
     * @param professionalApplyInsertdt 创建时间
     */
    public void setProfessionalApplyInsertdt(Date professionalApplyInsertdt) {
        this.professionalApplyInsertdt = professionalApplyInsertdt;
    }

    /**
     * 获取 申请大匠状态：0：提交申请；1：审核通过；2：审核驳回； t_professional_apply.professional_apply_status
     *
     * @return 申请大匠状态：0：提交申请；1：审核通过；2：审核驳回；
     */
    public Byte getProfessionalApplyStatus() {
        return professionalApplyStatus;
    }

    /**
     * 设置 申请大匠状态：0：提交申请；1：审核通过；2：审核驳回； t_professional_apply.professional_apply_status
     *
     * @param professionalApplyStatus 申请大匠状态：0：提交申请；1：审核通过；2：审核驳回；
     */
    public void setProfessionalApplyStatus(Byte professionalApplyStatus) {
        this.professionalApplyStatus = professionalApplyStatus;
    }


}
