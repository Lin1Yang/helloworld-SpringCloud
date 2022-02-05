package com.inossem.wms.vo.conf;

import java.util.Date;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModelProperty;

public class AppUpgradeVo implements IPageResultCommon {
	
	private long id;
	
	/** 是否需要升级 0：不需要，1：需要 */
	private byte requireUpgrade;
	/** 操作系统类型 */
	private byte osType;
	/** 版本号 */
	private String versionCode;
	/** 版本名称 */
	private String versionName;
	/** 版本描述说明 */
	private String versionDescription;
	/** 版本描述所用的语言代码 */
	private String langCode;
	/** 版本发布时间 */
	private Date publicDate;
	/** 是否强制升级 0：不强制，1：强制 */
	private byte forceUpgrade;
	/** 升级包MD5值 */
	private String md5Code;
	/** 升级包文件大小 */
	private long fileSize;
	
	private String fileOriginName;
	
	private String fileName;
	
	private String filePath;
	
	private String fileExt;
	
	private byte isDelete;
	
	private Date createTime;
	
	private Date modifyTime;
	
	private String createUserId;
	
	private String modifyUserId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getRequireUpgrade() {
		return requireUpgrade;
	}

	public void setRequireUpgrade(byte requireUpgrade) {
		this.requireUpgrade = requireUpgrade;
	}

	public byte getOsType() {
		return osType;
	}

	public void setOsType(byte osType) {
		this.osType = osType;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getVersionDescription() {
		return versionDescription;
	}

	public void setVersionDescription(String versionDescription) {
		this.versionDescription = versionDescription;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public Date getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}

	public byte getForceUpgrade() {
		return forceUpgrade;
	}

	public void setForceUpgrade(byte forceUpgrade) {
		this.forceUpgrade = forceUpgrade;
	}

	public String getMd5Code() {
		return md5Code;
	}

	public void setMd5Code(String md5Code) {
		this.md5Code = md5Code;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
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

	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
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

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getFileOriginName() {
		return fileOriginName;
	}

	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

}
