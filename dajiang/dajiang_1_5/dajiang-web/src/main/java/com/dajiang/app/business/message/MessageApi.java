package com.dajiang.app.business.message;

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


public class MessageApi {

    private static final String key = "key-9b128f88bddd9ea8a508aeab5d8ff75c";
    private static final String send_url = "http://sms-api.luosimao.com/v1/send.json";
    private static final String status_url = "http://sms-api.luosimao.com/v1/status.json";

    /**
     * @param mobile
     * @param content
     * @return 0:发送成功,其他发送失败。
     */
    public static int sendMsg(String mobile, String content) {
        MessageApi messageApi = new MessageApi();
        String httpResponse = messageApi.send(mobile, content);
        try {
            JSONObject jsonObj = JSONObject.parseObject(httpResponse);
            int error_code = jsonObj.getIntValue("error");
            String error_msg = jsonObj.getString("msg");
            if (error_code == 0) {
                System.out.println("Send message success.");
            } else {
                System.out.println("Send message failed,code is " + error_code + ",msg is " + error_msg);
            }
            return error_code;
        } catch (JSONException ex) {
            Logger.getLogger(MessageApi.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    private String send(String mobile, String msg) {
        // just replace key here
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api", key));
        WebResource webResource = client.resource(send_url);
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", mobile);
        formData.add("message", msg + " 【大匠】");
        ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        //System.out.print(textEntity);
        //System.out.print(status);
        return textEntity;
    }

//    private String queryStatus() {
//        Client client = Client.create();
//        client.addFilter(new HTTPBasicAuthFilter("api", key));
//        WebResource webResource = client.resource(status_url);
//        MultivaluedMapImpl formData = new MultivaluedMapImpl();
//        ClientResponse response = webResource.get(ClientResponse.class);
//        String textEntity = response.getEntity(String.class);
//        int status = response.getStatus();
//        return textEntity;
//    }
}