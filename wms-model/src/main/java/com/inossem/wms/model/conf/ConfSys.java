package com.inossem.wms.model.conf;

import java.util.Date;

public class ConfSys {
	private Integer id;

	private String filePath;

	private String imgPath;
	
	private String appUpgradeFilePath;

	private Byte inspectInsBatch;

	private String erpUrl;
	
	private Byte otherInputPost;
	
	private Byte otherOutputPost;
	
	private Byte erpSyncMode;
	
	private Integer timeout;
	
	private Byte interfaceType;

	private Byte strategyShelfLoad;

	private Byte strategyShelfUnLoad;

	private Date createTime;

	private Integer createUserId;

	private Date modifyTime;

	private Integer modifyUserId;

	private String confSysExt0;

	private String confSysExt1;

	private String confSysExt2;

	private String confSysExt3;

	private String confSysExt4;

	public Byte getStrategyShelfLoad() {
		return strategyShelfLoad;
	}

	public void setStrategyShelfLoad(Byte strategyShelfLoad) {
		this.strategyShelfLoad = strategyShelfLoad;
	}

	public Byte getStrategyShelfUnLoad() {
		return strategyShelfUnLoad;
	}

	public void setStrategyShelfUnLoad(Byte strategyShelfUnLoad) {
		this.strategyShelfUnLoad = strategyShelfUnLoad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}	
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getAppUpgradeFilePath() {
		return appUpgradeFilePath;
	}

	public void setAppUpgradeFilePath(String appUpgradeFilePath) {
		this.appUpgradeFilePath = appUpgradeFilePath;
	}

	public Byte getInspectInsBatch() {
		return inspectInsBatch;
	}

	public void setInspectInsBatch(Byte inspectInsBatch) {
		this.inspectInsBatch = inspectInsBatch;
	}

	public String getErpUrl() {
		return erpUrl;
	}

	public void setErpUrl(String erpUrl) {
		this.erpUrl = erpUrl;
	}

	public Byte getOtherInputPost() {
		return otherInputPost;
	}

	public void setOtherInputPost(Byte otherInputPost) {
		this.otherInputPost = otherInputPost;
	}

	public Byte getOtherOutputPost() {
		return otherOutputPost;
	}

	public void setOtherOutputPost(Byte otherOutputPost) {
		this.otherOutputPost = otherOutputPost;
	}

	public Byte getErpSyncMode() {
		return erpSyncMode;
	}

	public void setErpSyncMode(Byte erpSyncMode) {
		this.erpSyncMode = erpSyncMode;
	}		

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}	

	public Byte getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(Byte interfaceType) {
		this.interfaceType = interfaceType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getConfSysExt0() {
		return confSysExt0;
	}

	public void setConfSysExt0(String confSysExt0) {
		this.confSysExt0 = confSysExt0 == null ? null : confSysExt0.trim();
	}

	public String getConfSysExt1() {
		return confSysExt1;
	}

	public void setConfSysExt1(String confSysExt1) {
		this.confSysExt1 = confSysExt1 == null ? null : confSysExt1.trim();
	}

	public String getConfSysExt2() {
		return confSysExt2;
	}

	public void setConfSysExt2(String confSysExt2) {
		this.confSysExt2 = confSysExt2 == null ? null : confSysExt2.trim();
	}

	public String getConfSysExt3() {
		return confSysExt3;
	}

	public void setConfSysExt3(String confSysExt3) {
		this.confSysExt3 = confSysExt3 == null ? null : confSysExt3.trim();
	}

	public String getConfSysExt4() {
		return confSysExt4;
	}

	public void setConfSysExt4(String confSysExt4) {
		this.confSysExt4 = confSysExt4 == null ? null : confSysExt4.trim();
	}
}