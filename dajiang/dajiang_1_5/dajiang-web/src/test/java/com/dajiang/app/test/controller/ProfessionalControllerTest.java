package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.req.ProfessionalReqDTO;
import org.junit.Test;

public class ProfessionalControllerTest extends BaseControllerTest {
    @Test
    public void initProfess() throws Exception {
        doPostTest(getDJSession(), "/private/professional/initProfess", null);
    }

    @Test
    public void sendProfVertif() throws Exception {
        ProfessionalReqDTO reqDTO = new ProfessionalReqDTO();
        String json = "{\n" +
                "  \"professionalId\":1,\n" +
                "  \"professionalBirth\": 466012800000,\n" +
                "  \"professionalEmail\": \"zhoutest@126.com\",\n" +
                "  \"professionalField\": \"建材管理\",\n" +
                "  \"professionalGender\": 1,\n" +
                "  \"professionalHighEduc\": 7,\n" +
                "  \"professionalIdBack\": \"\",\n" +
                "  \"professionalIdFront\": \"\",\n" +
                "  \"professionalIdcard\": \"130401198702027687\",\n" +
                "  \"professionalIntroduction\": \"test update. but 2.\",\n" +
                "  \"professionalName\": \"周树人\",\n" +
                "  \"professionalPhone\": \"18610002222\",\n" +
                "  \"professionalPosition\": \"总监\",\n" +
                "  \"professionalTypeId\": 32,\n" +
                "  \"professionalWorkdt\": 1262275200000,\n" +
                "  \"professionalWorkunit\": \"zs.ltd\",\n" +
                "  \"regionId\": 51\n" +
                "}";
        doPostTest(getDJSession(), "/private/professional/sendProfVertif", json);
    }


}