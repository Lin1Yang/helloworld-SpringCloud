package com.inossem.wms.model.dic;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialName", description="物料描述映射")
public class DicMaterialName extends DicMaterialNameKey {
	
	@ApiModelProperty(value="物料描述", name="matName",example="热轧碳素结构钢板/δ3*1500*6000/Q235B", required=true)
	private String matName;

	@ApiModelProperty(value="删除标记", name="isDelete", example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建时间", name="createTime", example="2018-11-27 16:37:34.741645", required=true)
    private Date createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-11-27 16:56:10.775559", required=true)
    private Date modifyTime;
	
	@ApiModelProperty(value="创建人id", name="createUserId", example="1", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="修改人id", name="modifyUserId", example="1", required=true)
    private Integer modifyUserId;

	private String materialNameTextExt0;

	private String materialNameTextExt1;

	private String materialNameTextExt2;

	private String materialNameTextExt3;

	private String materialNameTextExt4;

	private String materialNameTextExt5;

	private String materialNameTextExt6;

	private String materialNameTextExt7;

	private String materialNameTextExt8;

	private String materialNameTextExt9;

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName == null ? null : matName.trim();
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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

	public String getMaterialNameTextExt0() {
		return materialNameTextExt0;
	}

	public void setMaterialNameExt0(String materialNameTextTextExt0) {
		this.materialNameTextExt0 = materialNameTextExt0 == null ? null : materialNameTextExt0.trim();
	}

	public String getMaterialNameTextExt1() {
		return materialNameTextExt1;
	}

	public void setMaterialNameTextExt1(String materialNameTextExt1) {
		this.materialNameTextExt1 = materialNameTextExt1 == null ? null : materialNameTextExt1.trim();
	}

	public String getMaterialNameTextExt2() {
		return materialNameTextExt2;
	}

	public void setMaterialNameTextExt2(String materialNameTextExt2) {
		this.materialNameTextExt2 = materialNameTextExt2 == null ? null : materialNameTextExt2.trim();
	}

	public String getMaterialNameTextExt3() {
		return materialNameTextExt3;
	}

	public void setMaterialNameTextExt3(String materialNameTextExt3) {
		this.materialNameTextExt3 = materialNameTextExt3 == null ? null : materialNameTextExt3.trim();
	}

	public String getMaterialNameTextExt4() {
		return materialNameTextExt4;
	}

	public void setMaterialNameTextExt4(String materialNameTextExt4) {
		this.materialNameTextExt4 = materialNameTextExt4 == null ? null : materialNameTextExt4.trim();
	}

	public String getMaterialNameTextExt5() {
		return materialNameTextExt5;
	}

	public void setMaterialNameTextExt5(String materialNameTextExt5) {
		this.materialNameTextExt5 = materialNameTextExt5 == null ? null : materialNameTextExt5.trim();
	}

	public String getMaterialNameTextExt6() {
		return materialNameTextExt6;
	}

	public void setMaterialNameTextExt6(String materialNameTextExt6) {
		this.materialNameTextExt6 = materialNameTextExt6 == null ? null : materialNameTextExt6.trim();
	}

	public String getMaterialNameTextExt7() {
		return materialNameTextExt7;
	}

	public void setMaterialNameTextExt7(String materialNameTextExt7) {
		this.materialNameTextExt7 = materialNameTextExt7 == null ? null : materialNameTextExt7.trim();
	}

	public String getMaterialNameTextExt8() {
		return materialNameTextExt8;
	}

	public void setMaterialNameTextExt8(String materialNameTextExt8) {
		this.materialNameTextExt8 = materialNameTextExt8 == null ? null : materialNameTextExt8.trim();
	}

	public String getMaterialNameTextExt9() {
		return materialNameTextExt9;
	}

	public void setMaterialNameTextExt9(String materialNameTextExt9) {
		this.materialNameTextExt9 = materialNameTextExt9 == null ? null : materialNameTextExt9.trim();
	}
}