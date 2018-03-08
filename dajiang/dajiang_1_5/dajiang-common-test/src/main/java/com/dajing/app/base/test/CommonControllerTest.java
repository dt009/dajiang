package com.dajing.app.base.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CommonControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(CommonControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();//获取mockMvc实例
    }

    public MvcResult doPostTest(MockHttpSession session, String url, Object reqDTO) throws Exception {
        String content = null;
        if (reqDTO != null) {
            content = JSON.toJSONString(reqDTO);
        }
        return doPostTest(session, url, content);
    }

    public MvcResult doPostTest(MockHttpSession session, String url, String json) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("doPostTest(session = [" + session + "], url = [" + url + "], json = [" + json + "]) -start");
        }
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON);
        if (json != null) {
            mockHttpServletRequestBuilder.content(json);
        }
        if (session != null) {
            mockHttpServletRequestBuilder.session(session);
        }
        MvcResult result = getMockMvc().perform(mockHttpServletRequestBuilder)//执行一个RequestBuilder请求
                .andDo(CustomerMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        return result;
    }


    public MvcResult doGetTest(MockHttpSession session, String url, String... kv) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("doGetTest(session = [" + session + "], url = [" + url + "], kv = [" + kv + "]) -start");
        }
        if (kv != null) {
            url = url + "?" + StringUtils.join(kv, "&");
        }
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);
        if (session != null) {
            mockHttpServletRequestBuilder.session(session);
        }
        MvcResult result = getMockMvc().perform(mockHttpServletRequestBuilder)//执行一个RequestBuilder请求
                .andDo(CustomerMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        return result;
    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }

    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
}
