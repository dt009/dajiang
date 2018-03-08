package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.dmo.ProductDetailApply;
import com.dajiang.app.business.po.req.ProductApplyReqDTO;
import com.dajiang.app.business.po.req.ProductUpdatePriceReqDTO;
import com.dajiang.app.common.page.PageReqBean;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MyShopControllerTest extends BaseControllerTest {
    @Test
    public void queryOnSaleProducts() throws Exception {

        PageReqBean<Object> reqDTO = new PageReqBean<>();
        doPostTest(getDJSession(), "/private/myshop/queryOnSaleProducts", reqDTO);
    }

    @Test
    public void queryPreSaleProducts() throws Exception {

        PageReqBean<Byte> reqDTO = new PageReqBean<>();
        reqDTO.setPageNum(1);
        reqDTO.setPageSize(1000);
        doPostTest(getDJSession(), "/private/myshop/querySaveProducts", reqDTO);
    }

    @Test
    public void querySubmitProducts() throws Exception {
    }

    @Test
    public void deletePreSaleProducts() throws Exception {

        doPostTest(getDJSession(), "/private/myshop/deletePreSaleProducts/9", null);
    }

    @Test
    public void submitAudit() throws Exception {
    }

    @Test
    public void savePatentApplyProduct() throws Exception {
        ProductApplyReqDTO reqDTO = new ProductApplyReqDTO();
        reqDTO.setProductAuthorName("周杰伦");
        reqDTO.setProductDesc("方文山作曲");
        reqDTO.setProductType((byte) 1);
        reqDTO.setProductPatentNumber("1293884272");
        reqDTO.setProductPrice(new BigDecimal(1293));
        reqDTO.setProductStatus((byte) 0);
        reqDTO.setProductPatentType((byte) 1);
        reqDTO.setProfessionalTypeId(50);
        reqDTO.setProductTitle("青花瓷");
        ProductDetailApply d1 = new ProductDetailApply();
        d1.setProductDetailTitle("详细说明");
        d1.setProductDetailType(1);
        d1.setProductDetailUrl("www.baidu.com");
        d1.setProductPath("www.baidu.com");
        d1.setProductDetailDesc("初稿真迹");
        ProductDetailApply d2 = new ProductDetailApply();
        d2.setProductDetailTitle("使用说明");
        d2.setProductDetailType(1);
        d2.setProductDetailUrl("www.qq.com");
        d2.setProductPath("www.qq.com");
        d2.setProductDetailDesc("原版真迹");
        ArrayList<ProductDetailApply> detailApplyList = new ArrayList<>();
        detailApplyList.add(d1);
        detailApplyList.add(d2);
        reqDTO.setDetailApplyList(detailApplyList);
        doPostTest(getDJSession(), "/private/myshop/savePatentApplyProduct", reqDTO);
    }

    @Test
    public void updatePatentApplyProduct() throws Exception {
        String json = "{\n" +
                "  \"detailApplyList\": [\n" +
                "    {\n" +
                "      \"productDetailDesc\": \"初稿真迹\",\n" +
                "      \"productDetailTitle\": \"详细说明\",\n" +
                "      \"productDetailType\": 1,\n" +
                "      \"productDetailUrl\": \"www.baidu.com\",\n" +
                "      \"productPath\": \"www.baidu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productDetailDesc\": \"原版真迹\",\n" +
                "      \"productDetailTitle\": \"使用说明\",\n" +
                "      \"productDetailType\": 1,\n" +
                "      \"productDetailUrl\": \"www.qq.com\",\n" +
                "      \"productPath\": \"www.qq.com\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"productAuthorName\": \"周杰伦甄姬\",\n" +
                "  \"productDesc\": \"方文山作曲\",\n" +
                "  \"productPatentNumber\": \"1293884272\",\n" +
                "  \"productPatentType\": 1,\n" +
                "  \"productPrice\": 1293,\n" +
                "  \"productStatus\": 3,\n" +
                "  \"productType\":1,\n" +
                "  \"productTitle\": \"青花瓷\",\n" +
                "  \"professionalTypeId\": 50,\n" +
                "  \"productId\":89\n" +
                "}";
        doPostTest(getDJSession(), "/private/myshop/updatePatentApplyProduct", json);
    }

    @Test
    public void savePictureApplyProduct() throws Exception {
        ProductApplyReqDTO reqDTO = new ProductApplyReqDTO();
        reqDTO.setProductAuthorName("周杰伦");
        reqDTO.setProductDesc("方文山作曲");
        reqDTO.setProductType((byte) 1);
        reqDTO.setProductPrice(new BigDecimal(1293));
        reqDTO.setProductStatus((byte) 0);
        reqDTO.setProductPatentType((byte) 1);
        reqDTO.setProfessionalTypeId(50);
        reqDTO.setProductTitle("青花瓷");
        ProductDetailApply d1 = new ProductDetailApply();
        d1.setProductDetailTitle("详细说明");
        d1.setProductDetailType(6);
        d1.setProductDetailUrl("www.baidu.com");
        d1.setProductPath("www.baidu.com");
        d1.setProductDetailDesc("这里是封面1");
        ProductDetailApply d2 = new ProductDetailApply();
        d2.setProductDetailTitle("使用说明");
        d2.setProductDetailType(6);
        d2.setProductDetailUrl("www.qq.com");
        d2.setProductPath("www.qq.com");
        d2.setProductDetailDesc("这里是封面2");
        ProductDetailApply d3 = new ProductDetailApply();
        d3.setProductDetailTitle("使用说明");
        d3.setProductDetailType(5);
        d3.setProductDetailUrl("www.qq.com");
        d3.setProductPath("www.qq.com");
        d3.setProductDetailDesc("这里是图片说明");
        ArrayList<ProductDetailApply> detailApplyList = new ArrayList<>();
        detailApplyList.add(d1);
        detailApplyList.add(d2);
        detailApplyList.add(d3);
        reqDTO.setDetailApplyList(detailApplyList);
        doPostTest(getDJSession(), "/private/myshop/savePictureApplyProduct", reqDTO);


    }

    @Test
    public void updatePictureApplyProduct() throws Exception {
        doPostTest(getDJSession(), "/private/myshop/updatePictureApplyProduct", "{\n" +
                "  \"detailApplyList\": [\n" +
                "    {\n" +
                "      \"productDetailDesc\": \"这里是封面1\",\n" +
                "      \"productDetailTitle\": \"详细说明\",\n" +
                "      \"productDetailType\": 6,\n" +
                "      \"productDetailUrl\": \"www.baidu.com\",\n" +
                "      \"productPath\": \"www.baidu.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productDetailDesc\": \"这里是封面2\",\n" +
                "      \"productDetailTitle\": \"使用说明\",\n" +
                "      \"productDetailType\": 6,\n" +
                "      \"productDetailUrl\": \"www.qq.com\",\n" +
                "      \"productPath\": \"www.qq.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productDetailDesc\": \"这里是图片\",\n" +
                "      \"productDetailTitle\": \"使用说明\",\n" +
                "      \"productDetailType\": 5,\n" +
                "      \"productDetailUrl\": \"www.qq.com\",\n" +
                "      \"productPath\": \"www.qq.com\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"productAuthorName\": \"周杰伦\",\n" +
                "  \"productDesc\": \"方文山作曲\",\n" +
                "  \"productPrice\": 1293,\n" +
                "  \"productStatus\": 0,\n" +
                "  \"productType\":1,\n" +
                "  \"productTitle\": \"青花瓷\",\n" +
                "  \"professionalTypeId\": 50,\n" +
                "   \"productId\":78\n" +
                "}");

    }

    @Test
    public void saveVideoApplyProduct() throws Exception {
        ProductApplyReqDTO reqDTO = new ProductApplyReqDTO();
        reqDTO.setProductAuthorName("周杰伦");
        reqDTO.setProductDesc("方文山作曲");
        reqDTO.setProductPrice(new BigDecimal(2293));
        reqDTO.setProductStatus((byte) 0);
        reqDTO.setProfessionalTypeId(50);
        reqDTO.setProductTitle("青花瓷");
        reqDTO.setProductType((byte) 1);
        ProductDetailApply d1 = new ProductDetailApply();
        d1.setProductDetailTitle("详细说明");
        d1.setProductDetailType(1);
        d1.setProductDetailUrl("www.baidu.com");
        d1.setProductPath("www.baidu.com");
        d1.setProductDetailDesc("这里是封面1");
        ProductDetailApply d2 = new ProductDetailApply();
        d2.setProductDetailTitle("使用说明");
        d2.setProductDetailType(1);
        d2.setProductDetailUrl("www.qq.com");
        d2.setProductPath("www.qq.com");
        d2.setProductDetailDesc("这里是封面2");
        ProductDetailApply d3 = new ProductDetailApply();
        d3.setProductDetailTitle("使用说明");
        d3.setProductDetailType(1);
        d3.setProductDetailUrl("www.qq.com");
        d3.setProductPath("www.qq.com");
        d3.setProductDetailDesc("这里是图片说明");
        ArrayList<ProductDetailApply> detailApplyList = new ArrayList<>();
        detailApplyList.add(d1);
        detailApplyList.add(d2);
        detailApplyList.add(d3);
        reqDTO.setDetailApplyList(detailApplyList);
        doPostTest(getDJSession(), "/private/myshop/saveVideoApplyProduct", reqDTO);
    }


    @Test
    public void updateVideoApplyProduct() throws Exception {
    }

    @Test
    public void updateProductPrice() throws Exception {
        ProductUpdatePriceReqDTO reqDTO = new ProductUpdatePriceReqDTO();
        reqDTO.setProductId(1);
        reqDTO.setProductPrice(BigDecimal.valueOf(102.11));
        doPostTest(getDJSession(), "/private/myshop/updateProductPrice", reqDTO);
    }


}