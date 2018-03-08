package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.req.CKOQueryReqDTO;
import com.dajiang.app.business.po.req.ProductQueryReqDTO;
import com.dajiang.app.business.po.req.ProfessionalQueryReqDTO;
import com.dajiang.app.common.page.PageReqBean;
import org.junit.Test;

import java.util.Arrays;

public class HomePageControllerTest extends BaseControllerTest {
    @Test
    public void initBanner() throws Exception {

        doGetTest(null, "/public/banner/initBanners", null);

    }

    @Test
    public void initProfessionalList() throws Exception {

        doGetTest(null, "/public/professional/initProfessionals", null);
    }

    @Test
    public void initProductList() throws Exception {
        doGetTest(null, "/public/product/initProducts", null);

    }


    @Test
    public void queryMoreProfessionals() throws Exception {

        PageReqBean<ProfessionalQueryReqDTO> reqDTO = new PageReqBean<>();
        ProfessionalQueryReqDTO condition = new ProfessionalQueryReqDTO();
        condition.setRegionIds(Arrays.asList(50));
        condition.setProfessionalTypeIds(Arrays.asList(1));
        reqDTO.setCondition(condition);
        doPostTest(getDJSession(), "/public/professional/queryMoreProfessionals", reqDTO);

    }

    @Test
    public void queryProfessionalById() throws Exception {

        doPostTest(getDJSession(), "/public/professional/queryProfessionalById/3", null);

    }

    @Test
    public void queryProductByProfessionalId() throws Exception {
        doPostTest(null, "/public/product/queryProductByProfessionalId/9/1", "{\n" +
                "  \"pageNum\": 1,\n" +
                "  \"pageSize\": 10\n" +
                "}");
    }

    @Test
    public void queryMoreProducts() throws Exception {

        PageReqBean<ProductQueryReqDTO> reqDTO = new PageReqBean<>();
        ProductQueryReqDTO condition = new ProductQueryReqDTO();
        condition.setMaxPrice(null);
        condition.setMinPrice(null);
        condition.setProductStyles(Arrays.asList(Byte.valueOf("1")));
        reqDTO.setCondition(condition);
//        String reqDTO = "{\"condition\":{\"maxPrice\":0,\"minPrice\":1000.20,\"productTypes\":[1]},\"pageNum\":1,\"pageSize\":10}";
        doPostTest(getDJSession(), "/public/product/queryMoreProducts", reqDTO);

    }

    @Test
    public void queryMoreCKO() throws Exception {

        PageReqBean<CKOQueryReqDTO> reqDTO = new PageReqBean<>();
        CKOQueryReqDTO condition = new CKOQueryReqDTO();
        condition.setKeyWord("有情");
        reqDTO.setCondition(condition);
        doPostTest(getDJSession(), "/public/cko/queryMoreCkos", reqDTO);

    }

    @Test
    public void queryProductByCkoId() throws Exception {
        PageReqBean reqBean = new PageReqBean();
        doPostTest(getDJSession(), "/public/product/queryProductByCkoId/9/1", reqBean);
    }

    @Test
    public void initPatentInfo() throws Exception {

        doPostTest(getDJSession(), "/public/product/initPatentInfo/2", null);
    }

    @Test
    public void initApplyPatentInfo() throws Exception {

        doPostTest(getDJSession(), "/public/product/initApplyPatentInfo/7", null);
    }
}