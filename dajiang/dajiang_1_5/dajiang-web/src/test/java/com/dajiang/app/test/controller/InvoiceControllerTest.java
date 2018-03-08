package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.req.InvoiceReqDTO;
import org.junit.Test;

import java.util.Arrays;

public class InvoiceControllerTest extends BaseControllerTest {
    @Test
    public void initAskInvoice() throws Exception {
        doPostTest(getDJSession(), "/private/invoice/initAskInvoice", null);
    }

    @Test
    public void saveInvoice() throws Exception {
        InvoiceReqDTO reqDTO = new InvoiceReqDTO();
        reqDTO.setInvoiceHeader("尚德");
        reqDTO.setInvoiceTaxNumber("234232");
        reqDTO.setInvoiceMedium(1);
        reqDTO.setInvoiceReceiveEmail("333");
        reqDTO.setInvoiceReceiveName("333");
        reqDTO.setInvoiceReceiveAddress("333");
        reqDTO.setInvoiceReceiveTelephone("14211112222");
        reqDTO.setOrderIdList(Arrays.asList(1, 2));
        doPostTest(getDJSession(), "/private/invoice/saveInvoice", reqDTO);
    }

}