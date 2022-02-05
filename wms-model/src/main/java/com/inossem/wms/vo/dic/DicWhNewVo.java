package com.inossem.wms.vo.dic;

import java.util.Date;

import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.util.UtilEnum;

import io.swagger.annotations.ApiModelProperty;

public class DicWhNewVo {

	
	@ApiModelProperty(value="仓库编码")
    private String whCode;

	@ApiModelProperty(value="仓库描述")
    private String whName;

	@ApiModelProperty(value="仓库地址")
    private String whAddress;

	@ApiModelProperty(value="国家或地区")
    private String country;

	@ApiModelProperty(value="城市")
    private String city;

	@ApiModelProperty(value="启用仓位")
    private Byte binEnabled;
	
	
	//private String binEnabledName;
	
	public String getBinEnabledName() {
		return UtilEnum.getI18nText(EnumEnable.getEnumName(binEnabled).toLowerCase());
	}

	@ApiModelProperty(value="启用拣配")
    private Byte pickingEnabled;
    
	@ApiModelProperty(value="启用存储单元")
    private Byte cellEnabled;

	@ApiModelProperty(value="启用入库波次")
    private Byte waveInput;

	@ApiModelProperty(value="启用出库波次")
    private Byte waveOutput;

	@ApiModelProperty(value="入库作业方式")
    private Byte taskInput;

	@ApiModelProperty(value="出库作业方式")
    private Byte taskOutput;

    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    
    
    private boolean click;

    public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

	public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public String getWhAddress() {
		return whAddress;
	}

	public void setWhAddress(String whAddress) {
		this.whAddress = whAddress;
	}

	public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Byte getBinEnabled() {
        return binEnabled;
    }

    public void setBinEnabled(Byte binEnabled) {
        this.binEnabled = binEnabled;
    }
    
    public Byte getCellEnabled() {
		return cellEnabled;
	}

	public void setCellEnabled(Byte cellEnabled) {
		this.cellEnabled = cellEnabled;
	}

	public Byte getPickingEnabled() {
        return pickingEnabled;
    }

    public void setPickingEnabled(Byte pickingEnabled) {
        this.pickingEnabled = pickingEnabled;
    }

    public Byte getWaveInput() {
        return waveInput;
    }

    public void setWaveInput(Byte waveInput) {
        this.waveInput = waveInput;
    }

    public Byte getWaveOutput() {
        return waveOutput;
    }

    public void setWaveOutput(Byte waveOutput) {
        this.waveOutput = waveOutput;
    }

    public Byte getTaskInput() {
        return taskInput;
    }

    public void setTaskInput(Byte taskInput) {
        this.taskInput = taskInput;
    }

    public Byte getTaskOutput() {
        return taskOutput;
    }

    public void setTaskOutput(Byte taskOutput) {
        this.taskOutput = taskOutput;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

}
