package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicUnit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicUnitVo", description="计量单位出参对象")
public class DicUnitVo extends DicUnit{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5338955559708603504L;
	@ApiModelProperty(value="多语言", name="dicTextList")
	private List<DicText> dicTextList;

	public List<DicText> getDicTextList() {
		return dicTextList;
	}

	public void setDicTextList(List<DicText> dicTextList) {
		this.dicTextList = dicTextList;
	};

	
	

}
