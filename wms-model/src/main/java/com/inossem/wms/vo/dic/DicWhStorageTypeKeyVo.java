package com.inossem.wms.vo.dic;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class DicWhStorageTypeKeyVo {
	
	@ApiModelProperty(value="仓库描述",example="大地仓库")
	private String typeCode;
	
	@ApiModelProperty(value="语言编码",example="cn-zh")
	private String typeName;
	
	private List<DicWhStorageBinVo> binList;
	
	public DicWhStorageTypeKeyVo() {

	}

	public DicWhStorageTypeKeyVo(String typeCode, String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
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

	public List<DicWhStorageBinVo> getBinList() {
		return binList;
	}

	public void setBinList(List<DicWhStorageBinVo> binList) {
		this.binList = binList;
	}
}
