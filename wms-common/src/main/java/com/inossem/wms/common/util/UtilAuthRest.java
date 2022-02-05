package com.inossem.wms.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.inossem.wms.vo.BaseObject;

@Component
public class UtilAuthRest<T> {

    @Autowired
    private RestTemplate restTemplate;

    private final static String AUTHORIZATION = "Authorization";

    private final static String CONTENT_TYPE = "Content-Type";

    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.context-path}")
    private String context;

    @Value("${storage.host}")
    private String host;


    /**
     * 马永康
     * rest请求
     *
     * @param request     request
     * @param url         要请求得url
     * @param resultClass 返回得class类型
     * @param type        rest请求得到得类型
     * @param contentType contentType
     * @param httpMethod  请求方法类型
     */
    public T restGetObject(HttpServletRequest request, String url, Class<T> resultClass, Class<?> type, String contentType, HttpMethod httpMethod) {
        url = "http://" + host + ":" + port + context + url;
        System.out.println("url:" + url);
        //获取请求凭证
        String token = request.getParameter("token");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, token);
        httpHeaders.add(CONTENT_TYPE, contentType);
        
        ResponseEntity<?> responseEntity = restTemplate.exchange(url, httpMethod, new HttpEntity<>(httpHeaders), type);
        BaseObject<?> baseObject = (BaseObject<?>) responseEntity.getBody();
        assert baseObject != null;
        return JSON.parseObject(JSON.toJSONString(baseObject.getData()), resultClass);
    }
    
    public T restPostObject(HttpServletRequest request, String url, Class<T> resultClass, Class<?> type, String contentType, HttpMethod httpMethod,Map<String, Object> obj) {
        url = "http://" + host + ":" + port + context + url;
        System.out.println("url:" + url);
        //获取请求凭证
        String token = (String) obj.get("token");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, token);
        httpHeaders.add(CONTENT_TYPE, contentType);
        System.out.println("*********************************");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("*********************************");
        
        ResponseEntity<?> forEntity = restTemplate.exchange(url, HttpMethod.POST,new HttpEntity<>(obj,httpHeaders), type);
 //       ResponseEntity<?> forEntity = restTemplate.postForEntity(url, new HttpEntity<>(co,httpHeaders), type);
        BaseObject<?> baseObject = (BaseObject<?>) forEntity.getBody();
        System.out.println("*****************************");
        System.out.println(baseObject.getData());
        System.out.println("*****************************");
        assert baseObject != null;
        return JSON.parseObject(JSON.toJSONString(baseObject.getData()), resultClass);
    }

    public T restGetObjectNoAuth(String url, Class<T> resultClass, Class<?> type, String contentType, HttpMethod httpMethod) {
        url = "http://" + host + ":" + port + context + url;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(CONTENT_TYPE, contentType);
        ResponseEntity<?> responseEntity = restTemplate.exchange(url, httpMethod, new HttpEntity<>(httpHeaders), type);
        BaseObject<?>  baseObject = (BaseObject<?> ) responseEntity.getBody();
        assert baseObject != null;
        return JSON.parseObject(JSON.toJSONString(baseObject.getData()), resultClass);
    }

}
