package com.example.demo.httpClient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @CliassName: HttpClient
 * @Author: DZ5343
 * @Date: 2019/12/21 14:41
 * @Description:
 */
@Component
public class HttpClient {
    /** 默认字符集 */
    public static final String DEFAULT_CHARSET = "UTF-8";

    @Autowired
    private CloseableHttpClient closeableHttpClient;

    @Autowired
    private RequestConfig config;

    /**
     * 用于JSON格式的API调用
     * @param url url地址
     * @param requestParameter  请求参数
     * @param clazz 接口返回值的类型
     * @return
     * @throws Exception
     */
    public <T> T doGet(String url, Map<String, Object> requestParameter, Class<T> clazz) throws Exception {
        String responseJson = this.doGet(url, requestParameter);
        T response = JSONObject.parseObject(responseJson, clazz);
        return response;
    }

    public String doGet(String url, Map<String, Object> requestParameter) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);

        if (requestParameter != null) {
            for (Map.Entry<String, Object> entry : requestParameter.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        return this.doGet(uriBuilder.build().toString());
    }

    public String doGet(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);
        httpGet.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        CloseableHttpResponse response = this.closeableHttpClient.execute(httpGet);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            throw new Exception("api request exception, http reponse code:" + statusCode);
        }

        return EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
    }

    public <T> T doPost(String url, Map<String, Object> requestParameter, Class<T> clazz) throws Exception {
        HttpResponse httpResponse = this.doPost(url, requestParameter);
        int statusCode = httpResponse.getCode();
        if (statusCode != HttpStatus.SC_OK) {
            throw new Exception("api request exception, http reponse code:" + statusCode);
        }

        T response = JSONObject.parseObject(httpResponse.getBody(), clazz);
        return response;
    }

    public HttpResponse doPost(String url, Map<String, Object> requestParameter) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(config);
        httpPost.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());

        if (requestParameter != null) {
            String requestBody = JSONObject.toJSONString(requestParameter);
            StringEntity postEntity = new StringEntity(requestBody, "UTF-8");
            httpPost.setEntity(postEntity);
        }

        CloseableHttpResponse response = this.closeableHttpClient.execute(httpPost);
        // 对请求的响应进行简单的包装成自定义的类型
        return new HttpResponse(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                response.getEntity(), DEFAULT_CHARSET));
    }


    public HttpResponse doPost(String url) throws Exception {
        return this.doPost(url, null);
    }


    /**
     * 封住请求的响应码和响应的内容
     */
    public class HttpResponse {
        /** http status */
        private Integer code;
        /** http response content */
        private String body;

        public HttpResponse() { }

        public HttpResponse(Integer code, String body) {
            this.code = code;
            this.body = body;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }


}
