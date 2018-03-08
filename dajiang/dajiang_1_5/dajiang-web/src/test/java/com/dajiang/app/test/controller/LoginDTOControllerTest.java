package com.dajiang.app.test.controller;

import com.dajiang.app.base.po.dmo.LoginDTO;
import org.junit.Test;

/**
 * Created by Joe on 2017/9/11.
 */
public class LoginDTOControllerTest extends BaseControllerTest {
    @Test
    public void query() throws Exception {
        LoginDTO reqDTO = new LoginDTO();
        reqDTO.setLoginName("15630302315");
        reqDTO.setLoginPasswd("zhou1008");
        doPostTest(null, "/login", reqDTO);
    }

}