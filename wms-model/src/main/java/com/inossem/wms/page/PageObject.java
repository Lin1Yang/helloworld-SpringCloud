package com.inossem.wms.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Gyl
 */
@ApiModel(value = "com.inossem.wms.page.PageObject")
public class PageObject<T> extends PageCommon {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2120338866822597099L;

	public PageObject(List<T> itemList, PageCommon pageCommon){
        this.itemList = itemList;
        this.setPageIndex(pageCommon.getPageIndex());
        this.setPageSize(pageCommon.getPageSize());
        this.setPaging(pageCommon.isPaging());
        this.setSortColumn(pageCommon.getSortColumn());
        this.setTotalCount(pageCommon.getTotalCount());
        if(this.itemList!=null && this.itemList.size()>0){
            Object o = this.itemList.get(0);
            PageCommon temp=(PageCommon)o;
            this.setTotalCount(temp.getTotalCount());
        }else{
            this.setTotalCount(0);
        }
    }
    @ApiModelProperty(name="itemList",value = "查询结果列表",required = true)
    private List<T> itemList;

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }
}
