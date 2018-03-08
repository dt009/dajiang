package com.dajiang.app.business.service;

import com.dajiang.app.business.po.req.ProductApplyReqDTO;
import com.dajiang.app.business.po.req.ProductUpdatePriceReqDTO;
import com.dajiang.app.business.po.resp.ProductApplyRespDTO;
import com.dajiang.app.common.context.UserSession;

public interface ProductApplyService {
    ProductApplyRespDTO selectByPrimaryKey(Integer productId);

    int deleteByPrimaryKey(UserSession userSession, Integer productId);

    int updateByPrimaryKey(UserSession userSession, ProductApplyReqDTO reqDTO);

    int insertSelective(UserSession userSession, ProductApplyReqDTO reqDTO, Byte productStyle);

    int updatePriceByPrimaryKey(UserSession userSession, ProductUpdatePriceReqDTO reqDTO);
}