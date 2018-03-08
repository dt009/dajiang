package com.dajiang.app.common.controller;

import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.service.ProfessionalTypeService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Joe on 2017/9/23.
 */
@RestController
public class ProfessionalTypeController {

    private static final Logger logger = LoggerFactory.getLogger(ProfessionalTypeController.class);


    @Autowired
    @Qualifier("professionalTypeServiceImpl")
    private ProfessionalTypeService professionalTypeService;

    /**
     * 专家分类。输入父类别ID。一级分类的父类ID为0;
     */
    @RequestMapping(value = "/public/professionalType/queryByPid/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBaseDTO<Object> queryByPid(@PathVariable("pid") Integer reqDTO) {
        try {
            if (reqDTO == null) {
                reqDTO = 0;
            }
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalTypeService.selectByParentId(reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

}
