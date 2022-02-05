package com.inossem.wms.vo.auth;

import com.inossem.wms.model.dic.DicText;

public class DicTextVo extends DicText {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1519882633830962296L;

	private String tid;
	
	private String langCode;
	
	private String text;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	@Override
    public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}
}
