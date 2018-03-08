package com.dajiang.app.base.service.impl;

import com.dajiang.app.base.constants.DictConstants;
import com.dajiang.app.base.dao.DictDAO;
import com.dajiang.app.base.po.dmo.DictDTO;
import com.dajiang.app.base.service.DictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Joe on 2017/9/23.
 */
@Service("dictServiceImpl")
@Scope("singleton")
public class DictServiceImpl implements DictService {

    private static final Logger logger = LoggerFactory.getLogger(DictServiceImpl.class);

    @Autowired
    private DictDAO dictDAO;

    @Override
    public List<DictDTO> selectSexCode() {
        return dictDAO.selectByDictCode(DictConstants.SEX_CODE);
    }

    @Override
    public List<DictDTO> selectDegreeCode() {
        return dictDAO.selectByDictCode(DictConstants.DEGREE_CODE);
    }

    @Override
    public List<DictDTO> selectProductTypeCode() {
        return dictDAO.selectByDictCode(DictConstants.PRODUCT_TYPE);
    }


    @Override
    public List<DictDTO> selectProductDetailTypeCode() {
        return dictDAO.selectByDictCode(DictConstants.PRODUCT_DETAIL_TYPE);
    }

    @Override
    public List<DictDTO> selectPhotoType() {
        return dictDAO.selectByDictCode(DictConstants.PHOTO_TYPE);
    }

    @Override
    public List<DictDTO> selectProductStyle() {
        return dictDAO.selectByDictCode(DictConstants.PRODUCT_STYLE);
    }

    @Override
    public List<DictDTO> selectFeedBackType() {
        return dictDAO.selectByDictCode(DictConstants.FEEDBACK_TYPE);
    }

    @Override
    public List<DictDTO> selectPatentType() {
        return dictDAO.selectByDictCode(DictConstants.PATENT_TYPE);
    }

    @Override
    public Map<Integer, String> selectForMap(String dictName) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-selectForMap(dictName = [" + dictName + "])");
        }

        List<DictDTO> dictDTOS = dictDAO.selectByDictCode(DictConstants.PRODUCT_STYLE);
        Map<Integer, String> map = new HashMap<>();
        for (DictDTO dictDTO : dictDTOS) {
            map.put(dictDTO.getItemCode(), dictDTO.getItemValue());
        }
        return map;
    }
}
