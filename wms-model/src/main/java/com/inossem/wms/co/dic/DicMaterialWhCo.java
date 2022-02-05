package com.inossem.wms.co.dic;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.dic.DicMaterialWhCo", description="用户入参对象")
public class DicMaterialWhCo extends PageCommon{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8943787866099299481L;

	@ApiModelProperty(value="物料编码或者物料描述", name="condition",example="1", required=true)
	private String condition; //查询条件
	
	@ApiModelProperty(value="仓库编码", name="whCode", example="S01", required=true)
    private String whCode;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}
	
	
	
	

}
