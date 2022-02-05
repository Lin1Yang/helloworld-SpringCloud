package com.inossem.wms.vo.conf;

import java.util.Date;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModelProperty;

public class MqRetryVo implements IPageResultCommon {
	
	private long id;
	
	private String destination;
	
	private String msg;
	
	private String msgClassFullName;
	
	private String msgType;
	
	private String reason;
	
	private int retryTimes;
	
	private Date createTime;
	
	private Date modifyTime;
	
	private byte isDelete;
	
	private byte isProcessed;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgClassFullName() {
		return msgClassFullName;
	}

	public void setMsgClassFullName(String msgClassFullName) {
		this.msgClassFullName = msgClassFullName;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	public byte getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(byte isProcessed) {
		this.isProcessed = isProcessed;
	}

	@ApiModelProperty(value = "总记录数", example = "0")
	private int totalCount;

	@Override
	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
