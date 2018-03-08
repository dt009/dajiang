package com.dajiang.app.business.service;

import com.dajiang.app.business.po.resp.ProductPageRespDTO;
import com.dajiang.app.common.context.UserSession;

import java.util.List;

public interface MyKnowLedgesService {
    List<ProductPageRespDTO> initMyKnowLedges(UserSession userSession, Integer productType);
}
