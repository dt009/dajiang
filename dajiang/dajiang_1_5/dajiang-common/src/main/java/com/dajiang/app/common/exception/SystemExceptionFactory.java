package com.dajiang.app.common.exception;

import com.dajiang.app.common.util.ExceptionType;

public class SystemExceptionFactory {

    public static final int DB_CALL_FAIL = -1;


    public static final BaseException callProcedureException() {
        return new BaseException(ExceptionType.Business_Insert, "调用存储过程失败。");
    }

    public static final BaseException loginException() {
        return new BaseException(ExceptionType.SYSTEM_ILLEGAL_USER, "登录已失效，请重新登录。");
    }


    public static final BaseException nullException() {
        return new BaseException(ExceptionType.Business_Query, "无对应记录。");
    }


    public static final BaseException authorityException() {
        return new BaseException(ExceptionType.Business_Privilege, "无权限操作该数据。");
    }

    public static final BaseException keyException() {
        return new BaseException(ExceptionType.Business_Privilege, "关键字段不能为空。");
    }

}
