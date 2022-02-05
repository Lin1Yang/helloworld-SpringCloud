package com.inossem.wms.model.sinobec.query;

import java.math.BigDecimal;
import java.util.List;

import com.inossem.wms.model.sinobec.stock.SinobecStockVo;

import com.inossem.wms.page.IPageResultCommon;
import io.swagger.annotations.ApiModel;
@ApiModel(value="com.inossem.wms.model.sinobec.query.StockBinVo",description="库存查询返回仓位库存对象")
public class StockBinVo  implements IPageResultCommon  {

	private String whCode;
	private String typeCode;
	private String binCode;
	private String matName;
	private String typeName;
	private String binWeightUnitCode;
	private BigDecimal currentWeight;
	private BigDecimal weightMax;

	private String corp_code_ins;
	private String corp_code_gp;
	private BigDecimal weight_qty_ins;
	private BigDecimal receipt_qty_ins;
	private BigDecimal weight_qty_gp;
	private BigDecimal receipt_qty_gp;
	private List<SinobecStockVo> bundleList;
	private int totalCount;

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
	public String getBinCode() {
		return binCode;
	}
	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getBinWeightUnitCode() {
		return binWeightUnitCode;
	}
	public void setBinWeightUnitCode(String binWeightUnitCode) {
		this.binWeightUnitCode = binWeightUnitCode;
	}
	public BigDecimal getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(BigDecimal currentWeight) {
		this.currentWeight = currentWeight;
	}
	public BigDecimal getWeightMax() {
		return weightMax;
	}
	public void setWeightMax(BigDecimal weightMax) {
		this.weightMax = weightMax;
	}
	public List<SinobecStockVo> getBundleList() {
		return bundleList;
	}
	public void setBundleList(List<SinobecStockVo> bundleList) {
		this.bundleList = bundleList;
	}

	public String getCorp_code_ins() {
		return corp_code_ins;
	}

	public void setCorp_code_ins(String corp_code_ins) {
		this.corp_code_ins = corp_code_ins;
	}

	public String getCorp_code_gp() {
		return corp_code_gp;
	}

	public void setCorp_code_gp(String corp_code_gp) {
		this.corp_code_gp = corp_code_gp;
	}

	public BigDecimal getWeight_qty_ins() {
		return weight_qty_ins;
	}

	public void setWeight_qty_ins(BigDecimal weight_qty_ins) {
		this.weight_qty_ins = weight_qty_ins;
	}

	public BigDecimal getReceipt_qty_ins() {
		return receipt_qty_ins;
	}

	public void setReceipt_qty_ins(BigDecimal receipt_qty_ins) {
		this.receipt_qty_ins = receipt_qty_ins;
	}

	public BigDecimal getWeight_qty_gp() {
		return weight_qty_gp;
	}

	public void setWeight_qty_gp(BigDecimal weight_qty_gp) {
		this.weight_qty_gp = weight_qty_gp;
	}

	public BigDecimal getReceipt_qty_gp() {
		return receipt_qty_gp;
	}

	public void setReceipt_qty_gp(BigDecimal receipt_qty_gp) {
		this.receipt_qty_gp = receipt_qty_gp;
	}

	private int hash;

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.whCode == null ? 0 : this.whCode.hashCode();

			h = 13131 * h + (this.typeCode == null ? 0 : this.typeCode.hashCode());

			h = 13131 * h + (this.binCode == null ? 0 : this.binCode.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof StockBinVo) {
			StockBinVo another = (StockBinVo) obj;
			if (this.whCode == null || this.typeCode == null || this.binCode == null) {
				return false;
			} else if (this.whCode.equalsIgnoreCase(another.whCode) && this.typeCode.equalsIgnoreCase(another.typeCode)
					&& this.binCode.equalsIgnoreCase(another.binCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	@Override
	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}
}
