package com.inossem.wms.vo.auth;

import java.io.Serializable;
import java.util.List;

import com.inossem.wms.model.dic.DicAccountPeriod;

import io.swagger.annotations.ApiModelProperty;

public class UserAccountPeriod implements Serializable {
	
	private static final long serialVersionUID = -9152894882019552430L;

	/** 账期启用标识 0不启用，1启用 */
	@ApiModelProperty(value = "账期启用标识")
	private byte enabled;
	
	/** 提醒启用标识 0不启用，1启用 */
	@ApiModelProperty(value = "提醒启用标识")
	private byte notifiable;
	
	/** 编辑启用标识 0不启用，1启用 */
	@ApiModelProperty(value = "编辑启用标识")
	private byte editable;
	
	/** 账期列表 */
	@ApiModelProperty(value = "账期列表")
	private List<DicAccountPeriod> accountPeriodList;
	
	/** 板块描述 */
	@ApiModelProperty(value = "板块描述")
    private String boardName;
	
	/** 板块编码 */
	@ApiModelProperty(value = "板块编码")
	private Integer boardCode;
	
	/** 公司描述 */
	@ApiModelProperty(value = "公司描述")
    private String corpName;
	
	/** 公司编码 */
	@ApiModelProperty(value = "公司编码")
	private String corpCode;
	
	public byte getEnabled() {
		return enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public byte getNotifiable() {
		return notifiable;
	}

	public void setNotifiable(byte notifiable) {
		this.notifiable = notifiable;
	}

	public byte getEditable() {
		return editable;
	}

	public void setEditable(byte editable) {
		this.editable = editable;
	}

	public List<DicAccountPeriod> getAccountPeriodList() {
		return accountPeriodList;
	}

	public void setAccountPeriodList(List<DicAccountPeriod> accountPeriodList) {
		this.accountPeriodList = accountPeriodList;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public Integer getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(Integer boardCode) {
		this.boardCode = boardCode;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

}
