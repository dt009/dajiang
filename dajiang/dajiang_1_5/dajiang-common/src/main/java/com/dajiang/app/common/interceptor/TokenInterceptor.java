package com.dajiang.app.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.common.context.StaticContext;
import com.dajiang.app.common.context.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * token 拦截器验证
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
    // redis 存储的有效时间 单位是秒
    private final int ttl = 600;
    @Qualifier("stringRedisTemplate")
    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @SuppressWarnings("deprecation")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        RequestWrapper requestWrapper = new RequestWrapper(request);
//        String body = requestWrapper.getBody();
//        JSONObject json = JSONObject.parseObject(body);
//        if (json == null) {
//            return false;
//        }
        // 获取userId
        Object attribute = RequestContextHolder.getRequestAttributes().getAttribute(StaticContext.USER_SESSION, RequestAttributes.SCOPE_SESSION);
        if (attribute == null) {
            response.setStatus(401, "userId is null");
            responseWithJson(response, new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "401: userId is null"));
            return false;
        }
        UserSession userSession = (UserSession) attribute;
        Long userId = userSession.getUserId();
        if (userId == null) {
            response.setStatus(401, "userId is null");
            responseWithJson(response, new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "401: userId is null"));
            return false;
        }


//        // 获取token
//        String token = request.getHeader("x-token");
//        if (StringUtils.isBlank(token)) {
//            response.setStatus(401, "token is null");
//            responseWithJson(response, new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "401: token is null"));
//            return false;
//        }
//        // 根据userId从redis获取token
//        String rt = stringRedisTemplate.opsForValue().get(userId + "");
//        if (StringUtils.isBlank(rt)) {
//            response.setStatus(401, "token expired");
//            responseWithJson(response, new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "401: token expired"));
//
//            return false;
//        }
//        // 判断token是否相等
//        if (!rt.equals(token)) {
//            response.setStatus(401, "token validate fail");
//            responseWithJson(response, new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "401: token validate fail"));
//            return false;
//        }
//        // 更新数据库中token的有效时间
//        stringRedisTemplate.opsForValue().set(userId + "", token, ttl, TimeUnit.SECONDS);
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex)
            throws Exception {
    }

    private void responseWithJson(HttpServletResponse response, Object responseObject) {
        if (logger.isDebugEnabled()) {
            logger.debug("responseOutWithJson(response = [" + response + "], responseObject = [" + responseObject + "]) -start");
        }
        //将实体对象转换为JSON Object转换
        String json = JSONObject.toJSONString(responseObject);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}