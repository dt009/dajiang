package com.dajiang.app.business.service;

import com.dajiang.app.business.po.dmo.Product;
import com.dajiang.app.business.po.req.ProductQueryReqDTO;
import com.dajiang.app.business.po.req.ProductReqDTO;
import com.dajiang.app.business.po.req.ProductUpdatePriceReqDTO;
import com.dajiang.app.business.po.resp.ProductPageRespDTO;
import com.dajiang.app.business.po.resp.ProductRespDTO;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.page.PageReqBean;
import com.dajiang.app.common.page.PageRespBean;

import java.util.List;

public interface ProductService {

    ProductRespDTO selectByPrimaryKey(Integer productId);

    List<ProductPageRespDTO> selectShowList(UserSession userSession);

    PageRespBean<ProductPageRespDTO> selectByProfessionalId(UserSession userSession, PageReqBean pageReqBean, Integer professionalId, String productStyle);

    PageRespBean<ProductPageRespDTO> selectByCkoId(UserSession userSession, PageReqBean pageReqBean, Integer professionalId, String productStyle);

    PageRespBean<ProductPageRespDTO> selectForMore(UserSession userSession, PageReqBean<ProductQueryReqDTO> reqDTO);

    PageRespBean<ProductPageRespDTO> selectOnSaleProducts(UserSession userSession, PageReqBean<List<Byte>> reqDTO);

    PageRespBean<ProductPageRespDTO> selectPreSaleProducts(UserSession userSession, PageReqBean<List<Byte>> reqDTO);

    int deleteByPrimaryKey(Integer productId);

    int updateByPrimaryKey(UserSession userSession, ProductReqDTO reqDTO, Byte productStylePatent);

    int updatePriceByPrimaryKey(UserSession userSession, ProductUpdatePriceReqDTO reqDTO);

    int updateTypeByPrimaryKey(UserSession userSession, ProductUpdatePriceReqDTO reqDTO);

    int insertSelective(Product record);

    int submitAudit(UserSession userSession, Integer productId, String saleFlag);

    int submitOnSale(UserSession userSession, Integer productId);

}