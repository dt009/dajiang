package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * Created by Joe on 2017/9/21.
 */
public class PasswordResetReqDTO extends BaseDTO {

    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 验证码
     */
    private String vertifCode;
    /**
     * 密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String confirmPWD;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getVertifCode() {
        return vertifCode;
    }

    public void setVertifCode(String vertifCode) {
        this.vertifCode = vertifCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPWD() {
        return confirmPWD;
    }

    public void setConfirmPWD(String confirmPWD) {
        this.confirmPWD = confirmPWD;
    }
}
