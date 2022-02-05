package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModelProperty;

public class DicDeleteCheckCo {
	
	@ApiModelProperty(value = "公司编码", name = "corpCode", example = "9000")
    private String corpCode;
	
	@ApiModelProperty(value = "工厂编码", name = "ftyCode", example = "9000")
    private String ftyCode;

    @ApiModelProperty(value = "库存地点编码", name = "locationCode", example = "0001")
    private String locationCode;
    
    @ApiModelProperty(value = "仓库编码", name = "whCode", example = "S01")
    private String whCode;

    @ApiModelProperty(value = "存储类型编码", name = "typeCode", example = "001")
    private String typeCode;
    
    @ApiModelProperty(value = "存储区编码", name = "sectionCode", example = "001")
    private String sectionCode;

    @ApiModelProperty(value = "仓位", name = "binCode", example = "01-01-01")
    private String binCode;
    
    @ApiModelProperty(value = "托盘", name = "cellCode", example = "t001")
    private String cellCode;
    
    @ApiModelProperty(value = "单位编码", name = "unitCode", example = "KG")
    private String unitCode;
    
    @ApiModelProperty(value = "物料编码", name = "matCode", example = "60000001")
    private String matCode;

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getFtyCode() {
		return ftyCode;
	}

	public void setFtyCode(String ftyCode) {
		this.ftyCode = ftyCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}	

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getBinCode() {
		return binCode;
	}

	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}	

	public String getCellCode() {
		return cellCode;
	}

	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}
    
    

}
