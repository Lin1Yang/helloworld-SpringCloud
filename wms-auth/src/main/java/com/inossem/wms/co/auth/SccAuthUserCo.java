package com.inossem.wms.co.auth;

public class SccAuthUserCo {
	
	/** 用户账号 */
	private String userCode;
	/** 密码 */
	private String credential;
	
	/** 认证类型， 
	 * 0表示只验证用户账号密码，不做用类型判断；
	 * 1表示SCC认证供应商用户；
	 * 2表示SCC认证客户用户；
	 * 3表示SCC认证内部用户；
	 */
	private Byte authType;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public Byte getAuthType() {
		return authType;
	}

	public void setAuthType(Byte authType) {
		this.authType = authType;
	}

}
