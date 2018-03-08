package com.dajiang.app.test.controller;

import org.junit.Test;

public class QiNiuControllerTest extends BaseControllerTest {
    @Test
    public void genQiNiuToken() throws Exception {
    }

    @Test
    public void queryDomain() throws Exception {
        doGetTest(null, "/public/qiniu/queryDomain", null);
    }

}