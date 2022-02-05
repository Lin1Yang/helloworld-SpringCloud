package com.inossem.wms.co.sys;

import java.util.List;

import com.inossem.wms.vo.dic.DicCorpVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserCorpDeptFtyLocTreeVo", description="公司工厂部门库存地点树")
public class SysUserCorpDeptFtyLocTreeVo {
	
	@ApiModelProperty(value="公司集合", name="corpVoList", required=true)
	private List<DicCorpVo> corpVoList;
	
	public List<DicCorpVo> getCorpVoList() {
		return corpVoList;
	}

	public void setCorpVoList(List<DicCorpVo> corpVoList) {
		this.corpVoList = corpVoList;
	}
	
	

}
