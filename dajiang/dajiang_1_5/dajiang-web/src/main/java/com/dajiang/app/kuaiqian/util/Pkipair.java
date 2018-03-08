package com.dajiang.app.kuaiqian.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;


public class Pkipair {

    private static final Logger logger = LoggerFactory.getLogger(Pkipair.class);

    public String signMsg(String signMsg) {

        String base64 = "";
        try {
            // 密钥仓库
            KeyStore ks = KeyStore.getInstance("PKCS12");

            // 读取密钥仓库
//			FileInputStream ksfis = new FileInputStream("e:/tester-rsa.pfx");

            // 读取密钥仓库（相对路径）
            String file = Pkipair.class.getClassLoader().getResource("").getPath() + "kuaiqian" + File.separator + "99bill-rsa.pfx";
            logger.info("rsa.pfx.file={}", file);

            FileInputStream ksfis = new FileInputStream(file);

            BufferedInputStream ksbufin = new BufferedInputStream(ksfis);

            char[] keyPwd = "vpos123".toCharArray();
            //char[] keyPwd = "YaoJiaNiLOVE999Year".toCharArray();
            ks.load(ksbufin, keyPwd);
            // 从密钥仓库得到私钥
            PrivateKey priK = (PrivateKey) ks.getKey("test-alias", keyPwd);
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initSign(priK);
            signature.update(signMsg.getBytes("utf-8"));
            sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
            base64 = encoder.encode(signature.sign());

        } catch (FileNotFoundException e) {
            System.out.println("文件找不到");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("test = " + base64);
        return base64;
    }

    public boolean enCodeByCer(String val, String msg) {
        boolean flag = false;
        try {

            //获得文件(相对路径)
//            String file = Pkipair.class.getResource("99bill[1].cert.rsa.20140803.cer").toURI().getPath();
            String file = Pkipair.class.getClassLoader().getResource("").getPath() + "kuaiqian" + File.separator + "99bill.cert.rsa.20340630.cer";
            logger.info("rsa.cer.file={}", file);
            FileInputStream inStream = new FileInputStream(file);

            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
            //获得公钥
            PublicKey pk = cert.getPublicKey();
            //签名
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(pk);
            signature.update(val.getBytes());
            //解码
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            System.out.println(new String(decoder.decodeBuffer(msg)));
            flag = signature.verify(decoder.decodeBuffer(msg));
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no");
        }
        return flag;
    }
}
