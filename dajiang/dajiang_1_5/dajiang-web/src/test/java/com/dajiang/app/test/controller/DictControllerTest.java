package com.dajiang.app.test.controller;

import org.junit.Test;

/**
 * Created by Joe on 2017/9/26.
 */
public class DictControllerTest extends BaseControllerTest {
    @Test
    public void initProfessionalType() throws Exception {
        doGetTest(getDJSession(), "/public/professionalType/queryByPid/0");
    }

    @Test
    public void initDict() throws Exception {
        doGetTest(getDJSession(), "/public/dict/queryDegreeCode");
    }

    @Test
    public void feedback() throws Exception {
        doGetTest(getDJSession(), "/public/region/queryByPid/0");
    }

}
