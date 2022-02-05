package com.inossem.wms.model.sinobec.task;

import java.io.Serializable;
import java.math.BigDecimal;

import com.inossem.wms.model.sinobec.SinobecBizTask;
import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;

@ApiModel(value="com.inossem.wms.model.sinobec.task.SinobecTaskVo",description="作业单行项目对象")
public class SinobecTaskVo extends SinobecBizTask implements IPageResultCommon, Serializable{

	

	private String matName;
	
	private String status;
	
	
	private int totalCount;

	private String whCode;  //2021-10-07  新加
	/**
	 * 
	 */
	private static final long serialVersionUID = -3932811794857114498L;

	
		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int getTotalCount() {

		return totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

	}
	
	
	
	private BigDecimal binWeightQty;
	
	private Integer stockId;
	
	/**确认存储类型*/
	private String confirmTypeCode;
	/**确认仓位*/
	private String confirmBinCode;
	
	private String receiptStatusName;
	
	private String createUserName;
	
	private String sourceTypeName;
	
	private String targetTypeName;

	public BigDecimal getBinWeightQty() {
		return binWeightQty;
	}

	public void setBinWeightQty(BigDecimal binWeightQty) {
		this.binWeightQty = binWeightQty;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getConfirmTypeCode() {
		return confirmTypeCode;
	}

	public void setConfirmTypeCode(String confirmTypeCode) {
		this.confirmTypeCode = confirmTypeCode;
	}

	public String getConfirmBinCode() {
		return confirmBinCode;
	}

	public void setConfirmBinCode(String confirmBinCode) {
		this.confirmBinCode = confirmBinCode;
	}

	public String getReceiptStatusName() {
		return receiptStatusName;
	}

	public void setReceiptStatusName(String receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getSourceTypeName() {
		return sourceTypeName;
	}

	public void setSourceTypeName(String sourceTypeName) {
		this.sourceTypeName = sourceTypeName;
	}

	public String getTargetTypeName() {
		return targetTypeName;
	}

	public void setTargetTypeName(String targetTypeName) {
		this.targetTypeName = targetTypeName;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	@Override
	public String getWhCode() {
		return whCode;
	}        //2021-10-07  新加

	@Override
	public void setWhCode(String whCode) {
		this.whCode = whCode == null ? null : whCode.trim();
	}    //2021-10-07  新加
}
