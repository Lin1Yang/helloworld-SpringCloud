package com.inossem.wms.co.conf;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.conf.AppUpgradeCo", description="app升级包查询对象")
public class AppUpgradeCo {
	
	/** 当前设备app版本号 */
	@ApiModelProperty(value="当前设备app版本号", example="80", required=true)
	private String currentVersionCode;
	/** 当前设备app版本名称 */
	@ApiModelProperty(value="当前设备app版本名称", example="1.0.1.80", required=false)
	private String currentVersionName;
	/** 设备操作系统类型， 0：android，1：ios */
	@ApiModelProperty(value="设备操作系统类型， 0：android，1：ios", example="0", required=true)
	private byte osType;
	/** 目标语言 */
	@ApiModelProperty(value="目标语言, 从请求头信息中获取", example="zh-CN", required=false)
	private String langCode;
	/** 设备类型 */
	@ApiModelProperty(value="设备类型", example="mate 20", required=false)
	private String devicesType;

	public String getCurrentVersionCode() {
		return currentVersionCode;
	}

	public void setCurrentVersionCode(String currentVersionCode) {
		this.currentVersionCode = currentVersionCode;
	}

	public String getCurrentVersionName() {
		return currentVersionName;
	}

	public void setCurrentVersionName(String currentVersionName) {
		this.currentVersionName = currentVersionName;
	}

	public byte getOsType() {
		return osType;
	}

	public void setOsType(byte osType) {
		this.osType = osType;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getDevicesType() {
		return devicesType;
	}

	public void setDevicesType(String devicesType) {
		this.devicesType = devicesType;
	}

}
