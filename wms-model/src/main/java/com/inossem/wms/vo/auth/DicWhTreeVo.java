package com.inossem.wms.vo.auth;

import java.util.ArrayList;
import java.util.List;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicWh;
import com.inossem.wms.vo.dic.DicWhStorageTypeVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.DicWhTreeVo")
public class DicWhTreeVo extends DicWh {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3133054673216379073L;

	private List<DicWhStorageTypeTreeVo> whStorageTypeList = new ArrayList<DicWhStorageTypeTreeVo>();
	
	private String langCode;
	
	private String text;
	
	private Integer totalCount;
	
	@ApiModelProperty(value="仓位名称列表", name="", example="")
    private List<DicText> dicTextList;
	
	
	private String taskInputName;
	
	private String taskOutputName;
	
	private List<DicWhStorageTypeVo> typeList;

	public List<DicWhStorageTypeTreeVo> getWhStorageTypeList() {
		return whStorageTypeList;
	}

	public void setWhStorageTypeList(List<DicWhStorageTypeTreeVo> whStorageTypeList) {
		this.whStorageTypeList = whStorageTypeList;
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

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicText> getDicTextList() {
		return dicTextList;
	}

	public void setDicTextList(List<DicText> dicTextList) {
		this.dicTextList = dicTextList;
	}

	

	public String getTaskInputName() {
		return taskInputName;
	}

	public void setTaskInputName(String taskInputName) {
		this.taskInputName = taskInputName;
	}

	public String getTaskOutputName() {
		return taskOutputName;
	}

	public void setTaskOutputName(String taskOutputName) {
		this.taskOutputName = taskOutputName;
	}

	public List<DicWhStorageTypeVo> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<DicWhStorageTypeVo> typeList) {
		this.typeList = typeList;
	}
}
