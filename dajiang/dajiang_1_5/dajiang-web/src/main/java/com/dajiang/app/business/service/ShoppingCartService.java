package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.ShoppingCart;
import com.dajiang.app.business.po.resp.ShoppingCartRespDTO;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.page.PageReqBean;
import com.dajiang.app.common.page.PageRespBean;

public interface ShoppingCartService {
    ShoppingCart selectByPrimaryKey(Integer shoppingcartId);

    int deleteByProductId(UserSession userSession, Integer productId);

    int insertSelective(UserSession userSession, Integer productId);

    PageRespBean<ShoppingCartRespDTO> selectList(UserSession userSession, PageReqBean reqDTO);
}