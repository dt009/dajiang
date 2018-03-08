package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.req.InvoiceReqDTO;
import com.dajiang.app.business.service.InvoiceService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    @Qualifier("invoiceServiceImpl")
    private InvoiceService invoiceService;

    /**
     * 初始化发票列表
     */
    @PostMapping("/private/invoice/initAskInvoice")
    @ResponseBody
    public ResponseBaseDTO<Object> initAskInvoice() {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, invoiceService.initAskInvoice(getUserSession()));
        } catch (BaseException e) {
            logger.error("/private/invoice/initAskInvoice：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/invoice/initAskInvoice：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 保存发票
     */
    @PostMapping("/private/invoice/saveInvoice")
    @ResponseBody
    public ResponseBaseDTO<Object> saveInvoice(@RequestBody InvoiceReqDTO reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, invoiceService.insertInvoice(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error("/private/invoice/saveInvoice：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/invoice/saveInvoice：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

}
