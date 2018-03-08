package com.dajiang.app.common.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.base.service.DictService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joe on 2017/9/23.
 */
@RestController
public class DictController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DictController.class);

    @Autowired
    @Qualifier("dictServiceImpl")
    private DictService dictService;

    /**
     * 获取性别
     */
    @GetMapping("/public/dict/querySexCode")
    @ResponseBody
    public ResponseBaseDTO<Object> querySexCode() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectSexCode());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 获取学位
     *
     * @return
     */
    @GetMapping("/public/dict/queryDegreeCode")
    @ResponseBody
    public ResponseBaseDTO<Object> queryDegreeCode() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectDegreeCode());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 获取产品类型
     *
     * @return
     */
    @GetMapping("/public/dict/queryProductTypeCode")
    @ResponseBody
    public ResponseBaseDTO<Object> queryProductTypeCode() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectProductTypeCode());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 获取产品详细类型
     *
     * @return
     */
    @GetMapping("/public/dict/queryProductDetailTypeCode")
    @ResponseBody
    public ResponseBaseDTO<Object> queryProductDetailTypeCode() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectProductDetailTypeCode());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 获取图片类型
     *
     * @return
     */
    @GetMapping("/public/dict/queryPhotoType")
    @ResponseBody
    public ResponseBaseDTO<Object> queryPhotoType() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectPhotoType());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 获取产品类型
     *
     * @return
     */
    @GetMapping("/public/dict/queryProductStyle")
    @ResponseBody
    public ResponseBaseDTO<Object> queryProductStyle() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectProductStyle());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 获取反馈类型
     *
     * @return
     */
    @GetMapping("/public/dict/queryFeedBackType")
    @ResponseBody
    public ResponseBaseDTO<Object> queryFeedBackType() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectFeedBackType());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 获取专利类型
     *
     * @return
     */
    @GetMapping("/public/dict/queryPatentType")
    @ResponseBody
    public ResponseBaseDTO<Object> queryPatentType() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, dictService.selectPatentType());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

}
