package com.dajiang.app.test.controller;

import com.dajiang.app.business.po.dmo.ProfessionalApply;
import com.dajiang.app.business.po.req.RegisterReqDTO;
import com.dajiang.app.business.po.req.VerificationReqDTO;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Joe on 2017/9/11.
 */
public class UserControllerTest extends BaseControllerTest {


    @Test
    public void register() throws Exception {
        RegisterReqDTO reqDTO = new RegisterReqDTO();
        reqDTO.setUserPhone("15630302315");
        reqDTO.setPassword("zhou1008");
        reqDTO.setVertifCode("896691");
        doPostTest(null, "/user/register", reqDTO);
    }

    @Test
    public void sendVerificationCode() throws Exception {

        VerificationReqDTO reqDTO = new VerificationReqDTO();
        reqDTO.setUserPhone("15630302315");
        for (int i = 0; i < 10; i++) {
            doPostTest(null, "/public/user/sendVerificationCode", reqDTO);
            TimeUnit.SECONDS.sleep(2);
        }
    }

    @Test
    public void sendBeCKOVertif() throws Exception {

        String json = "{\n" +
                "    \"ckoApplyEmail\": \"test@126.com\",\n" +
                "    \"ckoIdBack\": \"xxxx\",\n" +
                "    \"ckoIdFront\": \"xxxx\",\n" +
                "    \"ckoIdcard\": \"130421198102112123\",\n" +
                "    \"ckoIscertification\": 1,\n" +
                "    \"ckoIssearch\": 1,\n" +
                "    \"ckoName\": \"周文冬\",\n" +
                "    \"ckoNickname\": \"joe\",\n" +
                "    \"regionId\": 40,\n" +
                "    \"userId\": 1\n" +
                "}";
        doPostTest(getDJSession(), "/private/user/sendBeCKOVertif", json);
    }

    @Test
    public void sendBeProfVerif() throws Exception {
        ProfessionalApply reqDTO = new ProfessionalApply();
        reqDTO.setProfessionalName("周山人");
        reqDTO.setProfessionalBirth(DateUtils.parseDate("1984-10-08", "yyyy-MM-dd"));
        reqDTO.setProfessionalGender(Byte.valueOf("1"));
        reqDTO.setProfessionalPhone("18610002222");
        reqDTO.setProfessionalWorkunit("zs.ltd");
        reqDTO.setProfessionalPosition("总监");
        reqDTO.setProfessionalIdcard("130401198702027687");
        reqDTO.setRegionId(51);
        reqDTO.setProfessionalField("建材管理");
        reqDTO.setProfessionalHighEduc(Byte.valueOf("7"));
        reqDTO.setProfessionalWorkdt(DateUtils.parseDate("2010-01-01", "yyyy-MM-dd"));
        reqDTO.setProfessionalEmail("zhoutest@126.com");
        reqDTO.setProfessionalTypeId(32);
        reqDTO.setProfessionalIntroduction("this is a test.");
        reqDTO.setProfessionalIdFront("");
        reqDTO.setProfessionalIdBack("");
        reqDTO.setQualificationPicList(Arrays.asList("qual add 1", "qual add 2"));
        reqDTO.setCertificatePicList(Arrays.asList("cert add 1", "cert add 2"));
        reqDTO.setOtherPicList(Arrays.asList("other add 1", "other add 2"));
        doPostTest(getDJSession(), "/private/user/sendBeProfVerif", reqDTO);
    }


    @Test
    public void resetPassword() throws Exception {

    }

    @Test
    public void editPassword() throws Exception {

    }

    @Test
    public void feedback() throws Exception {

    }

    @Test
    public void initUserInfo() throws Exception {

        doGetTest(null, "/private/user/initUserInfo/1");
    }


}