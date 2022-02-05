package com.inossem.wms.vo.dic;

import java.io.Serializable;
import java.util.List;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicWhStorageSection;
import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicWhStorageSectionVo", description="存储区返回对象")
public class DicWhStorageSectionVo extends DicWhStorageSection implements IPageResultCommon, Serializable {

	private static final long serialVersionUID = -8637170667611388576L;

	@ApiModelProperty(value="仓库描述",example="大地仓库")
	private String whName;
	
	@ApiModelProperty(value="存储类型描述",example="高位货架区")
	private String typeName;
	
	@ApiModelProperty(value="创建人名",example="李四")
	private String createName;
	
	@ApiModelProperty(value="分页总条数",example="20")
	private int totalCount;
	
	@ApiModelProperty(value="国际化")
	private List<DicText> dicTextList;
	
	@ApiModelProperty(value="可编辑 0不可编辑 1可编辑",example="0")
	private Byte canEdit;
	
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@Override
	public int getTotalCount() {
		return this.totalCount;
	}
	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		
	}
	public List<DicText> getDicTextList() {
		return dicTextList;
	}
	public void setDicTextList(List<DicText> dicTextList) {
		this.dicTextList = dicTextList;
	}
	public Byte getCanEdit() {
		return canEdit;
	}
	public void setCanEdit(Byte canEdit) {
		this.canEdit = canEdit;
	}

	
}
