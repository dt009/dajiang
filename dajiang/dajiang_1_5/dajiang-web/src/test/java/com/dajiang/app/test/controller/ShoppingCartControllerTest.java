package com.dajiang.app.test.controller;

import org.junit.Test;

public class ShoppingCartControllerTest extends BaseControllerTest {
    @Test
    public void saveShoppingCart() throws Exception {
    }

    @Test
    public void deleteShoppingCart() throws Exception {
    }

    @Test
    public void queryList() throws Exception {

        doPostTest(getDJSession(), "/private/shoppingCart/queryList", "{\n" +
                "\t\"pageNum\":1,\n" +
                "\t\"pageSize\":10\n" +
                "}");
    }

}