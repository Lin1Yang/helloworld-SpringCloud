package com.inossem.wms.model.dic;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialImgCo", description="物料图片入参")
public class DicMaterialImgCo extends DicMaterialImgKey{
	@ApiModelProperty(value="删除标记", name="isDelete", example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建人id", name="createUserId", example="1", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="修改人id", name="modifyUserId", example="1", required=true)
    private Integer modifyUserId;

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

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
}
