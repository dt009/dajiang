package com.dajiang.app.common.exception;

import com.dajiang.app.common.util.ExceptionType;

public class BaseException extends RuntimeException {

    private ExceptionType exceptionCategory;

    public BaseException() {
    }

    public BaseException(ExceptionType exceptionCategory, String message) {
        super(message);
        this.exceptionCategory = exceptionCategory;
    }

    public BaseException(ExceptionType exceptionCategory, String message, Throwable cause) {
        super(message, cause);
        this.exceptionCategory = exceptionCategory;
    }

    public String toString() {
        return "BaseException{exceptionCategory=" + this.exceptionCategory + '}';
    }

    public ExceptionType getExceptionType() {
        return this.exceptionCategory;
    }

    public void setExceptionType(ExceptionType exceptionCategory) {
        this.exceptionCategory = exceptionCategory;
    }
}