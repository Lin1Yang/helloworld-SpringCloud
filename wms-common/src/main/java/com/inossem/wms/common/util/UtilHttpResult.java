package com.inossem.wms.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSON;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.constant.Const;
import com.inossem.wms.vo.BaseObject;

public class UtilHttpResult {
	
//	public static Object getHttpResultByResNum(int res) {
//		Map<String, Object> result = new HashMap<>();
//		if (res > 0) {
//			result.put("status", "成功");
//			result.put("errorCode", "0");
//		} else {
//			result.put("status", "失败");
//			result.put("errorCode", "-1");
//		}
//		return result;
//	}
//	
//	public static Object getHttpResult(boolean status, int errorCode, String errorString, int pageIndex, int pageSize, int total, Object data) {
//		Map<String, Object> result = new HashMap<>();
//		if(status) {
//			result.put("status", "成功");
//		}
//		else {
//			result.put("status", "失败");
//		}
//		result.put("errorCode", errorCode);
//		result.put("data", data);
//		return result;
//	}
//	
//	public static Object getHttpResult(boolean status, Object data) {
//		Map<String, Object> result = new HashMap<>();
//		if(status) {
//			result.put("status", "成功");
//		}
//		else {
//			result.put("status", "失败");
//		}
//		result.put("errorCode", 0);
//		result.put("data", data);
//		return result;
//	}
	
	public static void handleAccessDenied(ServletRequest request, ServletResponse response, WMSException e) {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String langCode = req.getHeader(Const.LANG_CODE_HEADER_NAME);
		langCode = langCode == null ? Const.DEFAULT_LANG_CODE : langCode;
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = null;
		try {
			writer = resp.getWriter();
		} catch (IOException e1) {
			
		}
		if(writer!=null){
			BaseObject<?> objectReturn = new BaseObject<>();
	        objectReturn.setReturnCode(e.getErrorCode().getValue());
			objectReturn.setReturnMsg(
					UtilText.getMessage(langCode, e.getErrorCode().name()));
	        writer.write(JSON.toJSONString(objectReturn));
	        writer.close();
		}
       
	}

}
