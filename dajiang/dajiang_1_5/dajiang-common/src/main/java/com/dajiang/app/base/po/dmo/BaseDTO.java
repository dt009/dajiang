package com.dajiang.app.base.po.dmo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BaseDTO implements Serializable {
    private static final long serialVersionUID = -2413430183195318201L;

    public BaseDTO() {
    }

    public String toString() {
        String result;
        try {
            result = JSON.toJSONString(this);
            return result.length() > 1000 ? result.substring(0, 999) : result;
        } catch (Throwable var3) {
            return "FAIL_FORMAT_JSON";
        }
    }

}
