/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * 大匠分类 t_professional_type
 *
 * @author zhouwd code generator
 */
public class ProfessionalType extends BaseDTO {
    private Integer professionalTypeId;

    /**
     * 分类名称
     */
    private String professionalTypeName;

    /**
     * 上一级分类id
     */
    private Integer professionalTypeParentId;

    /**
     * 分类级别
     */
    private Integer professionalTypeLevel;

    /**
     * 插入时间
     */
    private Date professionalTypeInsertdt;

    /**
     * 修改时间
     */
    private Date professionalTypeUpdatedt;

    /**
     * 获取 t_professional_type.professional_type_id
     *
     * @return t_professional_type.professional_type_id
     */
    public Integer getProfessionalTypeId() {
        return professionalTypeId;
    }

    /**
     * 设置 t_professional_type.professional_type_id
     *
     * @param professionalTypeId t_professional_type.professional_type_id
     */
    public void setProfessionalTypeId(Integer professionalTypeId) {
        this.professionalTypeId = professionalTypeId;
    }

    /**
     * 获取 分类名称 t_professional_type.professional_type_name
     *
     * @return 分类名称
     */
    public String getProfessionalTypeName() {
        return professionalTypeName;
    }

    /**
     * 设置 分类名称 t_professional_type.professional_type_name
     *
     * @param professionalTypeName 分类名称
     */
    public void setProfessionalTypeName(String professionalTypeName) {
        this.professionalTypeName = professionalTypeName == null ? null : professionalTypeName.trim();
    }

    /**
     * 获取 上一级分类id t_professional_type.professional_type_parent_id
     *
     * @return 上一级分类id
     */
    public Integer getProfessionalTypeParentId() {
        return professionalTypeParentId;
    }

    /**
     * 设置 上一级分类id t_professional_type.professional_type_parent_id
     *
     * @param professionalTypeParentId 上一级分类id
     */
    public void setProfessionalTypeParentId(Integer professionalTypeParentId) {
        this.professionalTypeParentId = professionalTypeParentId;
    }

    /**
     * 获取 分类级别 t_professional_type.professional_type_level
     *
     * @return 分类级别
     */
    public Integer getProfessionalTypeLevel() {
        return professionalTypeLevel;
    }

    /**
     * 设置 分类级别 t_professional_type.professional_type_level
     *
     * @param professionalTypeLevel 分类级别
     */
    public void setProfessionalTypeLevel(Integer professionalTypeLevel) {
        this.professionalTypeLevel = professionalTypeLevel;
    }

    /**
     * 获取 插入时间 t_professional_type.professional_type_insertDT
     *
     * @return 插入时间
     */
    public Date getProfessionalTypeInsertdt() {
        return professionalTypeInsertdt;
    }

    /**
     * 设置 插入时间 t_professional_type.professional_type_insertDT
     *
     * @param professionalTypeInsertdt 插入时间
     */
    public void setProfessionalTypeInsertdt(Date professionalTypeInsertdt) {
        this.professionalTypeInsertdt = professionalTypeInsertdt;
    }

    /**
     * 获取 修改时间 t_professional_type.professional_type_updateDT
     *
     * @return 修改时间
     */
    public Date getProfessionalTypeUpdatedt() {
        return professionalTypeUpdatedt;
    }

    /**
     * 设置 修改时间 t_professional_type.professional_type_updateDT
     *
     * @param professionalTypeUpdatedt 修改时间
     */
    public void setProfessionalTypeUpdatedt(Date professionalTypeUpdatedt) {
        this.professionalTypeUpdatedt = professionalTypeUpdatedt;
    }
}