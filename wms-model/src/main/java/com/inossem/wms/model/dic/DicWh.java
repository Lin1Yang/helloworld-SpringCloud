package com.inossem.wms.model.dic;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicWh",description="仓库")
public class DicWh implements Serializable {
	
	private static final long serialVersionUID = -3672453013775436450L;

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
	
	@ApiModelProperty(value="启用WCS")
	private Byte wcsEnabled;
	
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

    private String whExt0;

    private String whExt1;

    private String whExt2;

    private String whExt3;

    private String whExt4;

    private String whExt5;

    private String whExt6;

    private String whExt7;

    private String whExt8;

    private String whExt9;
    
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
    
    public Byte getWcsEnabled() {
		return wcsEnabled;
	}

	public void setWcsEnabled(Byte wcsEnabled) {
		this.wcsEnabled = wcsEnabled;
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

    public String getWhExt0() {
        return whExt0;
    }

    public void setWhExt0(String whExt0) {
        this.whExt0 = whExt0 == null ? null : whExt0.trim();
    }

    public String getWhExt1() {
        return whExt1;
    }

    public void setWhExt1(String whExt1) {
        this.whExt1 = whExt1 == null ? null : whExt1.trim();
    }

    public String getWhExt2() {
        return whExt2;
    }

    public void setWhExt2(String whExt2) {
        this.whExt2 = whExt2 == null ? null : whExt2.trim();
    }

    public String getWhExt3() {
        return whExt3;
    }

    public void setWhExt3(String whExt3) {
        this.whExt3 = whExt3 == null ? null : whExt3.trim();
    }

    public String getWhExt4() {
        return whExt4;
    }

    public void setWhExt4(String whExt4) {
        this.whExt4 = whExt4 == null ? null : whExt4.trim();
    }

    public String getWhExt5() {
        return whExt5;
    }

    public void setWhExt5(String whExt5) {
        this.whExt5 = whExt5 == null ? null : whExt5.trim();
    }

    public String getWhExt6() {
        return whExt6;
    }

    public void setWhExt6(String whExt6) {
        this.whExt6 = whExt6 == null ? null : whExt6.trim();
    }

    public String getWhExt7() {
        return whExt7;
    }

    public void setWhExt7(String whExt7) {
        this.whExt7 = whExt7 == null ? null : whExt7.trim();
    }

    public String getWhExt8() {
        return whExt8;
    }

    public void setWhExt8(String whExt8) {
        this.whExt8 = whExt8 == null ? null : whExt8.trim();
    }

    public String getWhExt9() {
        return whExt9;
    }

    public void setWhExt9(String whExt9) {
        this.whExt9 = whExt9 == null ? null : whExt9.trim();
    }
}