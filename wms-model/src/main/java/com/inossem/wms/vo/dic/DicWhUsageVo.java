package com.inossem.wms.vo.dic;

import com.inossem.wms.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仓库负载对象
 * @author lys
 * @version 2020-03-03
 */
@ApiModel(value="com.inossem.wms.vo.dic.DicWhUsageVo", description="仓库负载对象")
public class DicWhUsageVo {
    @ApiModelProperty(value="仓库号")
    private String whCode;

    @ApiModelProperty(value="仓库描述")
    private String whName;

    @ApiModelProperty(value="总仓位数")
    private Integer allBinCount;

    @ApiModelProperty(value="已使用仓位数")
    private Integer usedBinCount;

    @ApiModelProperty(value="未使用仓位数")
    private Integer remainderBinCount;

    @ApiModelProperty(value="负载率")
    private String usageRate;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getAllBinCount() {
        return allBinCount;
    }

    public void setAllBinCount(Integer allBinCount) {
        this.allBinCount = allBinCount;
    }

    public Integer getUsedBinCount() {
        return usedBinCount;
    }

    public void setUsedBinCount(Integer usedBinCount) {
        this.usedBinCount = usedBinCount;
    }

    public Integer getRemainderBinCount() {
        return remainderBinCount;
    }

    public void setRemainderBinCount(Integer remainderBinCount) {
        this.remainderBinCount = remainderBinCount;
    }

    public String getUsageRate() {
        return usageRate == null ? Const.STRING_EMPTY : usageRate;
    }

    public void setUsageRate(String usageRate) {
        this.usageRate = usageRate;
    }
}
