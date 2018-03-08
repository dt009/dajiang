/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * 标签 t_label
 *
 * @author zhouwd code generator
 */
public class Label extends BaseDTO {
    private Integer labelId;

    private String labelName;

    private String labelType;

    /**
     * 获取 t_label.label_id
     *
     * @return t_label.label_id
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * 设置 t_label.label_id
     *
     * @param labelId t_label.label_id
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * 获取 t_label.label_name
     *
     * @return t_label.label_name
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * 设置 t_label.label_name
     *
     * @param labelName t_label.label_name
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    /**
     * 获取 t_label.label_type
     *
     * @return t_label.label_type
     */
    public String getLabelType() {
        return labelType;
    }

    /**
     * 设置 t_label.label_type
     *
     * @param labelType t_label.label_type
     */
    public void setLabelType(String labelType) {
        this.labelType = labelType == null ? null : labelType.trim();
    }
}