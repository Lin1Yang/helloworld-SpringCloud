package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicWhStorageSection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicWhStorageSectionListVo", description="存储区返回的总对象")
public class DicWhStorageSectionListVo extends DicWhStorageSection {
	/**
	 * 
	 */
	private static final long serialVersionUID = -792801246527551247L;

	@ApiModelProperty(value="分页总条数",example="20")
	private int totalCount;
	
	@ApiModelProperty(value="存储区返回的集合")
	private List<DicWhStorageSectionVo> list;


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public List<DicWhStorageSectionVo> getList() {
		return list;
	}


	public void setList(List<DicWhStorageSectionVo> list) {
		this.list = list;
	}
	
	
	
}
