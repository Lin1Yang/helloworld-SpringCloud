package com.inossem.wms.page;

public interface IPageCommon extends IPageResultCommon {
	public boolean isSortAscend();

	public void setSortAscend(boolean sortAscend);

	public void setSortAscend(String sortAscend);

	public String getSortColumn();

	public void setSortColumn(String sortColumn);

	public boolean isPaging();

	public void setPaging(boolean paging);

	public int getPageIndex();

	public void setPageIndex(int pageIndex);

	public int getPageSize();

	public void setPageSize(int pageSize);

	public int getTotalCount();

	public void setTotalCount(int totalCount);
}
