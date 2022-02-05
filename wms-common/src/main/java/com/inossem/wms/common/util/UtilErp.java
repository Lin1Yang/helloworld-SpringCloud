package com.inossem.wms.common.util;

import java.time.LocalDateTime;

import com.alibaba.fastjson.JSONObject;

public class UtilErp {

	public static JSONObject  getImport(String userCode ,String receiptCode,String type){
		JSONObject I_IMPORT = new JSONObject();
		I_IMPORT.put("ZTYPE", type);
		I_IMPORT.put("ZERNAM", userCode);
		LocalDateTime date = LocalDateTime.now();
		I_IMPORT.put("ZDATE", UtilLocalDateTime.getStringDateForLocalDateTime(date));
		I_IMPORT.put("ZTIME", UtilLocalDateTime.getStringTimeForLocalDateTime(date));
		I_IMPORT.put("ZDJBH", UtilObject.getStringOrEmpty(receiptCode));
		return I_IMPORT;
	}
}
