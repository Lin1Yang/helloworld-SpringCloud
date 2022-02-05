package com.inossem.wms.model.dic;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialType", description="物料类型映射")
public class DicMaterialType {
	
	@ApiModelProperty(value="物料类型代码", name="matTypeCode",example="ZWL", required=true)
    private String matTypeCode;
	
	@ApiModelProperty(value="物料类型描述", name="matTypeName",example="物料类型", required=true)
    private String matTypeName;
	
	@ApiModelProperty(value="删除标识，0-否，1-是", name="isDelete", example="0", required=true)
    private Byte isDelete;

	@ApiModelProperty(value="创建时间", name="createTime", example="2018-12-24 12:24:24", required=true)
    private Date createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-12-24 12:24:24", required=true)
    private Date modifyTime;
	
	@ApiModelProperty(value="用户创建人Id", name="createUserId", example="0", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="用户修改人Id", name="modifyUserId", example="0", required=true)
    private Integer modifyUserId;
	
    private String matTypeExt0;

    private String matTypeExt1;

    private String matTypeExt2;

    private String matTypeExt3;

    private String matTypeExt4;

    private String matTypeExt5;

    private String matTypeExt6;

    private String matTypeExt7;

    private String matTypeExt8;

    private String matTypeExt9;
    
    private boolean isClick;

    public String getMatTypeCode() {
        return matTypeCode;
    }

    public void setMatTypeCode(String matTypeCode) {
        this.matTypeCode = matTypeCode == null ? null : matTypeCode.trim();
    }

    public String getMatTypeName() {
        return matTypeName;
    }

    public void setMatTypeName(String matTypeName) {
        this.matTypeName = matTypeName == null ? null : matTypeName.trim();
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

    public String getMatTypeExt0() {
        return matTypeExt0;
    }

    public void setMatTypeExt0(String matTypeExt0) {
        this.matTypeExt0 = matTypeExt0 == null ? null : matTypeExt0.trim();
    }

    public String getMatTypeExt1() {
        return matTypeExt1;
    }

    public void setMatTypeExt1(String matTypeExt1) {
        this.matTypeExt1 = matTypeExt1 == null ? null : matTypeExt1.trim();
    }

    public String getMatTypeExt2() {
        return matTypeExt2;
    }

    public void setMatTypeExt2(String matTypeExt2) {
        this.matTypeExt2 = matTypeExt2 == null ? null : matTypeExt2.trim();
    }

    public String getMatTypeExt3() {
        return matTypeExt3;
    }

    public void setMatTypeExt3(String matTypeExt3) {
        this.matTypeExt3 = matTypeExt3 == null ? null : matTypeExt3.trim();
    }

    public String getMatTypeExt4() {
        return matTypeExt4;
    }

    public void setMatTypeExt4(String matTypeExt4) {
        this.matTypeExt4 = matTypeExt4 == null ? null : matTypeExt4.trim();
    }

    public String getMatTypeExt5() {
        return matTypeExt5;
    }

    public void setMatTypeExt5(String matTypeExt5) {
        this.matTypeExt5 = matTypeExt5 == null ? null : matTypeExt5.trim();
    }

    public String getMatTypeExt6() {
        return matTypeExt6;
    }

    public void setMatTypeExt6(String matTypeExt6) {
        this.matTypeExt6 = matTypeExt6 == null ? null : matTypeExt6.trim();
    }

    public String getMatTypeExt7() {
        return matTypeExt7;
    }

    public void setMatTypeExt7(String matTypeExt7) {
        this.matTypeExt7 = matTypeExt7 == null ? null : matTypeExt7.trim();
    }

    public String getMatTypeExt8() {
        return matTypeExt8;
    }

    public void setMatTypeExt8(String matTypeExt8) {
        this.matTypeExt8 = matTypeExt8 == null ? null : matTypeExt8.trim();
    }

    public String getMatTypeExt9() {
        return matTypeExt9;
    }

    public void setMatTypeExt9(String matTypeExt9) {
        this.matTypeExt9 = matTypeExt9 == null ? null : matTypeExt9.trim();
    }

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}
    
}