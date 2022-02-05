package com.inossem.wms.model.sinobec.gp;

import java.util.List;

public class ResponseInfo {

	private String apiFunctions;
	private List<String> compeletedDns;
	private List<String> rejectedDns;
	private String compeletedDn;
	private String rejectedDn;
	private String exceptionMessage;
	private Object result;
	
	public ResponseInfo(String apiFunctions, List<String> compeletedDns, List<String> rejectedDns) {
		super();
		this.apiFunctions = apiFunctions;
		this.compeletedDns = compeletedDns;
		this.rejectedDns = rejectedDns;
	}
	
	public ResponseInfo(String apiFunctions, List<String> compeletedDns, List<String> rejectedDns, String compeletedDn, String rejectedDn, String exceptionMessage) {
		super();
		this.apiFunctions = apiFunctions;
		this.compeletedDns = compeletedDns;
		this.rejectedDns = rejectedDns;
		this.compeletedDn = compeletedDn;
		this.rejectedDn = rejectedDn;
		this.exceptionMessage = exceptionMessage;
	}

	public String getApiFunctions() {
		return apiFunctions;
	}

	public void setApiFunctions(String apiFunctions) {
		this.apiFunctions = apiFunctions;
	}

	public List<String> getCompeletedDns() {
		return compeletedDns;
	}

	public void setCompeletedDns(List<String> compeletedDns) {
		this.compeletedDns = compeletedDns;
	}

	public List<String> getRejectedDns() {
		return rejectedDns;
	}

	public void setRejectedDns(List<String> rejectedDns) {
		this.rejectedDns = rejectedDns;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getCompeletedDn() {
		return compeletedDn;
	}

	public void setCompeletedDn(String compeletedDn) {
		this.compeletedDn = compeletedDn;
	}
	public String getRejectedDn() {
		return rejectedDn;
	}
	public void setRejectedDn(String rejectedDn) {
		this.rejectedDn = rejectedDn;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
}
