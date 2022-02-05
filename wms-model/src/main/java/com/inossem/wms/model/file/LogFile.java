package com.inossem.wms.model.file;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.file.LogFile", description="文件bean")
public class LogFile {
	
	@ApiModelProperty(value = "文件code",example="df35234erer34ldf.jpg")
    private String fileCode;
	
	@ApiModelProperty(value = "文件路径",example="2018/2018-12/2018-12-31")
    private String path;
	
	@ApiModelProperty(value = "文件真实名称",example="111.jpg")
    private String fileName;
	
	@ApiModelProperty(value = "文件后缀",example="jpg")
    private String fileExt;
	
	@ApiModelProperty(value = "文件大小",example="1024")
    private Integer fileSize;
	
	@ApiModelProperty(value = "是否被删除",example="0")
    private Byte isDelete;
	
	@ApiModelProperty(value = "创建时间",example="2018-12-31 12:12:31")
    private Date createTime;
	@ApiModelProperty(value = "修改时间",example="2018-12-31 12:12:31")
    private Date modifyTime;
	
	@ApiModelProperty(value = "创建人id",example="1")
    private Integer createUserId;
	
	@ApiModelProperty(value = "修改人id",example="1")
    private Integer modifyUserId;
	
	@ApiModelProperty(value = "用户",example="李四")
	private String userName;
	
	@ApiModelProperty(value = "扩展字段")
    private String fileExt0;
	
	@ApiModelProperty(value = "扩展字段")
    private String fileExt1;
	
	@ApiModelProperty(value = "扩展字段")
    private String fileExt2;
	
	@ApiModelProperty(value = "扩展字段")
    private String fileExt3;
	
	@ApiModelProperty(value = "扩展字段")
    private String fileExt4;

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode == null ? null : fileCode.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getFileExt0() {
        return fileExt0;
    }

    public void setFileExt0(String fileExt0) {
        this.fileExt0 = fileExt0 == null ? null : fileExt0.trim();
    }

    public String getFileExt1() {
        return fileExt1;
    }

    public void setFileExt1(String fileExt1) {
        this.fileExt1 = fileExt1 == null ? null : fileExt1.trim();
    }

    public String getFileExt2() {
        return fileExt2;
    }

    public void setFileExt2(String fileExt2) {
        this.fileExt2 = fileExt2 == null ? null : fileExt2.trim();
    }

    public String getFileExt3() {
        return fileExt3;
    }

    public void setFileExt3(String fileExt3) {
        this.fileExt3 = fileExt3 == null ? null : fileExt3.trim();
    }

    public String getFileExt4() {
        return fileExt4;
    }

    public void setFileExt4(String fileExt4) {
        this.fileExt4 = fileExt4 == null ? null : fileExt4.trim();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}