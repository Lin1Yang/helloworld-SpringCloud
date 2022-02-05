package com.inossem.wms.vo.sinobec;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicWhStorageTypeVo", description="存储类型扩展对象")
public class SinobecDicWhStorageTypeVo implements Serializable {
	
	private static final long serialVersionUID = -1301940897113611643L;

	@ApiModelProperty(value="仓库编码",example="")
	private String whCode;

	@ApiModelProperty(value="存储类型",example="")
	private String typeCode;

	@ApiModelProperty(value="存储类型名称",example="")
	private String typeName;

	@ApiModelProperty(value="语言编码",example="cn-zh")
	private String langCode;

	@ApiModelProperty(value = "仓位列表", name="", example="")
	private List<SinobecDicWhStorageBinVo> dicWhStorageBinVoList;

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public List<SinobecDicWhStorageBinVo> getDicWhStorageBinVoList() {
		return dicWhStorageBinVoList;
	}

	public void setDicWhStorageBinVoList(List<SinobecDicWhStorageBinVo> dicWhStorageBinVoList) {
		this.dicWhStorageBinVoList = dicWhStorageBinVoList;
	}
}
