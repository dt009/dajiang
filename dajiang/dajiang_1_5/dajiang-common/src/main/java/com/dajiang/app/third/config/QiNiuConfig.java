package com.dajiang.app.third.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("qnConfig")
public class QiNiuConfig {

    @Value("#{qn.ak}")
    private String ak;

    @Value("#{qn.sk}")
    private String sk;

    @Value("#{qn.bucket}")
    private String bucket;

    @Value("#{qn.domain}")
    private String domain;

    protected QiNiuConfig() {
    }


    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
