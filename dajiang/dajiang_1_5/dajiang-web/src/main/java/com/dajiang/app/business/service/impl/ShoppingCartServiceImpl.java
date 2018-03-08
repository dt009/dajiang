package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.constants.DictConstants;
import com.dajiang.app.base.service.DictService;
import com.dajiang.app.business.dao.ShoppingCartDAO;
import com.dajiang.app.business.po.dmo.ShoppingCart;
import com.dajiang.app.business.po.resp.ShoppingCartRespDTO;
import com.dajiang.app.business.service.ShoppingCartService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import com.dajiang.app.common.page.PageReqBean;
import com.dajiang.app.common.page.PageRespBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("shoppingCartServiceImpl")
@Scope("singleton")
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    @Autowired
    private ShoppingCartDAO shoppingcartDAO;

    @Autowired
    @Qualifier("dictServiceImpl")
    private DictService dictService;

    @Override
    public ShoppingCart selectByPrimaryKey(Integer shoppingcartId) {
        return this.shoppingcartDAO.selectByPrimaryKey(shoppingcartId);
    }

    @Override
    public PageRespBean<ShoppingCartRespDTO> selectList(UserSession userSession, PageReqBean reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectList(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        List<ShoppingCartRespDTO> selectList = this.shoppingcartDAO.selectList(userSession.getUserId());
        Map<Integer, String> itemCodeValueMap = dictService.selectForMap(DictConstants.PRODUCT_STYLE);
        for (ShoppingCartRespDTO shoppingCartRespDTO : selectList) {
            shoppingCartRespDTO.setProductStyleStr(itemCodeValueMap.get(shoppingCartRespDTO.getProductStyle().intValue()));
        }
        return new PageRespBean<>(selectList);
    }

    @Override
    public int deleteByProductId(UserSession userSession, Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("deleteByProductId(userSession = [" + userSession + "], productId = [" + productId + "]) -start");
        }


        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }

        return this.shoppingcartDAO.deleteByUserProduct(userSession.getUserId(), productId);
    }


    @Override
    public int insertSelective(UserSession userSession, Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertSelective(userSession = [" + userSession + "], productId = [" + productId + "]) -start");
        }

        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        ShoppingCart temp = this.shoppingcartDAO.selectByUserProduct(userSession.getUserId(), productId);
        if (temp != null) {
            return 0;
        }
        ShoppingCart record = new ShoppingCart();
        Date operTime = new Date();
        record.setProductId(productId);
        record.setUserId(userSession.getUserId());
        record.setShoppingcartInsertdt(operTime);
        record.setShoppingcartUpdatedt(operTime);
        return this.shoppingcartDAO.insertSelective(record);
    }
}