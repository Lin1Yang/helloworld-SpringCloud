package com.inossem.wms.vo.take;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.take.BizStockTakeDataVo", description="盘点对象")
public class BizStockTakeDataVo{
	
	@ApiModelProperty(value="生成的Ins凭证行的对象集合", name="", example="")
	private List<BizStockTakeItemVo> itemList;
	
	@ApiModelProperty(value="head对象集合", name="", example="")
	private BizStockTakeHeadVo head;
	
	@ApiModelProperty(value="sap 单据提供的 document number", name="", example="")
	private String documentNumber;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public List<BizStockTakeItemVo> getItemList() {
		return itemList;
	}

	public void setItemList(List<BizStockTakeItemVo> itemList) {
		this.itemList = itemList;
	}

	public BizStockTakeHeadVo getHead() {
		return head;
	}

	public void setHead(BizStockTakeHeadVo head) {
		this.head = head;
	}
}
