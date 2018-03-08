package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.req.ProfessionalReqDTO;
import com.dajiang.app.business.po.resp.ProfessionalRespDTO;
import com.dajiang.app.business.service.ProfessionalService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Joe on 2017/9/29.
 */
@RestController
public class ProfessionalController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProfessionalController.class);


    @Autowired
    @Qualifier("professionalServiceImpl")
    private ProfessionalService professionalService;

    /**
     * 根据用户ID初始化大匠资料
     */
    @PostMapping("/private/professional/initProfess")
    @ResponseBody
    public ResponseBaseDTO<ProfessionalRespDTO> initProfess() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalService.selectByUserId(getUserSession()));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 修改保存大匠资料
     */
    @RequestMapping("/private/professional/sendProfVertif")
    @ResponseBody
    public ResponseBaseDTO<Object> sendProfVertif(@RequestBody ProfessionalReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, professionalService.updateByPrimaryKey(reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


}
