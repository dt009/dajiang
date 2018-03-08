package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

/**
 * Created by Joe on 2017/9/20.
 */
public class RegisterReqDTO extends BaseDTO {

    private String userPhone;

    private String vertifCode;

    private String password;

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
}
