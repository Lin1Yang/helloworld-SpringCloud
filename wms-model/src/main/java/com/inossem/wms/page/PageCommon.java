package com.inossem.wms.page;

import com.inossem.wms.constant.Const;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PageCommon implements IPageCommon,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6741195596168785361L;

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

	@Override
	public boolean isSortAscend() {
		return sortAscend;
	}

	@Override
	public void setSortAscend(boolean sortAscend) {
		this.sortAscend = sortAscend;
	}

	@Override
	public void setSortAscend(String sortAscend) {
		
		if (Const.PAGE_ASC.equalsIgnoreCase(sortAscend.trim())) {
			this.sortAscend = true;
		} else {
			this.sortAscend = false;
		}
	}

	@Override
	public String getSortColumn() {
		return sortColumn;
	}

	@Override
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	@Override
	public boolean isPaging() {
		return paging;
	}

	@Override
	public void setPaging(boolean paging) {
		this.paging = paging;
	}

	@Override
	public int getPageIndex() {
		return pageIndex;
	}

	@Override
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
