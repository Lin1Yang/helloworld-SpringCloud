package com.inossem.wms.vo.dic;

import java.util.ArrayList;
import java.util.List;

import com.inossem.wms.model.dic.DicLanguage;
import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicMaterialManageListVo", description="物料主数据列表返回信息对象")
public class DicMaterialManageListVo implements IPageResultCommon{
	
	@ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
	private int totalCount; 
	
	@ApiModelProperty(value="物料拓展信息集合")
	private List<DicMaterialManageVo> headList = new ArrayList<DicMaterialManageVo>();
	
	@ApiModelProperty(value="语言类型集合")
	private List<DicLanguage> languageList = new ArrayList<DicLanguage>();


	
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicMaterialManageVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<DicMaterialManageVo> headList) {
		this.headList = headList;
	}

	public List<DicLanguage> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<DicLanguage> languageList) {
		this.languageList = languageList;
	}

	
	
	

}
