package com.inossem.wms.vo.actor;

import java.util.ArrayList;
import java.util.List;

import com.inossem.wms.model.biz.BizReceiptActor;
import com.inossem.wms.model.sys.SysUser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.actor.BizReceiptActorVo", description="单据经办人出参对象")
public class BizReceiptActorVo extends BizReceiptActor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3822940365767421313L;
	@ApiModelProperty(value="经办人姓名", name="operatorName", example="管理员")
	private String operatorName;
	@ApiModelProperty(value="创建人姓名", name="creatorName", example="管理员")
	private String creatorName;
	@ApiModelProperty(value="审阅人姓名", name="approverName", example="审阅人")
	private String approverName;
	@ApiModelProperty(value="岗位描述", name="postName", example="管理岗")
	private String postName;
	@ApiModelProperty(value="单据类型描述", name="receiptTypeName", example="管理岗")
	private String receiptTypeName;
	@ApiModelProperty(value="机构编码", name="deptCode", example="管理岗")
	private String deptCode;
	@ApiModelProperty(value="机构描述", name="deptName", example="管理岗")
	private String deptName;
	@ApiModelProperty(value="机构是否会签", name="counterSign")
	private String countersign;
	@ApiModelProperty(value="待经办的数量", name="num")
	private int num;
	@ApiModelProperty(value="user列表", name="userList")
	private List<SysUser> userList;
	
	
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getReceiptTypeName() {
		return receiptTypeName;
	}

	public void setReceiptTypeName(String receiptTypeName) {
		this.receiptTypeName = receiptTypeName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<SysUser> getUserList() {
		if(userList==null){
			userList = new ArrayList<>();
		}
		return userList;
	}

	public void setUserList(List<SysUser> userList) {
		this.userList = userList;
	}

	public String getCountersign() {
		return countersign;
	}

	public void setCountersign(String countersign) {
		this.countersign = countersign;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
