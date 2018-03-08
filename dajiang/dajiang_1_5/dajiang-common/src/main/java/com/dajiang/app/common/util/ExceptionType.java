package com.dajiang.app.common.util;

public enum ExceptionType {
    System_DB,

    SYSTEM_ILLEGAL_USER,
    SYSTEM_ILLEGAL_PASSWD,
    SYSTEM_ILLEGAL_VC,
    SYSTEM_UNKNOWN,

    Business_Update,
    Business_Query,
    Business_Delete,
    Business_Insert,
    Business_Privilege,
    File_Upload,
    Illegal_Parameter,
    FILE_NOT_FOUND,
    FILE_PARSE_FAIL,
    FILE_WRITE_FAIL,
    NET_RESPONSE_NO_OK,
    NET_IO_EXCEPTION,
    RPT_NOT_FOUND;

    private ExceptionType() {
    }
}