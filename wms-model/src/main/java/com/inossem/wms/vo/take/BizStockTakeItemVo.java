package com.inossem.wms.vo.take;

import com.inossem.wms.model.sinobec.take.SinobecBizStockTake;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.take.BizStockTakeItemVo", description="盘点对象")
public class BizStockTakeItemVo  extends SinobecBizStockTake {

	
	@ApiModelProperty(value = "总记录数", example = "0")
	private int totalCount;
	@ApiModelProperty(value = "仓库名称")
	private String whName;
	@ApiModelProperty(value = "存储类型名称")
	private String typeName;
	@ApiModelProperty(value = "仓位是否使用")
	private byte used;
	@ApiModelProperty(value = "用户名称")
	private String userName;
	
	@ApiModelProperty(value="sap 单据提供的 document number")
	private String documentNumber;

	private Byte freezeOutput;

	private Byte freezeInput;

	private int num;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public byte getUsed() {
		return used;
	}

	public void setUsed(byte used) {
		this.used = used;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Byte getFreezeOutput() {
		return freezeOutput;
	}

	public void setFreezeOutput(Byte freezeOutput) {
		this.freezeOutput = freezeOutput;
	}

	public Byte getFreezeInput() {
		return freezeInput;
	}

	public void setFreezeInput(Byte freezeInput) {
		this.freezeInput = freezeInput;
	}
	
	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
}
