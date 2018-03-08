package com.dajiang.app.third.controller;

import com.dajiang.app.base.controller.BaseController;
import com.dajiang.app.third.config.QiNiuConfig;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joe on 2017/9/25.
 */
@RestController
public class QiNiuController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(QiNiuController.class);

    @Resource(name = "qnConfig")
    private QiNiuConfig qiNiuConfig;

    /**
     *
     */
    @GetMapping(value = {"/public/qiniu/genQiNiuToken", "/private/qiniu/genQiNiuToken"})
    @ResponseBody
    public Object genQiNiuToken() {
        StringMap policy = new StringMap();
        policy.put("mimeLimit", "image/*");
        String x = Auth.create(qiNiuConfig.getAk(), qiNiuConfig.getSk()).uploadToken(qiNiuConfig.getBucket(), null, 3600L, policy);
        Map<String, String> result = new HashMap<>();
        result.put("uptoken", x);
        return result;
    }

    @GetMapping(value = "/public/qiniu/queryDomain")
    @ResponseBody
    public Object queryDomain() {
        Map<String, String> result = new HashMap<>();

//        owu66z9w4.bkt.clouddn.com  joe
//        oz11qv7pq.bkt.clouddn.com  dj
        result.put("domain", qiNiuConfig.getDomain());
        return result;
    }


//    public static void main(String[] args) {
//        String x = Auth.create("FrSg77I3YjZVaYgHrQTDGvHh58PSV2INVi3TXjnC", "GQMHn1JnvqpeibEBijuHM5v6iSMeY5Ke79LGt_-J").uploadToken("joe-app");
//        System.out.println(x);
//    }


}
