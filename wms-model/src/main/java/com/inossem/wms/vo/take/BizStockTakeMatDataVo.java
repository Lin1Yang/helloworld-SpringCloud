package com.inossem.wms.vo.take;

import java.util.List;

import com.inossem.wms.vo.sinobec.SinobecDicWhStorageTypeVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.take.BizStockTakeMatDataVo", description="盘点对象")
public class BizStockTakeMatDataVo{
	
	@ApiModelProperty(value="生成的Ins凭证行的对象集合WEB", name="", example="")
	private List<BizStockTakeMatItemVo> itemList;
	@ApiModelProperty(value="生成的Ins凭证行的对象集合PDA", name="", example="")
	List<SinobecDicWhStorageTypeVo> typeList;

	@ApiModelProperty(value="head对象集合", name="", example="")
	private BizStockTakeMatHeadVo head;
	
	@ApiModelProperty(value = "记录数")
	private Integer totalCount;

	public List<BizStockTakeMatItemVo> getItemList() {
		return itemList;
	}

	public void setItemList(List<BizStockTakeMatItemVo> itemList) {
		this.itemList = itemList;
	}

	public BizStockTakeMatHeadVo getHead() {
		return head;
	}

	public void setHead(BizStockTakeMatHeadVo head) {
		this.head = head;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<SinobecDicWhStorageTypeVo> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<SinobecDicWhStorageTypeVo> typeList) {
		this.typeList = typeList;
	}
}
