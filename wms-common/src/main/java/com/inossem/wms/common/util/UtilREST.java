package com.inossem.wms.common.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.constant.Const;

public class UtilREST {
    private static final Logger logger = LoggerFactory.getLogger(Const.LOGGER_NAME_SAP_REST_API);

    public enum MethodType {
        POST, PUT, GET, DELETE
    }

    private static class UTF8PostMethod extends PostMethod {
        public UTF8PostMethod(String url) {
            super(url);
        }

        @Override
        public String getRequestCharSet() {
            return "UTF-8";
        }
    }

    private static class UTF8PutMethod extends PutMethod {
        public UTF8PutMethod(String url) {
            super(url);
        }

        @Override
        public String getRequestCharSet() {
            return "UTF-8";
        }
    }

    private static class UTF8GetMethod extends GetMethod {
        public UTF8GetMethod(String url) {
            super(url);
        }

        @Override
        public String getRequestCharSet() {
            return "UTF-8";
        }
    }

    private static class UTF8DeleteMethod extends DeleteMethod {
        public UTF8DeleteMethod(String url) {
            super(url);
        }

        @Override
        public String getRequestCharSet() {
            return "UTF-8";
        }
    }

    public static JSONObject executePostJSONTimeOut(String url, JSONObject params, int timeout) throws Exception {
        logger.info(String.format("http:post url:%s\nparams:%s\ntimeout:%d", url, params.toString(), timeout));
        PostMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8PostMethod(url);
            method.setRequestHeader("Connection", "close");
            if(params.containsKey("Authorization")){
            	method.setRequestHeader("Authorization", params.getString("Authorization"));
            }
            RequestEntity requestEntity = new StringRequestEntity(params.toString(), "application/json", "UTF-8");
            
            
            
            method.setRequestEntity(requestEntity);
            client = new HttpClient();

            if (timeout > 0) {
                // 设置超时的时间
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
           
            return JSONObject.parseObject(str);
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static JSONObject executePostObjectTimeOut(String url, Object params, int timeout) throws Exception {

    	return executePostObjectTimeOut(url, params, timeout, null);
    }
    
    public static JSONObject executePostObjectTimeOut(String url, Object params, int timeout, String authorizationToken) throws Exception {
        logger.info(String.format("http:post url:%s\nparams:%s\ntimeout:%d", url, params.toString(), timeout));
        PostMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8PostMethod(url);
            method.setRequestHeader("Connection", "close");
            
            if(authorizationToken!=null && !authorizationToken.isEmpty()) {
            	method.setRequestHeader("Authorization", authorizationToken);
            }
            
            logger.debug("request to SAP with json format:"+JSON.toJSONString(params));
            RequestEntity requestEntity = new StringRequestEntity(JSON.toJSONString(params), "application/json", "UTF-8");
            method.setRequestEntity(requestEntity);
            client = new HttpClient();
            if (timeout > 0) {
                // 设置超时的时间
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("http-responese-str:%s", str));
            return JSONObject.parseObject(str);
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static JSONObject executeGetJSONTimeOut(String url, int timeout) throws Exception {
        logger.info(String.format("http:get url:%s\ntimeout:%d", url, timeout));
        GetMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8GetMethod(url);
            method.setRequestHeader("Connection", "close");
            client = new HttpClient();
            if (timeout > 0) {
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("http-responese-str:%s", str));
            return JSONObject.parseObject(str);
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static JSONObject executePutJSONTimeOut(String url, String params, int timeout) throws Exception {
        logger.info(String.format("http:put url:%s\nparams:%s\ntimeout:%d", url, params.toString(), timeout));
        PutMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8PutMethod(url);
            method.setRequestHeader("Connection", "close");
            RequestEntity requestEntity = new StringRequestEntity(params, "application/json", "UTF-8");
            method.setRequestEntity(requestEntity);
            client = new HttpClient();
            if (timeout > 0) {
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("http-responese-str:%s", str));
            return JSONObject.parseObject(str);
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static JSONObject executeDeleteJSONTimeOut(String url, int timeout) throws Exception {
        logger.info(String.format("http:delete url:%s\ntimeout:%d", url, timeout));
        DeleteMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8DeleteMethod(url);
            method.setRequestHeader("Connection", "close");
            client = new HttpClient();
            if (timeout > 0) {
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("http-responese-str:%s", str));
            return JSONObject.parseObject(str);
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static String executePostStringTimeOut(String url, JSONObject params, int timeout) throws Exception {
        logger.info(String.format("sap-api:post url:%s\nparams:%s\ntimeout:%d", url, params.toString(), timeout));
        PostMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8PostMethod(url);
            method.setRequestHeader("Connection", "close");
            RequestEntity requestEntity = new StringRequestEntity(params.toString(), "application/json", "UTF-8");
            method.setRequestEntity(requestEntity);
            client = new HttpClient();

            if (timeout > 0) {
                // 设置超时的时间
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("sap-api-responese-str:%s", str));
            return str;
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static String executeGetStringTimeOut(String url, int timeout) throws Exception {
        logger.info(String.format("sap-api:get url:%s\ntimeout:%d", url, timeout));
        GetMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8GetMethod(url);
            method.setRequestHeader("Connection", "close");
            client = new HttpClient();
            if (timeout > 0) {
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("sap-api-responese-str:%s", str));
            return str;
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static String executePutStringTimeOut(String url, String params, int timeout) throws Exception {
        logger.info(String.format("sap-api:put url:%s\nparams:%s\ntimeout:%d", url, params.toString(), timeout));
        PutMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8PutMethod(url);
            method.setRequestHeader("Connection", "close");
            RequestEntity requestEntity = new StringRequestEntity(params, "application/json", "UTF-8");
            method.setRequestEntity(requestEntity);
            client = new HttpClient();
            if (timeout > 0) {
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("sap-api-responese-str:%s", str));
            return str;
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }

    public static String executeDeleteStringTimeOut(String url, int timeout) throws Exception {
        logger.info(String.format("sap-api:delete url:%s\ntimeout:%d", url, timeout));
        DeleteMethod method = null;
        HttpClient client = null;
        try {
            method = new UTF8DeleteMethod(url);
            method.setRequestHeader("Connection", "close");
            client = new HttpClient();
            if (timeout > 0) {
                client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout * 1000);
            }
            client.executeMethod(method);
            String str = method.getResponseBodyAsString();
            logger.info(String.format("sap-api-responese-str:%s", str));
            return str;
        } catch (Exception e) {
            throw e;
        } finally {
            if (method != null) {
                method.releaseConnection();
                method = null;
            }
            if (client != null) {
                ((SimpleHttpConnectionManager) (client.getHttpConnectionManager())).shutdown();
                client = null;
            }
        }
    }
}
