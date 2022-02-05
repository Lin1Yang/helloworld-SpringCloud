package com.inossem.wms.co.sys;

import java.util.List;

import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.vo.dic.DicCorpVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserInfoCo", description="用户信息保存对象")
public class SysUserInfoCo extends SysUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = -313209681537476973L;

	private List<DicCorpVo> sysRelCorpList;

	private List<DicCorpVo> sysCorpList;

	@ApiModelProperty(value="外部用户对应供应商和客户对象编码", name="outsideCode", example="0001",required=true)
    private String outsideCode;

	@ApiModelProperty(value="外部用户对应供应商和客户对象描述", name="outsideName", example="零零零一",required=true)
    private String outsideName;
	
	
	
	@ApiModelProperty(value="用户分配的角色", name="sysRelUserRoleInfoCos", required=true)
	private	List<SysRelUserRoleInfoCo> SysRelUserRoleVoList;
	
	@ApiModelProperty(value="查询条件", name="用户Code和Name", required=false)
	private	String condition;
	
	@ApiModelProperty(value="仓库号")
	private	String whCode;

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



	

	public List<SysRelUserRoleInfoCo> getSysRelUserRoleVoList() {
		return SysRelUserRoleVoList;
	}

	public void setSysRelUserRoleVoList(List<SysRelUserRoleInfoCo> sysRelUserRoleVoList) {
		SysRelUserRoleVoList = sysRelUserRoleVoList;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public List<DicCorpVo> getSysRelCorpList() {
		return sysRelCorpList;
	}

	public void setSysRelCorpList(List<DicCorpVo> sysRelCorpList) {
		this.sysRelCorpList = sysRelCorpList;
	}

	public List<DicCorpVo> getSysCorpList() {
		return sysCorpList;
	}

	public void setSysCorpList(List<DicCorpVo> sysCorpList) {
		this.sysCorpList = sysCorpList;
	}
}
