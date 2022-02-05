package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUerIsDeleteCo", description="用户查询单据用于判断是否可以删除对象")
public class SysUerIsDeleteCo {
	
	@ApiModelProperty(value="修改人Id", name="modifyUserId",example="20", required=true)
	private Integer modifyUserId;
	
	@ApiModelProperty(value="行项目状态", name="itemStatus",example="20", required=false)
	private String itemStatus;
	
	@ApiModelProperty(value="删除标识，0-否，1-是", name="isDelete", example="0", required=true)
    private Byte isDelete;

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}


	
}
