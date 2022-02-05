package com.inossem.wms.vo.dic;

import io.swagger.annotations.ApiModelProperty;

public class DicCodeAndNameVo {
	@ApiModelProperty(value="", name="code", example="60000020", required=true)
    private Byte code;
	
	@ApiModelProperty(value="", name="name", example="刚", required=true)
    private String name;

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

