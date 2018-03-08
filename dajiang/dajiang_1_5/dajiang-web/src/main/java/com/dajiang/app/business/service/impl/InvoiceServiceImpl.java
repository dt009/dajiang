package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.InvoiceDAO;
import com.dajiang.app.business.po.dmo.Invoice;
import com.dajiang.app.business.po.req.InvoiceReqDTO;
import com.dajiang.app.business.po.resp.OrderRespDTO;
import com.dajiang.app.business.service.InvoiceService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("invoiceServiceImpl")
@Scope("singleton")
public class InvoiceServiceImpl implements InvoiceService {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Override
    public Invoice selectByPrimaryKey(Integer invoiceId) {
        return this.invoiceDAO.selectByPrimaryKey(invoiceId);
    }

    @Override
    public int deleteByPrimaryKey(Integer invoiceId) {
        return this.invoiceDAO.deleteByPrimaryKey(invoiceId);
    }

    @Override
    public int updateByPrimaryKeySelective(Invoice record) {
        return this.invoiceDAO.updateByPrimaryKeySelective(record);
    }


    @Override
    public List<OrderRespDTO> initAskInvoice(UserSession userSession) {
        return this.invoiceDAO.initAskInvoice(userSession.getUserId());
    }

    @Override
    public int insertInvoice(UserSession userSession, InvoiceReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-insertInvoice(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "])");
        }

        if (StringUtils.isAnyEmpty(reqDTO.getInvoiceHeader(), reqDTO.getInvoiceReceiveAddress(), reqDTO.getInvoiceReceiveName(), reqDTO.getInvoiceReceiveEmail(), reqDTO.getInvoiceReceiveTelephone())) {
            throw SystemExceptionFactory.keyException();
        }

        int i = this.invoiceDAO.insertInvoice(userSession.getUserId(), reqDTO);
        if (i == SystemExceptionFactory.DB_CALL_FAIL) {
            throw SystemExceptionFactory.callProcedureException();
        }
        return i;
    }
}