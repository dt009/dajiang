package com.dajiang.app.base.controller;

import com.dajiang.app.common.context.StaticContext;
import com.dajiang.app.common.context.UserSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class BaseController {

    /**
     * 功能描述：获取用户session信息
     *
     * @return
     * @author 刘磊
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     * @since 2016年5月23日
     */
    public UserSession getUserSession() {
        return (UserSession) RequestContextHolder.getRequestAttributes().getAttribute(StaticContext.USER_SESSION, RequestAttributes.SCOPE_SESSION);
    }


}