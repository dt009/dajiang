/* github.com/zhouwd */
package com.dajiang.app.business.po.dmo;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * @author zhouwd code generator
 */
public class LabelMapping extends BaseDTO {
    private Integer labelMappingId;

    private Integer labelId;

    /**
     * 对应种类：1、用户；2、产品；
     */
    private Integer labelMappingType;

    /**
     * 对应对象id：包括用户id，产品id
     */
    private Long mappingId;

    /**
     * 获取 t_label_mapping.label_mapping_id
     *
     * @return t_label_mapping.label_mapping_id
     */
    public Integer getLabelMappingId() {
        return labelMappingId;
    }

    /**
     * 设置 t_label_mapping.label_mapping_id
     *
     * @param labelMappingId t_label_mapping.label_mapping_id
     */
    public void setLabelMappingId(Integer labelMappingId) {
        this.labelMappingId = labelMappingId;
    }

    /**
     * 获取 t_label_mapping.label_id
     *
     * @return t_label_mapping.label_id
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * 设置 t_label_mapping.label_id
     *
     * @param labelId t_label_mapping.label_id
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * 获取 对应种类：1、用户；2、产品； t_label_mapping.label_mapping_type
     *
     * @return 对应种类：1、用户；2、产品；
     */
    public Integer getLabelMappingType() {
        return labelMappingType;
    }

    /**
     * 设置 对应种类：1、用户；2、产品； t_label_mapping.label_mapping_type
     *
     * @param labelMappingType 对应种类：1、用户；2、产品；
     */
    public void setLabelMappingType(Integer labelMappingType) {
        this.labelMappingType = labelMappingType;
    }

    /**
     * 获取 对应对象id：包括用户id，产品id t_label_mapping.mapping_id
     *
     * @return 对应对象id：包括用户id，产品id
     */
    public Long getMappingId() {
        return mappingId;
    }

    /**
     * 设置 对应对象id：包括用户id，产品id t_label_mapping.mapping_id
     *
     * @param mappingId 对应对象id：包括用户id，产品id
     */
    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }
}