package com.dajiang.app.test.controller;


import com.dajiang.app.common.context.StaticContext;
import com.dajiang.app.common.context.UserSession;
import com.dajing.app.base.test.CommonControllerTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath*:/applicationContext.xml", "classpath*:/spring-mvc-servlet.xml"})
public class BaseControllerTest extends CommonControllerTest {

    public MockHttpSession getNullSession() {
        MockHttpSession mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute(StaticContext.USER_SESSION, null);
        return mockHttpSession;
    }

    public MockHttpSession getDJSession() {
        MockHttpSession mockHttpSession = new MockHttpSession();
        UserSession userSession = new UserSession();
        userSession.setLoginId(9L);
        userSession.setUserId(5L);
        mockHttpSession.setAttribute(StaticContext.USER_SESSION, userSession);
        return mockHttpSession;
    }
}
