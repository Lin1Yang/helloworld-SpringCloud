package com.inossem.wms.vo.auth;

import java.io.Serializable;

public class SccAuthUserVo implements Serializable {
	/**  */
	private static final long serialVersionUID = -1461139146992651115L;
	private String userId;

	private String userName;

	private String corpCode;

	private String corpName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
