package com.inossem.wms.vo.rel;

import com.inossem.wms.model.rel.RelUnit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.rel.RelUnitVo", description="物料计量单位换算出参对象")
public class RelUnitVo extends RelUnit{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3203953564404045423L;
	@ApiModelProperty(value="工厂描述")
	private String ftyName;
	@ApiModelProperty(value="物料描述")
	private String matName;

	public String getFtyName() {
		return ftyName;
	}

	public void setFtyName(String ftyName) {
		this.ftyName = ftyName;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}
	
}
