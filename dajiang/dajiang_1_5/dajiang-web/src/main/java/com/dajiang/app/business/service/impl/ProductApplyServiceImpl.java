package com.dajiang.app.business.service.impl;

import com.dajiang.app.business.dao.ProductApplyDAO;
import com.dajiang.app.business.dao.ProductDetailApplyDAO;
import com.dajiang.app.business.po.dmo.ProductApply;
import com.dajiang.app.business.po.dmo.ProductDetailApply;
import com.dajiang.app.business.po.req.ProductApplyReqDTO;
import com.dajiang.app.business.po.req.ProductUpdatePriceReqDTO;
import com.dajiang.app.business.po.resp.ProductApplyRespDTO;
import com.dajiang.app.business.service.ProductApplyService;
import com.dajiang.app.common.context.UserSession;
import com.dajiang.app.common.exception.SystemExceptionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("productApplyServiceImpl")
@Scope("singleton")
public class ProductApplyServiceImpl implements ProductApplyService {
    private static final Logger logger = LoggerFactory.getLogger(ProductApplyServiceImpl.class);

    @Autowired
    private ProductApplyDAO productApplyDAO;

    @Autowired
    private ProductDetailApplyDAO productDetailApplyDAO;

    @Override
    public ProductApplyRespDTO selectByPrimaryKey(Integer productId) {
        ProductApplyRespDTO productApplyRespDTO = this.productApplyDAO.selectByPrimaryKey(productId);
        if (productApplyRespDTO == null) {
            throw SystemExceptionFactory.nullException();
        }
        productApplyRespDTO.setDetailList(productDetailApplyDAO.selectByProductId(productId));
        return productApplyRespDTO;
    }

    @Override
    public int deleteByPrimaryKey(UserSession userSession, Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("deleteByPrimaryKey(productId = [" + productId + "]) -start");
        }
        ProductApplyRespDTO productApply = productApplyDAO.selectByPrimaryKey(productId);
        if (productApply == null) {
            throw SystemExceptionFactory.nullException();
        }
//        if (!productApply.getUserIdAuthor().equals(userSession.getUserId())) {
//            throw new BaseException(ExceptionType.Business_Delete, "没有权限删除该商品。");
//        }
        this.productDetailApplyDAO.deleteByPid(productId);
        return this.productApplyDAO.deleteByPrimaryKey(productId);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(UserSession userSession, ProductApplyReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateByPrimaryKey(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        if (reqDTO.getProductId() == null) {
            throw SystemExceptionFactory.keyException();
        }
        Date date = new Date();
        ProductApply record = new ProductApply();
        BeanUtils.copyProperties(reqDTO, record);
        record.setProductCreatedt(date);
        record.setProductUpdatedt(date);
        record.setUserId(userSession.getUserId());
        int intValue = record.getProductStatus().intValue();
        if (1 != intValue && 2 != intValue && 3 != intValue) {
            record.setProductStatus((byte) 1);
        }
        int result = this.productApplyDAO.updateByPrimaryKeySelective(record);
        if (result == 0) {
            return 0;
        }
        List<ProductDetailApply> detailApplyList = reqDTO.getDetailApplyList();
        productDetailApplyDAO.deleteByPid(record.getProductId());
        for (int i = 0; i < detailApplyList.size(); i++) {
            ProductDetailApply detailApply = detailApplyList.get(i);
            detailApply.setProductId(record.getProductId());
            detailApply.setProductDetailSort(i + 1);
            productDetailApplyDAO.insertSelective(detailApply);
        }
        if (record.getProductStatus() == 3) {
            int i = productApplyDAO.callProductApply(record.getProductId());
            if (i == SystemExceptionFactory.DB_CALL_FAIL) {
                throw SystemExceptionFactory.callProcedureException();
            }
            logger.info("CALL p_product_apply({}) = {}", record.getProductId(), i);
        }
        return result;
    }

    @Override
    @Transactional
    public int insertSelective(UserSession userSession, ProductApplyReqDTO reqDTO, Byte productStyle) {
        if (logger.isDebugEnabled()) {
            logger.debug("insertSelective(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "], productStyle = [" + productStyle + "]) -start");
        }
        Date date = new Date();
        ProductApply record = new ProductApply();
        BeanUtils.copyProperties(reqDTO, record);
        record.setProductCreatedt(date);
        record.setProductUpdatedt(date);
        record.setUserId(userSession.getUserId());
        record.setProductStyle(productStyle);
        int productStatus = record.getProductStatus().intValue();
        if (1 != productStatus && 2 != productStatus && 3 != productStatus) {
            record.setProductStatus((byte) 1);
        }
        int result = this.productApplyDAO.insertSelective(record);
        List<ProductDetailApply> detailApplyList = reqDTO.getDetailApplyList();
        for (int i = 0; i < detailApplyList.size(); i++) {
            ProductDetailApply detailApply = detailApplyList.get(i);
            detailApply.setProductId(record.getProductId());
            detailApply.setProductDetailSort(i + 1);
            productDetailApplyDAO.insertSelective(detailApply);
        }
        if (productStatus == 3) {
            int i = productApplyDAO.callProductApply(record.getProductId());
            if (i == SystemExceptionFactory.DB_CALL_FAIL) {
                throw SystemExceptionFactory.callProcedureException();
            }

            logger.info("CALL p_product_apply({}) = {}", record.getProductId(), i);
        }
        return result;
    }

    @Override
    public int updatePriceByPrimaryKey(UserSession userSession, ProductUpdatePriceReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updatePriceByPrimaryKey(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        ProductApplyRespDTO productRespDTO = productApplyDAO.selectByPrimaryKey(reqDTO.getProductId());
        if (productRespDTO == null) {
            throw SystemExceptionFactory.nullException();
        }
        ProductApply product = new ProductApply();
        product.setProductId(reqDTO.getProductId());
        product.setProductPrice(reqDTO.getProductPrice());
        product.setProductType(reqDTO.getProductType());
        product.setProductUpdatedt(new Date());
        return this.productApplyDAO.updateByPrimaryKeySelective(product);
    }
}