package com.inossem.wms.common.auth;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyUsernamePasswordToken extends UsernamePasswordToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5097059819178691077L;
	
	
	private String corpCode;


	public String getCorpCode() {
		return corpCode;
	}


	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	
	public MyUsernamePasswordToken(final String username, final String password) {
        super(username, password != null ? password.toCharArray() : null, false, null);
    }

}
