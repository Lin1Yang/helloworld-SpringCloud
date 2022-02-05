package com.inossem.wms.co.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicUnit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.dic.DicUnitCo", description="计量单位入参对象")
public class DicUnitCo extends DicUnit{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2074466718381334929L;

	@ApiModelProperty(name="isEdit",value="0新增  1修改")
	private Byte isEdit;
	
	@ApiModelProperty(value="多语言", name="dicTextList")
	private List<DicText> dicTextList;
	
	/**
	 * 语言类型 zh-CN简体中文 en-US简体英文
	 */
	@ApiModelProperty(value="语言类型 不必传后台根据用户id获取", name="langCode")
	private String langCode;	
	
	

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public List<DicText> getDicTextList() {
		return dicTextList;
	}

	public void setDicTextList(List<DicText> dicTextList) {
		this.dicTextList = dicTextList;
	}

	public Byte getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Byte isEdit) {
		this.isEdit = isEdit;
	};

	
}
