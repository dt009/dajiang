package com.dajiang.app.third.util;

import com.baidubce.BceClientConfiguration;
import com.baidubce.BceClientException;
import com.baidubce.auth.BceCredentials;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.auth.SignOptions;
import com.baidubce.http.Headers;
import com.baidubce.http.HttpMethodName;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.services.doc.DocClient;
import com.baidubce.services.doc.model.ReadDocumentResponse;
import com.baidubce.util.DateUtils;
import com.baidubce.util.HttpUtils;
import com.baidubce.util.JsonUtils;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

public class V1Signer {

    private static final Logger logger = LoggerFactory.getLogger(V1Signer.class);

    private static final String BCE_AUTH_VERSION = "bce-auth-v1";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Charset UTF8 = Charset.forName(DEFAULT_ENCODING);

    // Default headers to sign with the BCE signing protocol.
    private static final Set<String> defaultHeadersToSign = Sets.newHashSet();
    private static final Joiner headerJoiner = Joiner.on('\n');
    private static final Joiner signedHeaderStringJoiner = Joiner.on(';');
    /**
     * The version information for Document service APIs as URI prefix.
     */
    private static final String VERSION = "v2";

    public static final String DEFAULT_CONTENT_TYPE = "application/json; charset=utf-8";


    /**
     * The common URI prefix for doc services.
     */
    private static final String DOC = "document";

    /**
     * The common URI prefix for notification services.
     */
    private static final String NOTIFICATION = "notification";

    static {
        V1Signer.defaultHeadersToSign.add(Headers.HOST.toLowerCase());
        V1Signer.defaultHeadersToSign.add(Headers.CONTENT_LENGTH.toLowerCase());
        V1Signer.defaultHeadersToSign.add(Headers.CONTENT_TYPE.toLowerCase());
        V1Signer.defaultHeadersToSign.add(Headers.CONTENT_MD5.toLowerCase());
    }

    /**
     * Sign the given request with the given set of credentials. Modifies the passed-in request to apply the signature.
     *
     * @param credentials the credentials to sign the request with.
     */
    public String sign(String uriStr, String accessKeyId, String secretAccessKey) {

        List<String> pathComponents = new ArrayList<String>();
        pathComponents.add(VERSION);
        URI baseUri = URI.create(uriStr);
        URI uri = HttpUtils.appendUri(baseUri, pathComponents.toArray(new String[pathComponents.size()]));

        // get a InternalRequest instance and set headers
        InternalRequest request = new InternalRequest(HttpMethodName.POST, uri);
        BceCredentials credentials = new DefaultBceCredentials(accessKeyId, secretAccessKey);
        request.setCredentials(credentials);

        request.addParameter("source", "bos");
        String strJson = JsonUtils.toJsonString(request);
        byte[] requestJson;
        try {
            requestJson = strJson.getBytes(DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new BceClientException("Unsupported encode.", e);
        }

        request.addHeader(Headers.CONTENT_LENGTH, String.valueOf(requestJson.length));
        request.addHeader(Headers.CONTENT_TYPE, DEFAULT_CONTENT_TYPE);
        request.setContent(RestartableInputStream.wrap(requestJson));

        SignOptions options = SignOptions.DEFAULT;


        Date timestamp = new Date();
        String authString =
                V1Signer.BCE_AUTH_VERSION + "/" + accessKeyId + "/"
                        + DateUtils.formatAlternateIso8601Date(timestamp) + "/" + 1800;

        String signingKey = this.sha256Hex(secretAccessKey, authString);
        // Formatting the URL with signing protocol.
        String canonicalURI = this.getCanonicalURIPath(request.getUri().getPath());
        // Formatting the query string with signing protocol.
        String canonicalQueryString = HttpUtils.getCanonicalQueryString(request.getParameters(), true);
        // Sorted the headers should be signed from the request.
        SortedMap<String, String> headersToSign =
                this.getHeadersToSign(request.getHeaders(), options.getHeadersToSign());
        // Formatting the headers from the request based on signing protocol.
        String canonicalHeader = this.getCanonicalHeaders(headersToSign);
        String signedHeaders = "";
        if (options.getHeadersToSign() != null) {
            signedHeaders = V1Signer.signedHeaderStringJoiner.join(headersToSign.keySet());
            signedHeaders = signedHeaders.trim().toLowerCase();
        }

        String canonicalRequest =
                request.getHttpMethod() + "\n" + canonicalURI + "\n" + canonicalQueryString + "\n" + canonicalHeader;

        // Signing the canonical request using key with sha-256 algorithm.
        String signature = this.sha256Hex(signingKey, canonicalRequest);

        String authorizationHeader = authString + "/" + signedHeaders + "/" + signature;

        logger.debug("CanonicalRequest:{}\tAuthorization:{}", canonicalRequest.replace("\n", "[\\n]"), authorizationHeader);
        return authorizationHeader;

    }

    private String getCanonicalURIPath(String path) {
        if (path == null) {
            return "/";
        } else if (path.startsWith("/")) {
            return HttpUtils.normalizePath(path);
        } else {
            return "/" + HttpUtils.normalizePath(path);
        }
    }

    private String getCanonicalHeaders(SortedMap<String, String> headers) {
        if (headers.isEmpty()) {
            return "";
        }

        List<String> headerStrings = Lists.newArrayList();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            String key = entry.getKey();
            if (key == null) {
                continue;
            }
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            headerStrings.add(HttpUtils.normalize(key.trim().toLowerCase()) + ':' + HttpUtils.normalize(value.trim()));
        }
        Collections.sort(headerStrings);

        return headerJoiner.join(headerStrings);
    }

    private SortedMap<String, String> getHeadersToSign(Map<String, String> headers, Set<String> headersToSign) {
        SortedMap<String, String> ret = Maps.newTreeMap();
        if (headersToSign != null) {
            Set<String> tempSet = Sets.newHashSet();
            for (String header : headersToSign) {
                tempSet.add(header.trim().toLowerCase());
            }
            headersToSign = tempSet;
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                if ((headersToSign == null && this.isDefaultHeaderToSign(key))
                        || (headersToSign != null && headersToSign.contains(key.toLowerCase())
                        && !Headers.AUTHORIZATION.equalsIgnoreCase(key))) {
                    ret.put(key, entry.getValue());
                }
            }
        }
        return ret;
    }

    private boolean isDefaultHeaderToSign(String header) {
        header = header.trim().toLowerCase();
        return header.startsWith(Headers.BCE_PREFIX) || defaultHeadersToSign.contains(header);
    }

    private String sha256Hex(String signingKey, String stringToSign) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(signingKey.getBytes(UTF8), "HmacSHA256"));
            return new String(Hex.encodeHex(mac.doFinal(stringToSign.getBytes(UTF8))));
        } catch (Exception e) {
            throw new BceClientException("Fail to generate the signature", e);
        }
    }

    public static void main(String[] args) {
        String AK = "12559d3511774ea6b840dfed77aea1f5";
        String SK = "8d8db671bad341e09cc77a71c8a227eb";

        // 初始化一个DocClient
        String ENDPOINT = "http://doc.bj.baidubce.com";
        BceClientConfiguration config = new BceClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(AK, SK));
        config.setEndpoint(ENDPOINT);
        DocClient client = new DocClient(config);
        ReadDocumentResponse resp = client.readDocument("doc-hkcz03ijy9u8am1");
        System.out.println(resp);
//        V1Signer v1Signer = new V1Signer();
//        System.out.println(v1Signer.sign("http://doc.bj.baidubce.com", AK, SK));
    }

}