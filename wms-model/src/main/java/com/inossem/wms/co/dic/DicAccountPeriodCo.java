package com.inossem.wms.co.dic;

import com.inossem.wms.page.PageCommon;

import com.inossem.wms.vo.dic.DicAccountPeriodVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "com.inossem.wms.co.dic.DicAccountPeriodCo", description = "账期入参对象")
public class DicAccountPeriodCo extends PageCommon {

    private static final long serialVersionUID = 4973818502523156696L;

    @ApiModelProperty(value = "板块编码")
    private Integer boardCode;

    @ApiModelProperty(value = "公司编码")
    private String corpCode;

    @ApiModelProperty(value = "年度")
    private Integer accountYear;

    @ApiModelProperty(value = "月份")
    private Byte accountMonth;

    @ApiModelProperty(value = "是否按库存地点筛选")
    private Boolean locationAuthority;

    @ApiModelProperty(value = "当前登录人id")
    private Integer currentUserId;

    private List<DicAccountPeriodVo> originalList;

    public List<DicAccountPeriodVo> getOriginalList() {
        return originalList;
    }

    public DicAccountPeriodCo setOriginalList(List<DicAccountPeriodVo> originalList) {
        this.originalList = originalList;
        return this;
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

    public Integer getAccountYear() {
        return accountYear;
    }

    public void setAccountYear(Integer accountYear) {
        this.accountYear = accountYear;
    }

    public Byte getAccountMonth() {
        return accountMonth;
    }

    public void setAccountMonth(Byte accountMonth) {
        this.accountMonth = accountMonth;
    }

    public Boolean getLocationAuthority() {
        return locationAuthority;
    }

    public void setLocationAuthority(Boolean locationAuthority) {
        this.locationAuthority = locationAuthority;
    }

    public Integer getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }

    public DicAccountPeriodCo() {
    }

    public DicAccountPeriodCo(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }
}
