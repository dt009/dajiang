package com.dajiang.app.kuaiqian.util;

public class ParamUtils {
    public static String appendParam(String returns, String paramId, String paramValue) {
        if (returns != "") {
            if (paramValue != "") {

                returns += "&" + paramId + "=" + paramValue;
            }

        } else {

            if (paramValue != "") {
                returns = paramId + "=" + paramValue;
            }
        }

        return returns;
    }

}
