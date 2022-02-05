package com.inossem.wms.vo.dic;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class DicWhStorageTypeStrategyVo{
	
	@ApiModelProperty(value="入库列表", name="", example="")
    private List<DicWhStorageTypeCodeVo> inputputStrategyList;
	
	@ApiModelProperty(value="出库列表", name="", example="")
    private List<DicWhStorageTypeCodeVo> outputStrategyList;
	
	@ApiModelProperty(value="入库策略列表", name="", example="")
    private List<DicWhStorageTypeCodeVo> inputAbilityInspectList;

	public List<DicWhStorageTypeCodeVo> getInputputStrategyList() {
		return inputputStrategyList;
	}

	public void setInputputStrategyList(List<DicWhStorageTypeCodeVo> inputputStrategyList) {
		this.inputputStrategyList = inputputStrategyList;
	}

	public List<DicWhStorageTypeCodeVo> getOutputStrategyList() {
		return outputStrategyList;
	}

	public void setOutputStrategyList(List<DicWhStorageTypeCodeVo> outputStrategyList) {
		this.outputStrategyList = outputStrategyList;
	}

	public List<DicWhStorageTypeCodeVo> getInputAbilityInspectList() {
		return inputAbilityInspectList;
	}

	public void setInputAbilityInspectList(List<DicWhStorageTypeCodeVo> inputAbilityInspectList) {
		this.inputAbilityInspectList = inputAbilityInspectList;
	}
}
