package com.inossem.wms.vo.rel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.enums.EnumReceiptTreeType;
import com.inossem.wms.model.rel.RelReceiptRidKey;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.vo.rel.RelReceiptBinVo", description = "单据流返回对象")
public class RelReceiptRidVo extends RelReceiptRidKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6558391906764213263L;

	public static void exchangeProperties(RelReceiptRidVo source, RelReceiptRidVo target) {
		Integer receiptType = source.getReceiptType();
		source.setReceiptType(target.getReceiptType());
		target.setReceiptType(receiptType);

		String receiptCode = source.getReceiptCode();
		source.setReceiptCode(target.getReceiptCode());
		target.setReceiptCode(receiptCode);

		String receiptRid = source.getReceiptRid();
		source.setReceiptRid(target.getReceiptRid());
		target.setReceiptRid(receiptRid);

		Integer preReceiptType = source.getPreReceiptType();
		source.setPreReceiptType(target.getPreReceiptType());
		target.setPreReceiptType(preReceiptType);

		String preReceiptCode = source.getPreReceiptCode();
		source.setPreReceiptCode(target.getPreReceiptCode());
		target.setPreReceiptCode(preReceiptCode);

		String preReceiptRid = source.getPreReceiptRid();
		source.setPreReceiptRid(target.getPreReceiptRid());
		target.setPreReceiptRid(preReceiptRid);

		Date createTime = source.getCreateTime();
		source.setCreateTime(target.getCreateTime());
		target.setCreateTime(createTime);

		Integer createUserId = source.getCreateUserId();
		source.setCreateUserId(target.getCreateUserId());
		target.setCreateUserId(createUserId);

		String createUserCode = source.getCreateUserCode();
		source.setCreateUserCode(target.getCreateUserCode());
		target.setCreateUserCode(createUserCode);

		String createUserName = source.getCreateUserName();
		source.setCreateUserName(target.getCreateUserName());
		target.setCreateUserName(createUserName);

		Byte receiptStatus = source.getReceiptStatus();
		source.setReceiptStatus(target.getReceiptStatus());
		target.setReceiptStatus(receiptStatus);

		Byte itemStatus = source.getItemStatus();
		source.setItemStatus(target.getItemStatus());
		target.setItemStatus(itemStatus);
		
		Byte self = source.getSelf();
		source.setSelf(target.getSelf());
		target.setSelf(self);

		List<RelReceiptRidVo> childrenList = source.getChildrenList();
		source.setChildrenList(target.getChildrenList());
		target.setChildrenList(childrenList);
	}

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "用户Id")
	private Integer createUserId;

	@ApiModelProperty(value = "账户")
	private String createUserCode;

	@ApiModelProperty(value = "用户名")
	private String createUserName;

	@ApiModelProperty(value = "单据类型名称")
	private String receiptTypeName;

	@ApiModelProperty(value = "单据状态")
	private Byte receiptStatus;

	@ApiModelProperty(value = "单据状态名称")
	private String receiptStatusName;

	@ApiModelProperty(value = "行项目状态")
	private Byte itemStatus;

	@ApiModelProperty(value = "行项目状态名称")
	private String itemStatusName;
	
	@ApiModelProperty(value = "自上而下")
	private Byte topDown = EnumReceiptTreeType.UNKNOWN.getValue();
	
	@ApiModelProperty(value = "是否当前单据")
	private Byte self = EnumEnable.UNABLE.getValue();

	@ApiModelProperty(value = "子集")
	private List<RelReceiptRidVo> childrenList;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getReceiptTypeName() {
		return receiptTypeName;
	}

	public void setReceiptTypeName(String receiptTypeName) {
		this.receiptTypeName = receiptTypeName;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getReceiptStatusName() {
		return receiptStatusName;
	}

	public void setReceiptStatusName(String receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}

	public Byte getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Byte itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemStatusName() {
		return itemStatusName;
	}

	public void setItemStatusName(String itemStatusName) {
		this.itemStatusName = itemStatusName;
	}

	public Byte getTopDown() {
		return topDown;
	}

	public void setTopDown(Byte topDown) {
		this.topDown = topDown;
	}	
	
	public Byte getSelf() {
		return self;
	}

	public void setSelf(Byte self) {
		this.self = self;
	}

	public List<RelReceiptRidVo> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List<RelReceiptRidVo> childrenList) {
		this.childrenList = childrenList;
	}

}
