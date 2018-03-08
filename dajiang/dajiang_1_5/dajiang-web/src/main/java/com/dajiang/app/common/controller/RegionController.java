package com.dajiang.app.common.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.RegionDTO;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.base.service.RegionService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Joe on 2017/9/23.
 */
@RestController
public class RegionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    @Qualifier("regionServiceImpl")
    private RegionService regionService;

    /**
     *
     */
    @GetMapping(value = "/public/region/queryByPid/{pid}")
    @ResponseBody
    public ResponseBaseDTO<List<RegionDTO>> queryByPid(@PathVariable("pid") Integer pid) {
        try {
            if (pid == null) {
                pid = 0;
            }
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, regionService.selectByPid(pid));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


}
