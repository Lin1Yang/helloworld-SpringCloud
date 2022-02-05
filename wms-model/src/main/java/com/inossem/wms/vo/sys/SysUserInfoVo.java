package com.inossem.wms.vo.sys;

import java.util.List;

import com.inossem.wms.vo.dic.DicCorpVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.sys.SysUserInfoVo", description="用户角色和库存地点信息对象")
public class SysUserInfoVo extends SysUserVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3742508927543141610L;

	@ApiModelProperty(value="用户已经分配的角色", name="SysRelUserRoleVoList", required=true)
	private	List<SysRelUserRoleVo> SysRelUserRoleVoList;
	
	@ApiModelProperty(value="用户没有被分配的角色", name="sysRoleVoList", required=true)
	private List<SysRoleVo> sysRoleVoList;

	private List<DicCorpVo> sysRelCorpList;

	private List<DicCorpVo> sysCorpList;

	
	


	public List<SysRelUserRoleVo> getSysRelUserRoleVoList() {
		return SysRelUserRoleVoList;
	}

	public void setSysRelUserRoleVoList(List<SysRelUserRoleVo> sysRelUserRoleVoList) {
		SysRelUserRoleVoList = sysRelUserRoleVoList;
	}

	public List<SysRoleVo> getSysRoleVoList() {
		return sysRoleVoList;
	}

	public void setSysRoleVoList(List<SysRoleVo> sysRoleVoList) {
		this.sysRoleVoList = sysRoleVoList;
	}

	


	public static long getSerialversionuid() {
		return serialVersionUID;
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
