package com.dajiang.app.base.po.dmo;

public class ResponseBaseDTO<T> extends BaseDTO {
    private static final long serialVersionUID = -2188900748156226155L;

    public static final Integer FLAG_SUCC = new Integer(1);
    public static final String MSG_SUCC = "操作成功。";
    public static final Integer FLAG_FAIL = new Integer(0);
    public static final String MSG_FAIL = "服务端发生未知错误。";

    private Integer flag;
    private String message;
    private T data;

    public ResponseBaseDTO() {
        this(FLAG_SUCC, "");
    }

    public ResponseBaseDTO(Integer flag) {
        this.flag = flag;
        if (FLAG_SUCC.equals(flag)) {
            this.message = MSG_SUCC;
        } else if (FLAG_FAIL.equals(flag)) {
            this.message = MSG_FAIL;
        }
    }

    public ResponseBaseDTO(Integer flag, T data) {
        this(flag);
        this.data = data;
    }

    public ResponseBaseDTO(Integer flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public ResponseBaseDTO(Integer flag, String message, T data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
