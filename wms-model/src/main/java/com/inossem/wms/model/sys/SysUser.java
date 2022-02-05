package com.inossem.wms.model.sys;

import java.io.Serializable;
import java.util.Date;

import com.inossem.wms.annotation.FieldAlias;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.sys.SysUser", description="用户信息对象")
public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2813200541019902584L;
	@ApiModelProperty(value = "用户ID", name = "userId", example = "0", required = true)
	@FieldAlias({ "operatorId", "userId" })
	private Integer userId;

	@ApiModelProperty(value = "用户编码", name = "userCode", example = "admin", required = true)
	private String userCode;

	@ApiModelProperty(value = "用户名称", name = "userName", example = "测试添加", required = true)
	@FieldAlias({ "operatorName", "userName" })
	private String userName;

	@ApiModelProperty(value = "用户密码", name = "password", example = "123456", required = true)
	private String password;

	@ApiModelProperty(value = "用户类型  10内部用户， 20外部供应商，30外部客户用户，40外部业务用户，50接口用户", name = "userType", example = "10", required = true)
	private Byte userType;

	@ApiModelProperty(value = "组织ID", name = "orgCode", example = "0", required = true)
	private String orgCode;

	@ApiModelProperty(value = "删除标识，0-否，1-是", name = "isDelete", example = "0", required = true)
	private Byte isDelete;

	@ApiModelProperty(value = "锁定标识 是否被锁定 0-FALSE 1-true", name = "isLocked", example = "0", required = true)
	private Byte isLocked;

	@ApiModelProperty(value = "冻结标识 0-冻结，1-正常", name = "freeze", example = "0", required = true)
	private Byte freeze;

	@ApiModelProperty(value = "创建时间", name = "createTime", example = "2018-12-24 12:24:24", required = true)
	private Date createTime;

	@ApiModelProperty(value = "修改时间", name = "modifyTime", example = "2018-12-24 12:24:24", required = true)
	private Date modifyTime;

	@ApiModelProperty(value = "用户创建人Id", name = "createUserId", example = "0", required = true)
	private Integer createUserId;

	@ApiModelProperty(value = "用户修改人Id", name = "modifyUserId", example = "0", required = true)
	private Integer modifyUserId;

	@ApiModelProperty(value = "上次登录时间", name = "lastLogin", example = "2018-12-24 12:24:24", required = true)
	private Date lastLogin;

	@ApiModelProperty(value = "登录错误重试次数", name = "failAttempts", example = "0", required = true)
	private Integer failAttempts;

	@ApiModelProperty(value = "上次登录错误时间", name = "lastFailAttempt", example = "2018-12-24 12:24:24", required = true)
	private Date lastFailAttempt;

	@ApiModelProperty(value = "用户有效期始", name = "validityBeginDate", example = "2018-12-24", required = true)
	private Date validityBeginDate;

	@ApiModelProperty(value = "用户有效期止", name = "validityEndDate", example = "2018-12-26", required = true)
	private Date validityEndDate;

	@ApiModelProperty(value = "员工ID", name = "employeeCode", example = "0000001", required = true)
	private String employeeCode;

	@ApiModelProperty(value = "岗位", name = "userPost", example = "开发", required = true)
	private String userPost;

	@ApiModelProperty(value = "公司编码", name = "corpCode", example = "9000", required = true)
	private String corpCode;

	@ApiModelProperty(value = "部门编码", name = "deptCode", example = "1121", required = true)
	private String deptCode;

	@ApiModelProperty(value = "是否单点登录，0-否，1-是", name = "isSyn", example = "0", required = true)
	private Byte isSyn;
	
	@ApiModelProperty(value = "手机号", name = "phoneNumber", example = "13110001234", required = true)
	private String phoneNumber;

	@ApiModelProperty(value = "邮箱", name = "email", example = "lan@inossem.com", required = true)
	private String email;

	private String userExt0;

	private String userExt1;

	private String userExt2;

	private String userExt3;

	private String userExt4;

	private String userExt5;

	private String userExt6;

	private String userExt7;

	private String userExt8;

	private String userExt9;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode == null ? null : orgCode.trim();
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getFailAttempts() {
		return failAttempts;
	}

	public void setFailAttempts(Integer failAttempts) {
		this.failAttempts = failAttempts;
	}

	public Date getLastFailAttempt() {
		return lastFailAttempt;
	}

	public void setLastFailAttempt(Date lastFailAttempt) {
		this.lastFailAttempt = lastFailAttempt;
	}

	public String getUserExt0() {
		return userExt0;
	}

	public void setUserExt0(String userExt0) {
		this.userExt0 = userExt0 == null ? null : userExt0.trim();
	}

	public String getUserExt1() {
		return userExt1;
	}

	public void setUserExt1(String userExt1) {
		this.userExt1 = userExt1 == null ? null : userExt1.trim();
	}

	public String getUserExt2() {
		return userExt2;
	}

	public void setUserExt2(String userExt2) {
		this.userExt2 = userExt2 == null ? null : userExt2.trim();
	}

	public String getUserExt3() {
		return userExt3;
	}

	public void setUserExt3(String userExt3) {
		this.userExt3 = userExt3 == null ? null : userExt3.trim();
	}

	public String getUserExt4() {
		return userExt4;
	}

	public void setUserExt4(String userExt4) {
		this.userExt4 = userExt4 == null ? null : userExt4.trim();
	}

	public String getUserExt5() {
		return userExt5;
	}

	public void setUserExt5(String userExt5) {
		this.userExt5 = userExt5 == null ? null : userExt5.trim();
	}

	public String getUserExt6() {
		return userExt6;
	}

	public void setUserExt6(String userExt6) {
		this.userExt6 = userExt6 == null ? null : userExt6.trim();
	}

	public String getUserExt7() {
		return userExt7;
	}

	public void setUserExt7(String userExt7) {
		this.userExt7 = userExt7 == null ? null : userExt7.trim();
	}

	public String getUserExt8() {
		return userExt8;
	}

	public void setUserExt8(String userExt8) {
		this.userExt8 = userExt8 == null ? null : userExt8.trim();
	}

	public String getUserExt9() {
		return userExt9;
	}

	public void setUserExt9(String userExt9) {
		this.userExt9 = userExt9 == null ? null : userExt9.trim();
	}

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}

	public Byte getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Byte isLocked) {
		this.isLocked = isLocked;
	}

	public Byte getFreeze() {
		return freeze;
	}

	public void setFreeze(Byte freeze) {
		this.freeze = freeze;
	}

	public Date getValidityBeginDate() {
		return validityBeginDate;
	}

	public void setValidityBeginDate(Date validityBeginDate) {
		this.validityBeginDate = validityBeginDate;
	}

	public Date getValidityEndDate() {
		return validityEndDate;
	}

	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Byte getIsSyn() {
		return isSyn;
	}

	public void setIsSyn(Byte isSyn) {
		this.isSyn = isSyn;
	}

	public static String getCredentialsSalt() {
		return "!@#$rewq";
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}