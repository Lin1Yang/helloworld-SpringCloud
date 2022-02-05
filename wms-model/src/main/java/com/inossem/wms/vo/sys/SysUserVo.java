package com.inossem.wms.vo.sys;

import java.util.Date;

import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.sys.SysUserVo", description="用户信息拓展对象")
public class SysUserVo extends SysUser implements IPageResultCommon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8722663395191728392L;
	
	@ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
	private int totalCount; 
	
	@ApiModelProperty(value="用户类型描述", name="userTypeName",example="内部用户", required=true)
	private String userTypeName; 
	
	@ApiModelProperty(value="组织描述", name="orgCodeName",example="阿萨德", required=true)
	private String orgCodeName; 
	
	@ApiModelProperty(value="是否被锁定描述", name="isLockedName",example="正常", required=true)
	private String isLockedName; 
	
	@ApiModelProperty(value="冻结描述", name="freezeName",example="正常", required=true)
	private String freezeName; 
	
	@ApiModelProperty(value="公司描述", name="corpName",example="英诺森", required=true)
	private String corpName; 
	
	@ApiModelProperty(value="部门描述", name="deptName",example="研发", required=true)
	private String deptName; 
	
	@ApiModelProperty(value="是否单点登录描述", name="isSynName",example="否", required=true)
	private String isSynName; 
	
	@ApiModelProperty(value="用户创建人编码", name="createUserCode",example="admin", required=true)
	private String createUserCode; 
	
	@ApiModelProperty(value="用户创建人描述", name="createUserName",example="admin", required=true)
	private String createUserName; 
	
	@ApiModelProperty(value="用户修改人编码", name="modifyUserCode",example="admin", required=true)
	private String modifyUserCode; 
	
	@ApiModelProperty(value="用户修改人描述", name="modifyUserName",example="admin", required=true)
	private String modifyUserName; 
	
	@ApiModelProperty(value="客户或供应商编码", name="outsideCode",example="00021", required=true)
	private String outsideCode;

	@ApiModelProperty(value="客户或供应商描述", name="outsideName",example="采购", required=true)
	private String outsideName;

	@ApiModelProperty(value="是否被选中(安卓用)", name="isChecked",example="0", required=true)
	private String isChecked;

	private String filePath;
	
	private String fileCode;
	
	@ApiModelProperty(value="审阅人ID", name="approverName", example="审阅人ID")
	private Integer approverId;
	
	@ApiModelProperty(value="审阅人姓名", name="approverName", example="审阅人")
	private String approverName;
	
	@ApiModelProperty(value="审阅人时间", name="approveTime", example="审阅时间")
	private Date approveTime;

	@ApiModelProperty(value = "公司编码", name = "corpCode", example = "9000", required = true)
	private String corpCode;   //2021-10-08 新加

	public Integer getApproverId() {
		return approverId;
	}

	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getOrgCodeName() {
		return orgCodeName;
	}

	public void setOrgCodeName(String orgCodeName) {
		this.orgCodeName = orgCodeName;
	}

	public String getIsLockedName() {
		return isLockedName;
	}

	public void setIsLockedName(String isLockedName) {
		this.isLockedName = isLockedName;
	}

	public String getFreezeName() {
		return freezeName;
	}

	public void setFreezeName(String freezeName) {
		this.freezeName = freezeName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getIsSynName() {
		return isSynName;
	}

	public void setIsSynName(String isSynName) {
		this.isSynName = isSynName;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getModifyUserCode() {
		return modifyUserCode;
	}

	public void setModifyUserCode(String modifyUserCode) {
		this.modifyUserCode = modifyUserCode;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public String getOutsideCode() {
		return outsideCode;
	}

	public void setOutsideCode(String outsideCode) {
		this.outsideCode = outsideCode;
	}

	public String getOutsideName() {
		return outsideName;
	}

	public void setOutsideName(String outsideName) {
		this.outsideName = outsideName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String getCorpCode() {
		return corpCode;
	}       //2021-10-08 新加

	@Override
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}   //2021-10-08 新加

}
