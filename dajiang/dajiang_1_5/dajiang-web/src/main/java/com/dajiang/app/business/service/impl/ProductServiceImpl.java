package com.dajiang.app.business.service.impl;

import com.dajiang.app.base.service.DictService;
import com.dajiang.app.business.dao.*;
import com.dajiang.app.business.po.dmo.Cko;
import com.dajiang.app.business.po.dmo.Product;
import com.dajiang.app.business.po.dmo.ProductApply;
import com.dajiang.app.business.po.dmo.ProductUser;
import com.dajiang.app.business.po.req.ProductQueryReqDTO;
import com.dajiang.app.business.po.req.ProductReqDTO;
import com.dajiang.app.business.po.req.ProductUpdatePriceReqDTO;
import com.dajiang.app.business.po.resp.ProductApplyRespDTO;
import com.dajiang.app.business.po.resp.ProductPageRespDTO;
import com.dajiang.app.business.po.resp.ProductRespDTO;
import com.dajiang.app.business.service.ProductService;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("productServiceImpl")
@Scope("singleton")
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductApplyDAO productApplyDAO;

    @Autowired
    private ProductDetailDAO productDetailDAO;

    @Autowired
    private ProductUserDAO productUserDAO;

    @Autowired
    private ProfessionalDAO professionalDAO;

    @Autowired
    private CkoDAO ckoDAO;

    @Autowired
    @Qualifier("dictServiceImpl")
    private DictService dictService;


    @Override
    public ProductRespDTO selectByPrimaryKey(Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectByPrimaryKey(productId = [" + productId + "]) -start");
        }
        ProductRespDTO productRespDTO = this.productDAO.selectByPrimaryKey(productId);
        if (productRespDTO == null) {
            throw SystemExceptionFactory.nullException();
        }
        ProductUser productUser = productUserDAO.selectByProductId(productId);
        if (productUser != null) {
            productRespDTO.setUserId(productUser.getUserId());
        }
        productRespDTO.setDetailList(productDetailDAO.selectByProductId(productId));
        return productRespDTO;
    }

    @Override
    public List<ProductPageRespDTO> selectShowList(UserSession userSession) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectShowList(userSession = [" + userSession + "]) -start");
        }
        Long userId = null;
        if (userSession != null) {
            userId = userSession.getUserId();
        }
        PageHelper.startPage(1, 3);
        return this.productDAO.selectShowList(userId, null);
    }


    @Override
    public PageRespBean<ProductPageRespDTO> selectForMore(UserSession userSession, PageReqBean<ProductQueryReqDTO> reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectForMore(reqDTO = [" + reqDTO + "]) -start");
        }
        Long userId = null;
        if (userSession != null) {
            userId = userSession.getUserId();
        }
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        return new PageRespBean<>(this.productDAO.selectShowList(userId, reqDTO.getCondition()));
    }

    @Override
    public PageRespBean<ProductPageRespDTO> selectByProfessionalId(UserSession userSession, PageReqBean reqDTO, Integer professionalId, String productStyle) {
        Long userId = professionalDAO.selectUserIdByPrimaryKey(professionalId);
        if (userId == null) {
            throw SystemExceptionFactory.nullException();
        }
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        Long loginUser = null;
        if (userSession != null) {
            loginUser = userSession.getUserId();
        }
        return new PageRespBean<>(this.productDAO.selectByUserId(loginUser, userId, productStyle));
    }

    @Override
    public PageRespBean<ProductPageRespDTO> selectByCkoId(UserSession userSession, PageReqBean pageReqBean, Integer ckoId, String productStyle) {
        Cko cko = ckoDAO.selectByPrimaryKey(ckoId);
        if (cko == null) {
            throw SystemExceptionFactory.nullException();
        }
        PageHelper.startPage(pageReqBean.getPageNum(), pageReqBean.getPageSize());
        Long loginUserId = null;
        if (userSession != null) {
            loginUserId = userSession.getUserId();
        }
        return new PageRespBean<>(this.productDAO.selectByUserId(loginUserId, cko.getUserId(), productStyle));
    }

    @Override
    public PageRespBean<ProductPageRespDTO> selectOnSaleProducts(UserSession userSession, PageReqBean<List<Byte>> reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectOnSaleProducts(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        return new PageRespBean<>(this.productDAO.selectOnSale(userSession.getUserId(), reqDTO.getCondition()));
    }

    @Override
    public PageRespBean<ProductPageRespDTO> selectPreSaleProducts(UserSession userSession, PageReqBean<List<Byte>> reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("selectPreSaleProducts(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        return new PageRespBean<>(this.productApplyDAO.selectPreSale(userSession.getUserId(), reqDTO.getCondition()));
    }

    @Override
    public int deleteByPrimaryKey(Integer productId) {
        return this.productDAO.deleteByPrimaryKey(productId);
    }

    @Override
    public int updateByPrimaryKey(UserSession userSession, ProductReqDTO reqDTO, Byte productStylePatent) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateByPrimaryKey(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "], productStylePatent = [" + productStylePatent + "]) -start");
        }
        Product product = new Product();
        product.setProductId(reqDTO.getProductId());
        product.setProductPrice(reqDTO.getProductPrice());
        product.setProductType(reqDTO.getProductType());
        product.setProductUpdatedt(new Date());
        return this.productDAO.updateByPrimaryKeySelective(product);
    }

    @Override
    public int updateTypeByPrimaryKey(UserSession userSession, ProductUpdatePriceReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("Start-updateTypeByPrimaryKey(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "])");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        ProductRespDTO productRespDTO = productDAO.selectByPrimaryKey(reqDTO.getProductId());
        if (productRespDTO == null) {
            throw SystemExceptionFactory.nullException();
        }
        ProductUser productUser = productUserDAO.selectForAudit(userSession.getUserId(), reqDTO.getProductId());
        if (productUser == null) {
            throw SystemExceptionFactory.authorityException();
        }
        Product product = new Product();
        product.setProductId(reqDTO.getProductId());
        product.setProductType(reqDTO.getProductType());
        product.setProductUpdatedt(new Date());
        return this.productDAO.updateByPrimaryKeySelective(product);
    }

    @Override
    public int updatePriceByPrimaryKey(UserSession userSession, ProductUpdatePriceReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updatePriceByPrimaryKey(userSession = [" + userSession + "], reqDTO = [" + reqDTO + "]) -start");
        }
        if (userSession == null) {
            throw SystemExceptionFactory.loginException();
        }
        ProductRespDTO productRespDTO = productDAO.selectByPrimaryKey(reqDTO.getProductId());
        if (productRespDTO == null) {
            throw SystemExceptionFactory.nullException();
        }
        ProductUser productUser = productUserDAO.selectForAudit(userSession.getUserId(), reqDTO.getProductId());
        if (productUser == null) {
            throw SystemExceptionFactory.authorityException();
        }
        Product product = new Product();
        product.setProductId(reqDTO.getProductId());
        product.setProductPrice(reqDTO.getProductPrice());
        product.setProductType(reqDTO.getProductType());
        product.setProductStatus(reqDTO.getProductStatus());
        product.setProductUpdatedt(new Date());
        return this.productDAO.updateByPrimaryKeySelective(product);
    }

    @Override
    public int insertSelective(Product record) {
        return this.productDAO.insertSelective(record);
    }

    @Override
    public int submitAudit(UserSession userSession, Integer productId, String saleFlag) {
        ProductApply record = new ProductApply();
        record.setProductId(productId);
        Byte productStatus = 2;
        if ("Y".equals(saleFlag)) {
            productStatus = 3;
        }
        record.setProductStatus(productStatus);
        record.setProductUpdatedt(new Date());
        record.setUserId(userSession.getUserId());
        return this.productApplyDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int submitOnSale(UserSession userSession, Integer productId) {

        ProductApplyRespDTO productApply = this.productApplyDAO.selectByPrimaryKey(productId);
        if (productApply == null) {
            throw SystemExceptionFactory.nullException();
        }
        int i = this.productApplyDAO.callProductApply(productId);
        if (i == SystemExceptionFactory.DB_CALL_FAIL) {
            throw SystemExceptionFactory.callProcedureException();
        }
        return i;
//        Product product = new Product();
//        BeanUtils.copyProperties(productApply, product);
//        productDAO.insertSelective(product);
//        List<ProductDetailApply> productDetailApplyList = this.productDetailApplyDAO.selectByProductId(productId);
//        for (ProductDetailApply detailApply : productDetailApplyList) {
//            ProductDetail productDetail = new ProductDetail();
//            BeanUtils.copyProperties(detailApply, productDetail);
//            this.productDetailDAO.insertSelective(productDetail);
//        }
//        productUserDAO.updateNoOwnerByProductId(product.getProductId());
//        ProductUser record = new ProductUser();
//        record.setProductId(product.getProductId());
//        record.setProductUserIsowner((byte) 1);
//        record.setUserId(userSession.getUserId());
//        record.setProductUserInsertDt(new Date());
//        return productUserDAO.insertSelective(record);
    }
}