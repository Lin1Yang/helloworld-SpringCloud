package com.inossem.wms.vo.dic;

import java.math.BigDecimal;
import java.util.List;

import com.inossem.wms.model.dic.DicWhStorageBin;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.model.dic.DicWhStorageBinType;
import com.inossem.wms.vo.take.BizStockTakeMatItemVo;

import io.swagger.annotations.ApiModelProperty;


public class DicWhStorageBinVo extends DicWhStorageBin {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3129030910661866653L;

	private String typeName;
	
	private Byte canEdit;
	
	private String langCode;
	
	private String text;
	
	private boolean isExist;
	
	private Integer totalCount;
	
	private List<DicWhStorageBinType> typeList;
	
	
	
	private List<BizStockTakeMatItemVo> matList;
	
	private byte cellEnabled;

	@ApiModelProperty(value = "盘点人")
	private String stockTakeUser;
	
	@ApiModelProperty(value = "盘点rid")
	private String stockTakeRid;
	/**
	 * @Author WangDong
	 * @Date 2019/2/20 14:11
	 * @Param
	 * @return
	 * @Description //批量处理用到的联合主键
	 **/
	private List<DicWhStorageBinKey> keyList;

	private String pickingAreaName;
	
	private BigDecimal canUseWeight;
	

	public List<DicWhStorageBinKey> getKeyList() {
		return this.keyList;
	}

	public void setKeyList(final List<DicWhStorageBinKey> keyList) {
		this.keyList = keyList;
	}
	

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
	
	public Byte getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Byte canEdit) {
		this.canEdit = canEdit;
	}

	public boolean getIsExist() {
		return isExist;
	}
	public void setIsExist(boolean isExist) {
		this.isExist = isExist;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	public List<DicWhStorageBinType> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<DicWhStorageBinType> typeList) {
		this.typeList = typeList;
	}
	
	
	

	public String getPickingAreaName() {
		return pickingAreaName;
	}

	public void setPickingAreaName(String pickingAreaName) {
		this.pickingAreaName = pickingAreaName;
	}

	public byte getCellEnabled() {
		return cellEnabled;
	}

	public void setCellEnabled(byte cellEnabled) {
		this.cellEnabled = cellEnabled;
	}

	public List<BizStockTakeMatItemVo> getMatList() {
		return matList;
	}

	public void setMatList(List<BizStockTakeMatItemVo> matList) {
		this.matList = matList;
	}

	public String getStockTakeUser() {
		return stockTakeUser;
	}

	public void setStockTakeUser(String stockTakeUser) {
		this.stockTakeUser = stockTakeUser;
	}

	public String getStockTakeRid() {
		return stockTakeRid;
	}

	public void setStockTakeRid(String stockTakeRid) {
		this.stockTakeRid = stockTakeRid;
	}

	public BigDecimal getCanUseWeight() {
		return canUseWeight;
	}

	public void setCanUseWeight(BigDecimal canUseWeight) {
		this.canUseWeight = canUseWeight;
	}

}
