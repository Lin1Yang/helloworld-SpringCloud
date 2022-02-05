package com.inossem.wms.model.conf;

import java.util.Date;
public class ConfCrons {
	
	private Integer jobId;
	
	private String jobName;
	
	private String jobGroup;
	
	private String cron;
	
	private Integer jobStatus;
	
	private Date initDate;
	
	private String startPath;
	
	private String stopPath;
	
	private String reflectionClass;
	
	private String method;
	
	private String remark;
	
	private String execute;
	
	private String executeIp;
	
	private Date modifyTime; 
	private String modifyUserId;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	
	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public String getStartPath() {
		return startPath;
	}

	public void setStartPath(String startPath) {
		this.startPath = startPath;
	}

	public String getStopPath() {
		return stopPath;
	}

	public void setStopPath(String stopPath) {
		this.stopPath = stopPath;
	}

	public String getReflectionClass() {
		return reflectionClass;
	}

	public void setReflectionClass(String reflectionClass) {
		this.reflectionClass = reflectionClass;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}

	public String getExecuteIp() {
		return executeIp;
	}

	public void setExecuteIp(String executeIp) {
		this.executeIp = executeIp;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
}
