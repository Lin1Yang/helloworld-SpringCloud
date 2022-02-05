package com.inossem.wms.vo;

public class KeyValueObject<T> {

	private T key;
	
	private String value;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
