package com.inossem.wms.model.dic;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.dic.DicNoticeListVo", description="通知外层key")
public class DicNoticeListVo implements IPageResultCommon{
	//分页总数
	@ApiModelProperty(value = "总页数",example="2")
	private int totalCount;
	
	//公告列表
	@ApiModelProperty(value = "通知集合")
	private List<DicNoticeVo> dicNoticeList;
	
	public List<DicNoticeVo> getDicNoticeList() {
		return dicNoticeList;
	}

	public void setDicNoticeList(List<DicNoticeVo> dicNoticeList) {
		this.dicNoticeList = dicNoticeList;
	}

	@Override
	public int getTotalCount() {
		return this.totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
	}
	
}
