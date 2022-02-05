package com.inossem.wms.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.constant.Const;
import com.inossem.wms.enums.EnumReturnCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.BaseObject", description="标准返回对象")
public class BaseObject<T> implements Serializable {
	private static final long serialVersionUID = -8824371373558127343L;
	
	@ApiModelProperty(value="api调用执行状态, 调用成功返回true，失败返回false", example="0", required=true)
	private boolean status;
	
	@ApiModelProperty(value="返回代码", name="returnCode", example="1", required=true)
	private Integer returnCode;
	
	@ApiModelProperty(value="返回信息", name="returnMsg", example="成功", required=true)
	private String returnMsg;
	
	@ApiModelProperty(value="信息级别", name="msgLevel", example="1", required=true)
	private int msgLevel;
	
	@ApiModelProperty(value="返回实际数据", name="data", required=true)
	private T data;
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
	public int getMsgLevel() {
		return msgLevel;
	}

	public void setMsgLevel(int msgLevel) {
		this.msgLevel = msgLevel;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BaseObject() {
		status = Boolean.TRUE;
		returnCode = EnumReturnCode.RETURN_CODE_SUCCESS.getValue();
		msgLevel = 0;
		returnMsg = this.getMessage(EnumReturnCode.RETURN_CODE_SUCCESS.name());
	}

	public BaseObject(T data) {
		status = Boolean.TRUE;
		returnCode = EnumReturnCode.RETURN_CODE_SUCCESS.getValue();
		msgLevel = 0;
		returnMsg = this.getMessage(EnumReturnCode.RETURN_CODE_SUCCESS.name());
		this.data= data;
	}

	protected String getMessage(String key, String... args) {
		JSONObject json = new JSONObject();
		json.put(Const.STRING_ZERO, key);
		for (int i = 0; i < args.length; i++) {
			json.put(String.valueOf(i + 1), key);
		}
		return Const.I18N_ + json.toString() + Const._MSG;
	}
}
