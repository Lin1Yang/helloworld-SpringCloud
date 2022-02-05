package com.inossem.wms.model.dic;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicExcellCheck", description="EXCEL导入规则类")
public class DicExcellCheck{
	
	@ApiModelProperty(value="集合名")
	private String resultName;
	
	@ApiModelProperty(value="值包含在/不包含在的集合")
	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	

}
