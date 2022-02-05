package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserUpdatesCo", description="批量修改用户对象")
public class SysUserUpdatesCo<T>  {
	
	@ApiModelProperty(value="修改用户对象", name="updatesCo", required=true)
	private T updatesCo;

	public T getUpdatesCo() {
		return updatesCo;
	}

	public void setUpdatesCo(T updatesCo) {
		this.updatesCo = updatesCo;
	}	

}
