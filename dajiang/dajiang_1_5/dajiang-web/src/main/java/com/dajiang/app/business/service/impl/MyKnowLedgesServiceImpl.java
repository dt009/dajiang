package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.constants.DictConstants;
import com.dajiang.app.base.service.DictService;
import com.dajiang.app.business.dao.MyKnowLedgesDAO;
import com.dajiang.app.business.po.resp.ProductPageRespDTO;
import com.dajiang.app.business.service.MyKnowLedgesService;
import com.dajiang.app.common.context.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("myKnowLedgesServiceImpl")
@Scope("singleton")
public class MyKnowLedgesServiceImpl implements MyKnowLedgesService {

    private static final Logger logger = LoggerFactory.getLogger(MyKnowLedgesServiceImpl.class);

    @Autowired
    private MyKnowLedgesDAO myKnowLedgesDAO;

    @Autowired
    @Qualifier("dictServiceImpl")
    private DictService dictService;

    @Override
    public List<ProductPageRespDTO> initMyKnowLedges(UserSession userSession, Integer productType) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-initMyKnowLedges(userSession = [" + userSession + "], productType = [" + productType + "])");
        }
        Map<Integer, String> productStyleMap = dictService.selectForMap(DictConstants.PRODUCT_STYLE);
        List<ProductPageRespDTO> productPageRespDTOS = myKnowLedgesDAO.initMyKnowLedges(userSession.getUserId(), productType);
        for (ProductPageRespDTO productPageRespDTO : productPageRespDTOS) {
            productPageRespDTO.setProductStyleStr(productStyleMap.get(productPageRespDTO.getProductStyle().intValue()));
        }
        return productPageRespDTOS;
    }
}
