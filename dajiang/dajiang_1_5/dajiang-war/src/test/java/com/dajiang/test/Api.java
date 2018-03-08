package com.dajiang.test;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Api {
    public static void main(String[] args) {
        Api api = new Api();
        String httpResponse = api.testSend();
        try {
            JSONObject jsonObj = JSONObject.parseObject(httpResponse);
            int error_code = jsonObj.getIntValue("error");
            String error_msg = jsonObj.getString("msg");
            if (error_code == 0) {
                System.out.println("Send message success.");
            } else {
                System.out.println("Send message failed,code is " + error_code + ",msg is " + error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, ex);
        }

        httpResponse = api.testStatus();
        try {
            JSONObject jsonObj = JSONObject.parseObject(httpResponse);
            int error_code = jsonObj.getIntValue("error");
            if (error_code == 0) {
                int deposit = jsonObj.getIntValue("deposit");
                System.out.println("Fetch deposit success :" + deposit);
            } else {
                String error_msg = jsonObj.getString("msg");
                System.out.println("Fetch deposit failed,code is " + error_code + ",msg is " + error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private String testSend() {
        // just replace key here
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api", "key-9b128f88bddd9ea8a508aeab5d8ff75c"));
        WebResource webResource = client.resource(
                "http://sms-api.luosimao.com/v1/send.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", "18600952984");
        formData.add("message", "验证码：286221 【大匠】");
        ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        //System.out.print(textEntity);
        //System.out.print(status);
        return textEntity;
    }

    private String testStatus() {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api", "key-9b128f88bddd9ea8a508aeab5d8ff75c"));
        WebResource webResource = client.resource("http://sms-api.luosimao.com/v1/status.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        ClientResponse response = webResource.get(ClientResponse.class);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        return textEntity;
    }
}