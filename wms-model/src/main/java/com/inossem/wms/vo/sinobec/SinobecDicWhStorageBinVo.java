package com.inossem.wms.vo.sinobec;

import java.util.List;

import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.vo.take.BizStockTakeMatItemVo;


public class SinobecDicWhStorageBinVo extends DicWhStorageBinKey {

	private static final long serialVersionUID = -3129030910661866653L;

	private String typeName;
	
	private String langCode;
	
	private String text;
	
	private List<BizStockTakeMatItemVo> matList;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<BizStockTakeMatItemVo> getMatList() {
		return matList;
	}

	public void setMatList(List<BizStockTakeMatItemVo> matList) {
		this.matList = matList;
	}
}
