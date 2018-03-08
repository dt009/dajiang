package com.dajiang.app.third.controller;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.doc.DocClient;
import com.baidubce.services.doc.model.ReadDocumentResponse;
import com.dajiang.app.base.po.dmo.ResponseBaseDTO;
import com.dajiang.app.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class BceController {

    private static final Logger logger = LoggerFactory.getLogger(BceController.class);

    private String AK = "12559d3511774ea6b840dfed77aea1f5";
    private String SK = "8d8db671bad341e09cc77a71c8a227eb";
    private String ENDPOINT = "http://doc.bj.baidubce.com";
    private static String UTF8 = "utf-8";


    /**
     *
     */
    @RequestMapping("/public/bce/createSignature")
    @ResponseBody
    public ResponseBaseDTO<Object> createSignature(@RequestBody Object reqDTO) {
        try {
            BceClientConfiguration config = new BceClientConfiguration();
            config.setCredentials(new DefaultBceCredentials(AK, SK));
            config.setEndpoint(ENDPOINT);
            DocClient client = new DocClient(config);
            client.createDocument(null);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, "");
        } catch (BaseException e) {
            logger.error("/bce/：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/bce/：" + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, "");
        }
    }

    /**
     * @param reqDTO
     * @return
     */
    @RequestMapping("/public/bce/queryAuth")
    @ResponseBody
    public ResponseBaseDTO<Object> queryAuth(@RequestBody Map<String, String> reqDTO) {
        try {
            String docId = reqDTO.get("docId");
            BceClientConfiguration config = new BceClientConfiguration();
            config.setCredentials(new DefaultBceCredentials(AK, SK));
            config.setEndpoint(ENDPOINT);
            DocClient client = new DocClient(config);
            ReadDocumentResponse resp = client.readDocument(docId);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_SUCC, resp.getToken());
        } catch (BaseException e) {
            logger.error("/public/bce/queryAuth: " + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL, e.getMessage());
        } catch (Exception e) {
            logger.error("/public/bce/queryAuth: " + e.getMessage(), e);
            return new ResponseBaseDTO<>(ResponseBaseDTO.FLAG_FAIL);
        }
    }
}
