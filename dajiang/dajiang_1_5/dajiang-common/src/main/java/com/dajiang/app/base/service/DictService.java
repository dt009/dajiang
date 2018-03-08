package com.dajiang.app.base.service;

import com.dajiang.app.base.po.dmo.DictDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Joe on 2017/9/23.
 */
public interface DictService {

    /**
     * 性别
     *
     * @return
     */
    List<DictDTO> selectSexCode();

    /**
     * 学历
     * @return
     */
    List<DictDTO> selectDegreeCode();

    /**
     * 产品类型
     * @return
     */
    List<DictDTO> selectProductTypeCode();

    /**
     * 产品明细类型
     * @return
     */
    List<DictDTO> selectProductDetailTypeCode();

    /**
     * 图片分类
     * @return
     */
    List<DictDTO> selectPhotoType();

    /**
     * 产品类别
     *
     * @return
     */
    List<DictDTO> selectProductStyle();

    /**
     * 反馈类型
     *
     * @return
     */
    List<DictDTO> selectFeedBackType();

    /**
     * 专利类型
     *
     * @return
     */
    List<DictDTO> selectPatentType();

    Map<Integer, String> selectForMap(String productStyle);

}
