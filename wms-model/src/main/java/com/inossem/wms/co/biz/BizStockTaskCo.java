package com.inossem.wms.co.biz;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.biz.BizStockTaskCo", description="仓库整理对象")
public class BizStockTaskCo {
	@ApiModelProperty(value="仓库整理行项目", name="", example="")
	private List<BizStockTaskItemCo> itemList;
	@ApiModelProperty(value="仓库号", name="", example="")
	private String whCode;
	@ApiModelProperty(value="源存储类型", name="", example="")
	private String sourceTypeCode;
	@ApiModelProperty(value="源仓位", name="", example="")
	private String sourceBinCode;
	@ApiModelProperty(value="源存储单元", name="", example="")
	private String sourceCellCode;
	@ApiModelProperty(value="目标存储类型", name="", example="")
	private String targetTypeCode;
	@ApiModelProperty(value="目标仓位", name="", example="")
	private String targetBinCode;
	@ApiModelProperty(value="目标存储单元", name="", example="")
	private String targetCellCode;

	public List<BizStockTaskItemCo> getItemList() {
		return itemList;
	}

	public void setItemList(List<BizStockTaskItemCo> itemList) {
		this.itemList = itemList;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getSourceTypeCode() {
		return sourceTypeCode;
	}

	public void setSourceTypeCode(String sourceTypeCode) {
		this.sourceTypeCode = sourceTypeCode;
	}

	public String getSourceBinCode() {
		return sourceBinCode;
	}

	public void setSourceBinCode(String sourceBinCode) {
		this.sourceBinCode = sourceBinCode;
	}

	public String getSourceCellCode() {
		return sourceCellCode;
	}

	public void setSourceCellCode(String sourceCellCode) {
		this.sourceCellCode = sourceCellCode;
	}

	public String getTargetTypeCode() {
		return targetTypeCode;
	}

	public void setTargetTypeCode(String targetTypeCode) {
		this.targetTypeCode = targetTypeCode;
	}

	public String getTargetBinCode() {
		return targetBinCode;
	}

	public void setTargetBinCode(String targetBinCode) {
		this.targetBinCode = targetBinCode;
	}

	public String getTargetCellCode() {
		return targetCellCode;
	}

	public void setTargetCellCode(String targetCellCode) {
		this.targetCellCode = targetCellCode;
	}	
}
