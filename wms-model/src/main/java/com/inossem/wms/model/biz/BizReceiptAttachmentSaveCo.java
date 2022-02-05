package com.inossem.wms.model.biz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.biz.BizReceiptAttachmentSaveCo", description="单据附件保存参数")
public class BizReceiptAttachmentSaveCo extends BizReceiptAttachmentInfoCo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5025237377659242245L;

	@ApiModelProperty(value="用户创建人Id", name="createUserId", example="0", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="用户修改人Id", name="modifyUserId", example="0", required=true)
    private Integer modifyUserId;
	
	@ApiModelProperty(value="删除标识，0-否，1-是", name="isDelete", example="0", required=true)
    private Byte isDelete;

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}
	
	

}
