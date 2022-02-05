package com.inossem.wms.co.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicWhStorageSection;
import com.inossem.wms.page.IPageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 存储区参数类
 * @author cdq
 */
@ApiModel(value="com.inossem.wms.co.dic.DicWhStorageSectionCo", description="这是存储区映射类")
public class DicWhStorageSectionCo extends DicWhStorageSection implements IPageCommon{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3747000687819694333L;

	@ApiModelProperty(value="国际化语言设置列表", name="dicTextList", required=true, reference = "com.inossem.wms.co.dic.DicTextCo")
	private List<DicTextCo> dicTextList;

	// 是否分页
    @ApiModelProperty(value = "是否分页,false不分页,true分页", name = "paging", example = "true", required = true)
	private boolean paging = false;

	@ApiModelProperty(value = "每页记录数", name = "pageSize", example = "10")
	private int pageSize;

	@ApiModelProperty(value = "页序号", name = "pageIndex", example = "1")
	private int pageIndex;

	@ApiModelProperty(value = "总记录数", name = "totalCount", example = "-1")
	private int totalCount = -1;

	@ApiModelProperty(value = "排序true为正序，false为倒序", name = "sortAscend", example = "true")
	private boolean sortAscend;

	@ApiModelProperty(value = "排序列", name = "sortColumn", example = "")
	private String sortColumn;
	
	//**start   查询条件附加条件
	@ApiModelProperty(value = "仓库描述", example = "中心仓库")
	private String whName;
	
	@ApiModelProperty(value = "存储类型描述", example = "高位存储区")
	private String typeName;
	public List<DicTextCo> getDicTextList() {
		return dicTextList;
	}

	public void setDicTextList(List<DicTextCo> dicTextList) {
		this.dicTextList = dicTextList;
	}

	public boolean isPaging() {
		return paging;
	}

	public void setPaging(boolean paging) {
		this.paging = paging;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isSortAscend() {
		return sortAscend;
	}

	public void setSortAscend(boolean sortAscend) {
		this.sortAscend = sortAscend;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	@Override
	public void setSortAscend(String sortAscend) {
		
	}

	
	
}
