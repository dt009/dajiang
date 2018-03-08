package com.dajiang.app.business.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.business.service.ShoppingCartService;
import com.dajiang.app.common.exception.BaseException;
import com.dajiang.app.common.page.PageReqBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCartController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    @Qualifier("shoppingCartServiceImpl")
    private ShoppingCartService shoppingCartService;

    /**
     * 保存商品到购物车
     */
    @PostMapping("/private/shoppingCart/saveShoppingCart/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> saveShoppingCart(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, shoppingCartService.insertSelective(getUserSession(), productId));
        } catch (BaseException e) {
            logger.error("/private/shoppingCart/saveShoppingCart：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/shoppingCart/saveShoppingCart：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     *
     */
    @RequestMapping("/private/shoppingCart/deleteShoppingCart/{productId}")
    @ResponseBody
    public ResponseBaseDTO<Object> deleteShoppingCart(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, shoppingCartService.deleteByProductId(getUserSession(), productId));
        } catch (BaseException e) {
            logger.error("/private/shoppingCart/deleteShoppingCart：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/shoppingCart/deleteShoppingCart：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

    /**
     *
     */
    @RequestMapping("/private/shoppingCart/queryList")
    @ResponseBody
    public ResponseBaseDTO<Object> queryList(@RequestBody PageReqBean reqDTO) {
        try {
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, shoppingCartService.selectList(getUserSession(), reqDTO));
        } catch (BaseException e) {
            logger.error("/private/shoppingCart/queryList：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/private/shoppingCart/queryList：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }

}
