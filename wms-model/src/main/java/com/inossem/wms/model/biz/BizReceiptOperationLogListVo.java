package com.inossem.wms.model.biz;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value=" com.inossem.wms.model.biz.BizReceiptOperationLogListVo", description="操作日志返回外层对象")
public class BizReceiptOperationLogListVo  implements IPageResultCommon {
	@ApiModelProperty(value="操作日志集合列表")
	private List<BizReceiptOperationLogVo> list;
	@ApiModelProperty(value="总数量")
    private int totalCount;
	@Override
	public int getTotalCount() {
		return this.totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		
	}

	public List<BizReceiptOperationLogVo> getList() {
		return list;
	}

	public void setList(List<BizReceiptOperationLogVo> list) {
		this.list = list;
	}




}