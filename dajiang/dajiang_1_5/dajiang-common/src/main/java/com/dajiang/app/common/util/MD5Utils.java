package com.dajiang.app.common.util;

import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class MD5Utils {
    private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    public static String generate(Object... str) {
        StringBuffer generate = new StringBuffer();
        for (Object s : str) {
            generate.append(s);
        }
        return md5(generate.toString());
    }

    /**
     * @param md5 md5字符串
     * @param str 待转换成md5的字符串
     * @return
     */
    public static boolean verify(String md5, Object... str) {
        String generate = generate(str);
        return generate.equals(md5);
    }

    private static String md5(String keyStr) {
        MessageDigest digestObj = null;

        try {
            digestObj = MessageDigest.getInstance("MD5");
        } catch (Exception var5) {
            throw new BaseException(ExceptionType.SYSTEM_UNKNOWN, "MD5 is not supported!");
        }

        byte[] digest = digestObj.digest(keyStr.getBytes(Charset.forName("UTF-8")));
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < digest.length; ++i) {
            sb.append(Integer.toString((digest[i] & 255) + 256, 16).substring(1));
        }

        logger.info("The orginal key {}, md5 key {}", keyStr, sb.toString());
        return sb.toString();
    }

}