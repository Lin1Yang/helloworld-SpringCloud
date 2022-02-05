package com.inossem.wms.model.biz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.biz.BizReceiptAttachmentVo", description="单据附件表拓展信息")
public class BizReceiptAttachmentVo extends BizReceiptAttachment{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7374548521548907559L;

	@ApiModelProperty(value="文件路径", name="path", example="2018/231", required=true)
	private String path;
	
	@ApiModelProperty(value="文件名", name="fileName", example="123.jpg", required=true)
	private String fileName;
	
	@ApiModelProperty(value="文件后缀名", name="fileExt", example="jpg", required=true)
	private String fileExt;
	
	@ApiModelProperty(value="文件大小", name="fileSize", example="1024", required=true)
	private Integer fileSize;
	
	@ApiModelProperty(value="单据附件创建人编码", name="createUserCode",example="admin", required=true)
	private String createUserCode; 
	
	@ApiModelProperty(value="单据附件创建人描述", name="createUserName",example="admin", required=true)
	private String createUserName; 
	
	@ApiModelProperty(value="单据附件修改人编码", name="modifyUserCode",example="admin", required=true)
	private String modifyUserCode; 
	
	@ApiModelProperty(value="单据附件修改人描述", name="modifyUserName",example="admin", required=true)
	private String modifyUserName;
	
	@ApiModelProperty(value="状态", name="finished",example="finished", required=true)
	private String status = "finished";
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getModifyUserCode() {
		return modifyUserCode;
	}

	public void setModifyUserCode(String modifyUserCode) {
		this.modifyUserCode = modifyUserCode;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
	
}
