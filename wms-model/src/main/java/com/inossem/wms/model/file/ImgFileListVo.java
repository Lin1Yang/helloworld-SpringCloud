package com.inossem.wms.model.file;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.file.LogFile", description="图片总对象")
public class ImgFileListVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6430861814131703005L;

	@ApiModelProperty(value = "图片集合")
    private List<ImgFile> list;

	public List<ImgFile> getList() {
		return list;
	}

	public void setList(List<ImgFile> list) {
		this.list = list;
	}
	
}