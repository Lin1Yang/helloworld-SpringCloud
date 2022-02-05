package com.inossem.wms.vo.sinobec;

import java.util.List;

import com.inossem.wms.model.sinobec.stock.SinobecStockVo;

public class SinobecCartonGroupVo {

	private String weightQty;
	
	private List<SinobecStockVo> stockList;
	
	private boolean matched ;

	public String getWeightQty() {
		return weightQty;
	}

	public void setWeightQty(String weightQty) {
		this.weightQty = weightQty;
	}

	public List<SinobecStockVo> getStockList() {
		return stockList;
	}

	public void setStockList(List<SinobecStockVo> stockList) {
		this.stockList = stockList;
	}

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	
	
	
	
}
