package com.inossem.wms.model.file;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.file.LogFile", description="文件bean")
public class ImgFile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6430861814131703005L;

	@ApiModelProperty(value = "图片code",example="3ad7b7e7d237497f99f1e300336b856c.jpg")
    private String imgCode;
	
	@ApiModelProperty(value = "图片路径",example="2019\\201901\\20190112\\")
    private String path;
	@ApiModelProperty(value = "图片真名",example="111.jpg")
    private String imgName;
	@ApiModelProperty(value = "web的图片code",example="2537d07bb5fb98cdcfc54b5e885f3f1a_cut_200X200.jpg")
    private String imgWebCode;
	@ApiModelProperty(value = "pad的图片code",example="2537d07bb5fb98cdcfc54b5e885f3f1a_200X125.jpg")
    private String imgPadCode;
	@ApiModelProperty(value = "图片后缀",example="jpg")
    private String imgExt;
	@ApiModelProperty(value = "图片大小",example="220")
    private Integer imgSize;
	@ApiModelProperty(value = "图片指纹",example="997129d86af8757d8071c15d2a71010b")
    private String imgMd5;
	@ApiModelProperty(value = "是否删除标识",example="1")
    private Byte isDelete;
	@ApiModelProperty(value = "创建时间",example="2017-12-12 11:22:22")
    private Date createTime;
	@ApiModelProperty(value = "修改时间",example="2017-12-12 11:22:22")
    private Date modifyTime;
	@ApiModelProperty(value = "创建人id",example="1")
    private Integer createUserId;
	@ApiModelProperty(value = "修改人id",example="1")
    private Integer modifyUserId;
	@ApiModelProperty(value = "用户名",example="李四")
    private String userName;
	@ApiModelProperty(value = "扩展字段")
    private String imgExt0;
	@ApiModelProperty(value = "扩展字段")
    private String imgExt1;
	@ApiModelProperty(value = "扩展字段")
    private String imgExt2;
	@ApiModelProperty(value = "扩展字段")
    private String imgExt3;
	@ApiModelProperty(value = "扩展字段")
    private String imgExt4;

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode == null ? null : imgCode.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }


    public String getImgWebCode() {
		return imgWebCode;
	}

	public void setImgWebCode(String imgWebCode) {
		this.imgWebCode = imgWebCode;
	}

	public String getImgPadCode() {
		return imgPadCode;
	}

	public void setImgPadCode(String imgPadCode) {
		this.imgPadCode = imgPadCode;
	}


	public String getImgExt() {
        return imgExt;
    }

    public void setImgExt(String imgExt) {
        this.imgExt = imgExt == null ? null : imgExt.trim();
    }

    public Integer getImgSize() {
        return imgSize;
    }

    public void setImgSize(Integer imgSize) {
        this.imgSize = imgSize;
    }

    public String getImgMd5() {
        return imgMd5;
    }

    public void setImgMd5(String imgMd5) {
        this.imgMd5 = imgMd5 == null ? null : imgMd5.trim();
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

    public String getImgExt0() {
        return imgExt0;
    }

    public void setImgExt0(String imgExt0) {
        this.imgExt0 = imgExt0 == null ? null : imgExt0.trim();
    }

    public String getImgExt1() {
        return imgExt1;
    }

    public void setImgExt1(String imgExt1) {
        this.imgExt1 = imgExt1 == null ? null : imgExt1.trim();
    }

    public String getImgExt2() {
        return imgExt2;
    }

    public void setImgExt2(String imgExt2) {
        this.imgExt2 = imgExt2 == null ? null : imgExt2.trim();
    }

    public String getImgExt3() {
        return imgExt3;
    }

    public void setImgExt3(String imgExt3) {
        this.imgExt3 = imgExt3 == null ? null : imgExt3.trim();
    }

    public String getImgExt4() {
        return imgExt4;
    }

    public void setImgExt4(String imgExt4) {
        this.imgExt4 = imgExt4 == null ? null : imgExt4.trim();
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}