package com.dajiang.app.common.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.service.BankService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    @Qualifier("bankServiceImpl")
    private BankService bankService;


    /**
     *
     */
    @GetMapping("/public/bank/queryBankList")
    @ResponseBody
    public ResponseBaseDTO<Object> queryBankList() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, bankService.selectAll());
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


}
