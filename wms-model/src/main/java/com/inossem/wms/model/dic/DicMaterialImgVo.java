package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialImgVo", description="物料图片拓展信息")
public class DicMaterialImgVo extends DicMaterialImg{
	
	@ApiModelProperty(value="文件路径", name="path", example="2018/231", required=true)
	private String path;
	
	@ApiModelProperty(value="图片名", name="imgName", example="123.jpg", required=true)
    private String imgName;
	
	@ApiModelProperty(value="图片WEB编码", name="imgWebCode", example="60000020", required=true)
    private String imgWebCode;
	
    @ApiModelProperty(value="图片PDA编码", name="imgPadCode", example="60000020", required=true)
    private String imgPadCode;
    
    @ApiModelProperty(value="图片后缀名", name="imgExt", example="jpg", required=true)
    private String imgExt;
    
	@ApiModelProperty(value="图片大小", name="imgSize", example="1024", required=true)
    private Integer imgSize;
	
    @ApiModelProperty(value="物料图片创建人编码", name="createUserCode",example="admin", required=true)
	private String createUserCode; 
	
	@ApiModelProperty(value="物料图片创建人描述", name="createUserName",example="admin", required=true)
	private String createUserName; 
	
	@ApiModelProperty(value="物料图片修改人编码", name="modifyUserCode",example="admin", required=true)
	private String modifyUserCode; 
	
	@ApiModelProperty(value="物料图片修改人描述", name="modifyUserName",example="admin", required=true)
	private String modifyUserName;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
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
		this.imgExt = imgExt;
	}

	public Integer getImgSize() {
		return imgSize;
	}

	public void setImgSize(Integer imgSize) {
		this.imgSize = imgSize;
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
	
	

}
