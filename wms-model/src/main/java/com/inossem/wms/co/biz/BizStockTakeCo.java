package com.inossem.wms.co.biz;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.inossem.wms.page.PageCommon;
import com.inossem.wms.vo.take.BizStockTakeItemVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.biz.BizStockTakeCo", description="盘点对象")
public class BizStockTakeCo  extends PageCommon{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "盘点 凭证code")
	private String stockTakeCode;
	@ApiModelProperty(value = "盘点 凭证rid")
	private String stockTakeRid;
	@ApiModelProperty(value = "创建人")
	private Integer createUserId;
	@ApiModelProperty(value = "搜索条件")
	private String key;
	@ApiModelProperty(value = "状态列表")
	private List<Integer> statusList;
	@ApiModelProperty(value = "子表主键列表")
	private List<Integer> matIdList;
	@ApiModelProperty(value = "主表主键列表")
	private List<Integer> takeIdList;
	@ApiModelProperty(value = "物料行项目状态")
	private Byte status;
	@ApiModelProperty(value = "单据状态")
	private Byte receiptStatus;
	@ApiModelProperty(value = "盘点人")
	private String stockTakeUser;
	@ApiModelProperty(value = "盘点组（SAP返回的内容）")
	private String stockTakeGroup;
	@ApiModelProperty(value = "盘点库存凭证（SAP返回的内容）")
	private String stockTakeVoucher;
	@ApiModelProperty(value = "盘点物料凭证")
	private String matVoucher;
	@ApiModelProperty(value = "仓库号")
	private String whCode;
	@ApiModelProperty(value = "存储类型Code")
	private String typeCode;
	@ApiModelProperty(value = "仓位Code")
	private String binCode;
	@ApiModelProperty(value = "盘点单创建人")
	private String createStockTakeUser;
	@ApiModelProperty(value = "审批状态")
	private Byte wfStatus;
	@ApiModelProperty(value = "凭证日期")
	private Date docDate;
	@ApiModelProperty(value = "过账日期")
	private Date postingDate;
	@ApiModelProperty(value = "存储类型集合")
	protected Set<String> typeSet;
	@ApiModelProperty(value = "国际化编码")
	protected String langCode;	
	@ApiModelProperty(value = "物料编码")
	protected String matCode;
	@ApiModelProperty(value = "库存状态集合", example = "")
	
	
	private String sDate;
	private String eDate;
	
	private Byte isReCount;
	
	
	
	public Byte getIsReCount() {
		return isReCount;
	}

	public void setIsReCount(Byte isReCount) {
		this.isReCount = isReCount;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	protected Set<Byte> stockStatusSet;
	
	protected List<BizStockTakeItemVo> list;
	
	private String sapDocNum;

	public String getSapDocNum() {
		return sapDocNum;
	}

	public void setSapDocNum(String sapDocNum) {
		this.sapDocNum = sapDocNum;
	}

	public Date getDocDate() {
		return docDate;
	}

	public BizStockTakeCo setDocDate(Date docDate) {
		this.docDate = docDate;
		return this;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public BizStockTakeCo setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
		return this;
	}

	public String getStockTakeCode() {
		return stockTakeCode;
	}

	public void setStockTakeCode(String stockTakeCode) {
		this.stockTakeCode = stockTakeCode;
	}
	
	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Integer> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
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

	public List<Integer> getMatIdList() {
		return matIdList;
	}

	public void setMatIdList(List<Integer> matIdList) {
		this.matIdList = matIdList;
	}

	public List<Integer> getTakeIdList() {
		return takeIdList;
	}

	public void setTakeIdList(List<Integer> takeIdList) {
		this.takeIdList = takeIdList;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getStockTakeGroup() {
		return stockTakeGroup;
	}

	public void setStockTakeGroup(String stockTakeGroup) {
		this.stockTakeGroup = stockTakeGroup;
	}

	public String getStockTakeVoucher() {
		return stockTakeVoucher;
	}

	public void setStockTakeVoucher(String stockTakeVoucher) {
		this.stockTakeVoucher = stockTakeVoucher;
	}

	public String getMatVoucher() {
		return matVoucher;
	}

	public void setMatVoucher(String matVoucher) {
		this.matVoucher = matVoucher;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getBinCode() {
		return binCode;
	}

	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}

	public String getCreateStockTakeUser() {
		return createStockTakeUser;
	}

	public void setCreateStockTakeUser(String createStockTakeUser) {
		this.createStockTakeUser = createStockTakeUser;
	}

	public Byte getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(Byte wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Set<String> getTypeSet() {
		return typeSet;
	}

	public void setTypeSet(Set<String> typeSet) {
		this.typeSet = typeSet;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	public Set<Byte> getStockStatusSet() {
		return stockStatusSet;
	}

	public void setStockStatusSet(Set<Byte> stockStatusSet) {
		this.stockStatusSet = stockStatusSet;
	}

	public List<BizStockTakeItemVo> getList() {
		return list;
	}

	public void setList(List<BizStockTakeItemVo> list) {
		this.list = list;
	}
}