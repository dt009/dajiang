/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.Date;

/**
 * @author zhouwd code generator
 */
public class ProfessionalPhotoApply extends BaseDTO {
    private Integer professionalPhoteApplyId;

    private Long userId;

    /** 
     * 图片分类：1、职业资格证书;2:获奖证明；3：其他资料；
     */
    private Byte professionalPhoteType;

    /** 
     * 图片路径
     */
    private String professionalPhotePath;

    /** 
     * 每个类别图片顺序
     */
    private Integer professionalPhoteSort;

    /** 
     * 插入时间
     */
    private Date professionalPhoteInsertdt;

    /** 
     * 申请大匠主表id
     */
    private Integer professionalApplyId;

    /** 
     * 获取 t_professional_photo_apply.professional_phote_apply_id
     * @return t_professional_photo_apply.professional_phote_apply_id
     */
    public Integer getProfessionalPhoteApplyId() {
        return professionalPhoteApplyId;
    }

    /** 
     * 设置 t_professional_photo_apply.professional_phote_apply_id
     * @param professionalPhoteApplyId t_professional_photo_apply.professional_phote_apply_id
     */
    public void setProfessionalPhoteApplyId(Integer professionalPhoteApplyId) {
        this.professionalPhoteApplyId = professionalPhoteApplyId;
    }

    /** 
     * 获取 t_professional_photo_apply.user_id
     * @return t_professional_photo_apply.user_id
     */
    public Long getUserId() {
        return userId;
    }

    /** 
     * 设置 t_professional_photo_apply.user_id
     * @param userId t_professional_photo_apply.user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
     * 获取 图片分类：1、职业资格证书;2:获奖证明；3：其他资料； t_professional_photo_apply.professional_phote_type
     * @return 图片分类：1、职业资格证书;2:获奖证明；3：其他资料；
     */
    public Byte getProfessionalPhoteType() {
        return professionalPhoteType;
    }

    /** 
     * 设置 图片分类：1、职业资格证书;2:获奖证明；3：其他资料； t_professional_photo_apply.professional_phote_type
     * @param professionalPhoteType 图片分类：1、职业资格证书;2:获奖证明；3：其他资料；
     */
    public void setProfessionalPhoteType(Byte professionalPhoteType) {
        this.professionalPhoteType = professionalPhoteType;
    }

    /** 
     * 获取 图片路径 t_professional_photo_apply.professional_phote_path
     * @return 图片路径
     */
    public String getProfessionalPhotePath() {
        return professionalPhotePath;
    }

    /** 
     * 设置 图片路径 t_professional_photo_apply.professional_phote_path
     * @param professionalPhotePath 图片路径
     */
    public void setProfessionalPhotePath(String professionalPhotePath) {
        this.professionalPhotePath = professionalPhotePath == null ? null : professionalPhotePath.trim();
    }

    /** 
     * 获取 每个类别图片顺序 t_professional_photo_apply.professional_phote_sort
     * @return 每个类别图片顺序
     */
    public Integer getProfessionalPhoteSort() {
        return professionalPhoteSort;
    }

    /** 
     * 设置 每个类别图片顺序 t_professional_photo_apply.professional_phote_sort
     * @param professionalPhoteSort 每个类别图片顺序
     */
    public void setProfessionalPhoteSort(Integer professionalPhoteSort) {
        this.professionalPhoteSort = professionalPhoteSort;
    }

    /** 
     * 获取 插入时间 t_professional_photo_apply.professional_phote_insertDT
     * @return 插入时间
     */
    public Date getProfessionalPhoteInsertdt() {
        return professionalPhoteInsertdt;
    }

    /** 
     * 设置 插入时间 t_professional_photo_apply.professional_phote_insertDT
     * @param professionalPhoteInsertdt 插入时间
     */
    public void setProfessionalPhoteInsertdt(Date professionalPhoteInsertdt) {
        this.professionalPhoteInsertdt = professionalPhoteInsertdt;
    }

    /** 
     * 获取 申请大匠主表id t_professional_photo_apply.professional_apply_id
     * @return 申请大匠主表id
     */
    public Integer getProfessionalApplyId() {
        return professionalApplyId;
    }

    /** 
     * 设置 申请大匠主表id t_professional_photo_apply.professional_apply_id
     * @param professionalApplyId 申请大匠主表id
     */
    public void setProfessionalApplyId(Integer professionalApplyId) {
        this.professionalApplyId = professionalApplyId;
    }
}