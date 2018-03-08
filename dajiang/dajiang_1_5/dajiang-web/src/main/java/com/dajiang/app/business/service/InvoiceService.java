package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Invoice;
import com.dajiang.app.business.po.req.InvoiceReqDTO;
import com.dajiang.app.business.po.resp.OrderRespDTO;
import com.dajiang.app.common.context.UserSession;

import java.util.List;

public interface InvoiceService {
    Invoice selectByPrimaryKey(Integer invoiceId);

    int deleteByPrimaryKey(Integer invoiceId);

    int updateByPrimaryKeySelective(Invoice record);

    List<OrderRespDTO> initAskInvoice(UserSession userSession);

    int insertInvoice(UserSession userSession, InvoiceReqDTO reqDTO);
}