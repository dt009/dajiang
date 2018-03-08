package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.service.MyKnowLedgesService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyKnowLedgesController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MyKnowLedgesController.class);


    @Autowired
    @Qualifier("myKnowLedgesServiceImpl")
    private MyKnowLedgesService myKnowLedgesService;

    /**
     *
     */
    @RequestMapping("/private/myKnowLedges/initMyKnowLedges/{productType}")
    @ResponseBody
    public ResponseBaseDTO<Object> initMyKnowLedges(@PathVariable("productType") Integer productType) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, myKnowLedgesService.initMyKnowLedges(getUserSession(), productType));
        } catch (BaseException e) {
            logger.error("/private/myKnowLedges/initMyKnowLedges：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/myKnowLedges/initMyKnowLedges：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


}
