package com.inossem.wms.model.dic;

import java.util.Date;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicUnit", description="单位映射")
public class DicUnit extends PageCommon{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5351232100334985150L;

	@ApiModelProperty(value="计量单位编码", name="unitCode",example="KG", required=true)
    private String unitCode;
	
	@ApiModelProperty(value="计量单位描述", name="unitName",example="千克", required=true)
    private String unitName;
	
	@ApiModelProperty(value="小数位", name="decimalPlace",example="3", required=true)
    private Byte decimalPlace;
	
	@ApiModelProperty(value="外部计量单位编码", name="externalUnitCode",example="KG", required=true)
    private String externalUnitCode;
	
	@ApiModelProperty(value="外部计量单位描述", name="externalUnitName",example="千克", required=true)
    private String externalUnitName;

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

    private String unitExt0;

    private String unitExt1;

    private String unitExt2;

    private String unitExt3;

    private String unitExt4;

    private String unitExt5;

    private String unitExt6;

    private String unitExt7;

    private String unitExt8;

    private String unitExt9;

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Byte getDecimalPlace() {
        return decimalPlace;
    }

    public void setDecimalPlace(Byte decimalPlace) {
        this.decimalPlace = decimalPlace;
    }

    public String getExternalUnitCode() {
        return externalUnitCode;
    }

    public void setExternalUnitCode(String externalUnitCode) {
        this.externalUnitCode = externalUnitCode == null ? null : externalUnitCode.trim();
    }

    public String getExternalUnitName() {
        return externalUnitName;
    }

    public void setExternalUnitName(String externalUnitName) {
        this.externalUnitName = externalUnitName == null ? null : externalUnitName.trim();
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

    public String getUnitExt0() {
        return unitExt0;
    }

    public void setUnitExt0(String unitExt0) {
        this.unitExt0 = unitExt0 == null ? null : unitExt0.trim();
    }

    public String getUnitExt1() {
        return unitExt1;
    }

    public void setUnitExt1(String unitExt1) {
        this.unitExt1 = unitExt1 == null ? null : unitExt1.trim();
    }

    public String getUnitExt2() {
        return unitExt2;
    }

    public void setUnitExt2(String unitExt2) {
        this.unitExt2 = unitExt2 == null ? null : unitExt2.trim();
    }

    public String getUnitExt3() {
        return unitExt3;
    }

    public void setUnitExt3(String unitExt3) {
        this.unitExt3 = unitExt3 == null ? null : unitExt3.trim();
    }

    public String getUnitExt4() {
        return unitExt4;
    }

    public void setUnitExt4(String unitExt4) {
        this.unitExt4 = unitExt4 == null ? null : unitExt4.trim();
    }

    public String getUnitExt5() {
        return unitExt5;
    }

    public void setUnitExt5(String unitExt5) {
        this.unitExt5 = unitExt5 == null ? null : unitExt5.trim();
    }

    public String getUnitExt6() {
        return unitExt6;
    }

    public void setUnitExt6(String unitExt6) {
        this.unitExt6 = unitExt6 == null ? null : unitExt6.trim();
    }

    public String getUnitExt7() {
        return unitExt7;
    }

    public void setUnitExt7(String unitExt7) {
        this.unitExt7 = unitExt7 == null ? null : unitExt7.trim();
    }

    public String getUnitExt8() {
        return unitExt8;
    }

    public void setUnitExt8(String unitExt8) {
        this.unitExt8 = unitExt8 == null ? null : unitExt8.trim();
    }

    public String getUnitExt9() {
        return unitExt9;
    }

    public void setUnitExt9(String unitExt9) {
        this.unitExt9 = unitExt9 == null ? null : unitExt9.trim();
    }
}