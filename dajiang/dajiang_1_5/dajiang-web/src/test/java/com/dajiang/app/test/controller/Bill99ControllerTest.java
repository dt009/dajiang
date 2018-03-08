package com.dajiang.app.test.controller;

import org.junit.Test;

public class Bill99ControllerTest extends BaseControllerTest {
    @Test
    public void createSign() throws Exception {
        doPostTest(getDJSession(), "/private/bill99/createSign/41", null);
    }

    @Test
    public void callReturn() throws Exception {
        doGetTest(getDJSession(), "/public/bill99/callReturn", "merchantAcctId=120391881");
    }

}