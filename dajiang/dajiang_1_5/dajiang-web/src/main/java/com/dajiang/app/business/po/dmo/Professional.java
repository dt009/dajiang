/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 大匠的信息 t_professional
 *
 * @author zhouwd code generator
 */
public class Professional extends BaseDTO {

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
    private String professionalIndroduction;

    /**
     * 创建时间
     */
    private Date professionalInsertdt;

    /**
     * 获取 t_professional.professional_id
     *
     * @return t_professional.professional_id
     */
    public Integer getProfessionalId() {
        return professionalId;
    }

    /**
     * 设置 t_professional.professional_id
     *
     * @param professionalId t_professional.professional_id
     */
    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * 获取 大匠的用户id t_professional.user_id
     *
     * @return 大匠的用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 大匠的用户id t_professional.user_id
     *
     * @param userId 大匠的用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 大匠姓名 t_professional.professional_name
     *
     * @return 大匠姓名
     */
    public String getProfessionalName() {
        return professionalName;
    }

    /**
     * 设置 大匠姓名 t_professional.professional_name
     *
     * @param professionalName 大匠姓名
     */
    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName == null ? null : professionalName.trim();
    }

    /**
     * 获取 大匠专业id t_professional.professional_type_id
     *
     * @return 大匠专业id
     */
    public Integer getProfessionalTypeId() {
        return professionalTypeId;
    }

    /**
     * 设置 大匠专业id t_professional.professional_type_id
     *
     * @param professionalTypeId 大匠专业id
     */
    public void setProfessionalTypeId(Integer professionalTypeId) {
        this.professionalTypeId = professionalTypeId;
    }

    /**
     * 获取 大匠常驻地区id t_professional.region_id
     *
     * @return 大匠常驻地区id
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 设置 大匠常驻地区id t_professional.region_id
     *
     * @param regionId 大匠常驻地区id
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取 任职机构 t_professional.professional_workunit
     *
     * @return 任职机构
     */
    public String getProfessionalWorkunit() {
        return professionalWorkunit;
    }

    /**
     * 设置 任职机构 t_professional.professional_workunit
     *
     * @param professionalWorkunit 任职机构
     */
    public void setProfessionalWorkunit(String professionalWorkunit) {
        this.professionalWorkunit = professionalWorkunit == null ? null : professionalWorkunit.trim();
    }

    /**
     * 获取 从业时间 t_professional.professional_workDT
     *
     * @return 从业时间
     */
    public Date getProfessionalWorkdt() {
        return professionalWorkdt;
    }

    /**
     * 设置 从业时间 t_professional.professional_workDT
     *
     * @param professionalWorkdt 从业时间
     */
    public void setProfessionalWorkdt(Date professionalWorkdt) {
        this.professionalWorkdt = professionalWorkdt;
    }

    /**
     * 获取 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他； t_professional.professional_high_educ
     *
     * @return 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他；
     */
    public Byte getProfessionalHighEduc() {
        return professionalHighEduc;
    }

    /**
     * 设置 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他； t_professional.professional_high_educ
     *
     * @param professionalHighEduc 最高学历:1、小学；2：初中；3、高中；4：大专；5：本科；6：研究生；7、博士研究生；8：其他；
     */
    public void setProfessionalHighEduc(Byte professionalHighEduc) {
        this.professionalHighEduc = professionalHighEduc;
    }

    /**
     * 获取 职位 t_professional.professional_position
     *
     * @return 职位
     */
    public String getProfessionalPosition() {
        return professionalPosition;
    }

    /**
     * 设置 职位 t_professional.professional_position
     *
     * @param professionalPosition 职位
     */
    public void setProfessionalPosition(String professionalPosition) {
        this.professionalPosition = professionalPosition == null ? null : professionalPosition.trim();
    }

    /**
     * 获取 大匠背景照片路径 t_professional.professional_photo_path
     *
     * @return 大匠背景照片路径
     */
    public String getProfessionalPhotoPath() {
        return professionalPhotoPath;
    }

    /**
     * 设置 大匠背景照片路径 t_professional.professional_photo_path
     *
     * @param professionalPhotoPath 大匠背景照片路径
     */
    public void setProfessionalPhotoPath(String professionalPhotoPath) {
        this.professionalPhotoPath = professionalPhotoPath == null ? null : professionalPhotoPath.trim();
    }

    /**
     * 获取 身份证正面 t_professional.professional_ID_front
     *
     * @return 身份证正面
     */
    public String getProfessionalIdFront() {
        return professionalIdFront;
    }

    /**
     * 设置 身份证正面 t_professional.professional_ID_front
     *
     * @param professionalIdFront 身份证正面
     */
    public void setProfessionalIdFront(String professionalIdFront) {
        this.professionalIdFront = professionalIdFront == null ? null : professionalIdFront.trim();
    }

    /**
     * 获取 身份证反面 t_professional.professional_ID_back
     *
     * @return 身份证反面
     */
    public String getProfessionalIdBack() {
        return professionalIdBack;
    }

    /**
     * 设置 身份证反面 t_professional.professional_ID_back
     *
     * @param professionalIdBack 身份证反面
     */
    public void setProfessionalIdBack(String professionalIdBack) {
        this.professionalIdBack = professionalIdBack == null ? null : professionalIdBack.trim();
    }

    /**
     * 获取 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级 t_professional.professional_level
     *
     * @return 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级
     */
    public Byte getProfessionalLevel() {
        return professionalLevel;
    }

    /**
     * 设置 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级 t_professional.professional_level
     *
     * @param professionalLevel 大匠级别：1：一级；2：二级；3：三级；4：四级；5：五级
     */
    public void setProfessionalLevel(Byte professionalLevel) {
        this.professionalLevel = professionalLevel;
    }

    /**
     * 获取 性别：1：男；2：女； t_professional.professional_gender
     *
     * @return 性别：1：男；2：女；
     */
    public Byte getProfessionalGender() {
        return professionalGender;
    }

    /**
     * 设置 性别：1：男；2：女； t_professional.professional_gender
     *
     * @param professionalGender 性别：1：男；2：女；
     */
    public void setProfessionalGender(Byte professionalGender) {
        this.professionalGender = professionalGender;
    }

    /**
     * 获取 电子邮箱 t_professional.professional_email
     *
     * @return 电子邮箱
     */
    public String getProfessionalEmail() {
        return professionalEmail;
    }

    /**
     * 设置 电子邮箱 t_professional.professional_email
     *
     * @param professionalEmail 电子邮箱
     */
    public void setProfessionalEmail(String professionalEmail) {
        this.professionalEmail = professionalEmail == null ? null : professionalEmail.trim();
    }

    /**
     * 获取 手机号码 t_professional.professional_phone
     *
     * @return 手机号码
     */
    public String getProfessionalPhone() {
        return professionalPhone;
    }

    /**
     * 设置 手机号码 t_professional.professional_phone
     *
     * @param professionalPhone 手机号码
     */
    public void setProfessionalPhone(String professionalPhone) {
        this.professionalPhone = professionalPhone == null ? null : professionalPhone.trim();
    }

    /**
     * 获取 生日 t_professional.professional_birth
     *
     * @return 生日
     */
    public Date getProfessionalBirth() {
        return professionalBirth;
    }

    /**
     * 设置 生日 t_professional.professional_birth
     *
     * @param professionalBirth 生日
     */
    public void setProfessionalBirth(Date professionalBirth) {
        this.professionalBirth = professionalBirth;
    }

    /**
     * 获取 专业领域 t_professional.professional_field
     *
     * @return 专业领域
     */
    public String getProfessionalField() {
        return professionalField;
    }

    /**
     * 设置 专业领域 t_professional.professional_field
     *
     * @param professionalField 专业领域
     */
    public void setProfessionalField(String professionalField) {
        this.professionalField = professionalField == null ? null : professionalField.trim();
    }

    /**
     * 获取 身份证号码 t_professional.professional_IDCard
     *
     * @return 身份证号码
     */
    public String getProfessionalIdcard() {
        return professionalIdcard;
    }

    /**
     * 设置 身份证号码 t_professional.professional_IDCard
     *
     * @param professionalIdcard 身份证号码
     */
    public void setProfessionalIdcard(String professionalIdcard) {
        this.professionalIdcard = professionalIdcard == null ? null : professionalIdcard.trim();
    }

    /**
     * 获取 自我介绍 t_professional.professional_indroduction
     *
     * @return 自我介绍
     */
    public String getProfessionalIndroduction() {
        return professionalIndroduction;
    }

    /**
     * 设置 自我介绍 t_professional.professional_indroduction
     *
     * @param professionalIndroduction 自我介绍
     */
    public void setProfessionalIndroduction(String professionalIndroduction) {
        this.professionalIndroduction = professionalIndroduction == null ? null : professionalIndroduction.trim();
    }

    /**
     * 获取 创建时间 t_professional.professional_insertDT
     *
     * @return 创建时间
     */
    public Date getProfessionalInsertdt() {
        return professionalInsertdt;
    }

    /**
     * 设置 创建时间 t_professional.professional_insertDT
     *
     * @param professionalInsertdt 创建时间
     */
    public void setProfessionalInsertdt(Date professionalInsertdt) {
        this.professionalInsertdt = professionalInsertdt;
    }
}