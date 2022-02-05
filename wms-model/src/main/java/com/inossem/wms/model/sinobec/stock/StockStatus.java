package com.inossem.wms.model.sinobec.stock;

import java.math.BigDecimal;


public class StockStatus {

	private String sku;

	private String vin;
	
	private String engine;
	
	private BigDecimal actQty;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public BigDecimal getActQty() {
		return actQty;
	}

	public void setActQty(BigDecimal actQty) {
		this.actQty = actQty;
	}
	
	
}
