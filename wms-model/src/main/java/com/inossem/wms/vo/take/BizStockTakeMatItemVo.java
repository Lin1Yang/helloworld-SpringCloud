package com.inossem.wms.vo.take;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inossem.wms.model.sinobec.take.SinobecBizStockTakeMat;

import cn.afterturn.easypoi.entity.ImageEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.take.BizStockTakeMatItemVo", description="盘点对象")
public class BizStockTakeMatItemVo  extends SinobecBizStockTakeMat {

	
	@ApiModelProperty(value = "总记录数", example = "0")
	private int totalCount;

	@ApiModelProperty(value = "联合主键")
	private String compositeKeys;

	@ApiModelProperty(value = "盘点类型：1-动态盘点，2-周期性盘点")
	private Byte stockTakeType;
	@ApiModelProperty(value = "盘点方法：1-明盘，2-盲盘")
	private Byte stockTakeMode;
	@ApiModelProperty(value = "盘点日期")
	private Date stockTakeDate;
	@ApiModelProperty(value = "是否冻结")
	private Byte freezeStockTake;
	@ApiModelProperty(value = "单据状态")
	private Byte receiptStatus;
	@ApiModelProperty(value = "行项目状态")
	private Byte itemStatus;
	@ApiModelProperty(value = "盘点人名称")
	private String stockTakeUserName;


	@ApiModelProperty(value = "仓库名称")
	private String whName;
	@ApiModelProperty(value = "存储类型名称")
	private String typeName;
	@ApiModelProperty(value = "物料名称")
	private String matName;
	@ApiModelProperty(value = "单位名称")
	private String unitName;
	@ApiModelProperty(value = "小数位")
	private Byte decimalPlace;
	@ApiModelProperty(value = "重量小数位")
	private Byte weightDecimalPlace;


	@ApiModelProperty(value = "库存ID")
	private Integer stockId;

	@ApiModelProperty(value = "用户编码")
	private Integer userId;
	@ApiModelProperty(value = "用户名称")
	private String userName;



	@ApiModelProperty(value = "盘点主表主键")
	private Integer stockTakeId;
	@ApiModelProperty(value = "盘点结果")
	private Byte stockTakeResult;
	@ApiModelProperty(value = "盘点结果名称")
	private String stockTakeResultName;
	@ApiModelProperty(value = "增加或删减标识")
	private String debitCredit;
	@ApiModelProperty(value = "盘盈标识")
	private boolean inventorySurplus = false;
	@ApiModelProperty(value = "公司编码")
	private String corpCode;
	@ApiModelProperty(value = "是否改变库存")
	private boolean isChangeStock;

	
	private Byte freezeOutput;
	
	private Byte freezeInput;
	
	@ApiModelProperty(value = "需要给Android使用的属性")
	private String primaryKey;
	private boolean click;
	private boolean isOpen;
	private boolean isLegal;
	
	private Date beginDate;
	private Date endDate;
	private int num;
	private String beginDateName;
	private String endDateName;
	private ImageEntity qrCode;
	private String inputDateName;
	//利润
	private BigDecimal profit;
	
	private String checkName;
	
	private String docNum;
	
	private List<String> locationList = new ArrayList<String>();
	private List<String> typeList = new ArrayList<String>();
	private List<String> binList = new ArrayList<String>();

	
	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}

	public List<String> getBinList() {
		return binList;
	}

	public void setBinList(List<String> binList) {
		this.binList = binList;
	}

	public List<String> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<String> locationList) {
		this.locationList = locationList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

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

	public Byte getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Byte itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getCompositeKeys() {
		return compositeKeys;
	}

	public void setCompositeKeys(String compositeKeys) {
		this.compositeKeys = compositeKeys;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}


	public Byte getStockTakeType() {
		return stockTakeType;
	}

	public void setStockTakeType(Byte stockTakeType) {
		this.stockTakeType = stockTakeType;
	}

	public Byte getStockTakeMode() {
		return stockTakeMode;
	}

	public void setStockTakeMode(Byte stockTakeMode) {
		this.stockTakeMode = stockTakeMode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStockTakeId() {
		return stockTakeId;
	}

	public void setStockTakeId(Integer stockTakeId) {
		this.stockTakeId = stockTakeId;
	}

	public Byte getStockTakeResult() {
		return stockTakeResult;
	}

	public void setStockTakeResult(Byte stockTakeResult) {
		this.stockTakeResult = stockTakeResult;
	}

	public String getStockTakeResultName() {
		return stockTakeResultName;
	}

	public void setStockTakeResultName(String stockTakeResultName) {
		this.stockTakeResultName = stockTakeResultName;
	}

	public String getDebitCredit() {
		return debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}


	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Byte getFreezeStockTake() {
		return freezeStockTake;
	}

	public void setFreezeStockTake(Byte freezeStockTake) {
		this.freezeStockTake = freezeStockTake;
	}

	public boolean isInventorySurplus() {
		return inventorySurplus;
	}

	public void setInventorySurplus(boolean inventorySurplus) {
		this.inventorySurplus = inventorySurplus;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStockTakeUserName() {
		return stockTakeUserName;
	}

	public void setStockTakeUserName(String stockTakeUserName) {
		this.stockTakeUserName = stockTakeUserName;
	}

	public boolean isChangeStock() {
		return isChangeStock;
	}

	public void setChangeStock(boolean changeStock) {
		isChangeStock = changeStock;
	}

	public Byte getDecimalPlace() {
		return decimalPlace;
	}

	public void setDecimalPlace(Byte decimalPlace) {
		this.decimalPlace = decimalPlace;
	}

	public Byte getFreezeOutput() {
		return freezeOutput;
	}

	public void setFreezeOutput(Byte freezeOutput) {
		this.freezeOutput = freezeOutput;
	}

	public Byte getFreezeInput() {
		return freezeInput;
	}

	public void setFreezeInput(Byte freezeInput) {
		this.freezeInput = freezeInput;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean open) {
		isOpen = open;
	}

	public boolean isLegal() {
		return isLegal;
	}

	public void setLegal(boolean legal) {
		isLegal = legal;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBeginDateName() {
		return beginDateName;
	}

	public void setBeginDateName(String beginDateName) {
		this.beginDateName = beginDateName;
	}

	public String getEndDateName() {
		return endDateName;
	}

	public void setEndDateName(String endDateName) {
		this.endDateName = endDateName;
	}

	public ImageEntity getQrCode() {
		return qrCode;
	}

	public void setQrCode(ImageEntity qrCode) {
		this.qrCode = qrCode;
	}

	public String getInputDateName() {
		return inputDateName;
	}

	public void setInputDateName(String inputDateName) {
		this.inputDateName = inputDateName;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Date getStockTakeDate() {
		return stockTakeDate;
	}

	public void setStockTakeDate(Date stockTakeDate) {
		this.stockTakeDate = stockTakeDate;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Byte getWeightDecimalPlace() {
		return weightDecimalPlace;
	}

	public void setWeightDecimalPlace(Byte weightDecimalPlace) {
		this.weightDecimalPlace = weightDecimalPlace;
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
}
