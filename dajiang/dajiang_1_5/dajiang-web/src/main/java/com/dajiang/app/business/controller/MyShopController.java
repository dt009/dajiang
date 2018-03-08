package com.dajiang.app.business.controller;


import com.dajiang.app.base.constants.DictConstants;
import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.po.req.ProductApplyReqDTO;
import com.dajiang.app.business.po.req.ProductUpdatePriceReqDTO;
import com.dajiang.app.business.service.ProductApplyService;
import com.dajiang.app.business.service.ProductService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.page.PageReqBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class MyShopController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MyShopController.class);


    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @Autowired
    @Qualifier("productApplyServiceImpl")
    private ProductApplyService productApplyService;

    /**
     * 查看上架的产品
     */
    @PostMapping("/private/myshop/queryOnSaleProducts")
    @ResponseBody
    public ResponseBaseDTO<Object> queryOnSaleProducts(@RequestBody PageReqBean reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("queryOnSaleProducts(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            reqDTO.setCondition(Arrays.asList(6));
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectOnSaleProducts(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 查看未上架未提交审核的产品
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/private/myshop/querySaveProducts")
    @ResponseBody
    public ResponseBaseDTO<Object> querySaveProducts(@RequestBody PageReqBean reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("querySaveProducts(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            reqDTO.setCondition(Arrays.asList(1));
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectPreSaleProducts(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看审核中的产品
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/private/myshop/querySubmitProducts")
    @ResponseBody
    public ResponseBaseDTO<Object> querySubmitProducts(@RequestBody PageReqBean reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("querySubmitProducts(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            reqDTO.setCondition(Arrays.asList(2, 3));
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectPreSaleProducts(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 查看通过审核尚未上架的商品
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/private/myshop/queryHadAuditProducts")
    @ResponseBody
    public ResponseBaseDTO<Object> queryHadAuditProducts(@RequestBody PageReqBean reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("queryHadAuditProducts(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            reqDTO.setCondition(Arrays.asList(5));
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectOnSaleProducts(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


    /**
     * 预上架产品删除
     */
    @PostMapping("/private/myshop/deletePreSaleProducts/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> deletePreSaleProducts(@PathVariable("productId") Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("deletePreSaleProducts(productId = [" + productId + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.deleteByPrimaryKey(getUserSession(), productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 提交审核
     */
    @PostMapping("/private/myshop/submitAudit/{productId}/{onSaleFlag}")
    @ResponseBody
    public ResponseBaseDTO<Object> submitAudit(@PathVariable("productId") Integer productId, @PathVariable("onSaleFlag") String saleFlag) {
        if (logger.isDebugEnabled()) {
            logger.debug("submitAudit(productId = [" + productId + "], saleFlag = [" + saleFlag + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.submitAudit(getUserSession(), productId, saleFlag));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 提交上架
     */
    @PostMapping("/private/myshop/submitOnSale/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> submitOnSale(@PathVariable("productId") Integer productId) {
        if (logger.isDebugEnabled()) {
            logger.debug("submitOnSale(productId = [" + productId + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.submitOnSale(getUserSession(), productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 保存专利产品
     */
    @PostMapping("/private/myshop/savePatentApplyProduct")
    @ResponseBody
    public ResponseBaseDTO<Object> savePatentApplyProduct(@RequestBody ProductApplyReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("savePatentApplyProduct(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.insertSelective(getUserSession(), reqDTO, DictConstants.PRODUCT_STYLE_PATENT));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "");
        }
    }

    /**
     * 更新专利产品
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/private/myshop/updatePatentApplyProduct")
    @ResponseBody
    public ResponseBaseDTO<Object> updatePatentApplyProduct(@RequestBody ProductApplyReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updatePatentApplyProduct(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            reqDTO.setProductStyle(DictConstants.PRODUCT_STYLE_PATENT);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.updateByPrimaryKey(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 保存图文消息
     */
    @PostMapping("/private/myshop/savePictureApplyProduct")
    @ResponseBody
    public ResponseBaseDTO<Object> savePictureApplyProduct(@RequestBody ProductApplyReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("savePictureApplyProduct(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.insertSelective(getUserSession(), reqDTO, DictConstants.PRODUCT_STYLE_PICTURE));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 更新图文消息
     */
    @PostMapping("/private/myshop/updatePictureApplyProduct")
    @ResponseBody
    public ResponseBaseDTO<Object> updatePictureApplyProduct(@RequestBody ProductApplyReqDTO reqDTO) {
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("Start-updatePictureApplyProduct(reqDTO = [" + reqDTO + "])");
            }
            reqDTO.setProductStyle(DictConstants.PRODUCT_STYLE_PICTURE);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.updateByPrimaryKey(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 保存视频知识
     */
    @PostMapping("/private/myshop/saveVideoApplyProduct")
    @ResponseBody
    public ResponseBaseDTO<Object> saveVideoApplyProduct(@RequestBody ProductApplyReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("saveVideoApplyProduct(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.insertSelective(getUserSession(), reqDTO, DictConstants.PRODUCT_STYLE_VIDEO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     * 更新视频知识
     */
    @PostMapping("/private/myshop/updateVideoApplyProduct")
    @ResponseBody
    public ResponseBaseDTO<Object> updateVideoApplyProduct(@RequestBody ProductApplyReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateVideoApplyProduct(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            reqDTO.setProductStyle(DictConstants.PRODUCT_STYLE_VIDEO);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.updateByPrimaryKey(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    @PostMapping("/private/myshop/updateOnSaleProductPrice")
    @ResponseBody
    public ResponseBaseDTO<Object> updateOnSaleProductPrice(@RequestBody ProductUpdatePriceReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateOnSaleProductPrice(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.updatePriceByPrimaryKey(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    @PostMapping("/private/myshop/updateOnSaleProductType")
    @ResponseBody
    public ResponseBaseDTO<Object> updateOnSaleProductType(@RequestBody ProductUpdatePriceReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateOnSaleProductType(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.updateTypeByPrimaryKey(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    @PostMapping("/private/myshop/updateOffSaleProductPrice")
    @ResponseBody
    public ResponseBaseDTO<Object> updateOffSaleProductPrice(@RequestBody ProductUpdatePriceReqDTO reqDTO) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateOffSaleProductPrice(reqDTO = [" + reqDTO + "]) -start");
        }
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productApplyService.updatePriceByPrimaryKey(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }


}
