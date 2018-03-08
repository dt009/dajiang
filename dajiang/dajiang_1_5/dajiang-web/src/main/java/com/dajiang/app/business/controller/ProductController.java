package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.service.ProductService;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;

    /**
     * 商品详情
     */
    @RequestMapping("/public/product/queryProductById/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> queryProductById(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, productService.selectByPrimaryKey(productId));
        } catch (BaseException e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }
}
