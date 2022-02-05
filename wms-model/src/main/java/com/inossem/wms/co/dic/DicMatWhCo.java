package com.inossem.wms.co.dic;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description  物料仓库关联入参对象
 * @ClassName：DicMatWhCo :
 * @Package com.inossem.wms.co.dic
 * @anthor：wyang
 * @date：2019/2/25
 * @版本：V1.0
 */
public class DicMatWhCo {
    @ApiModelProperty(value = "是否配置",name="isSelect", example = "true", required = true)
    private boolean isSelect;

    @ApiModelProperty(value = "仓库编码", name="whCode",example = "123", required = true)
    private String whCode;

    @ApiModelProperty(value = "仓库描述", name="whName",example = "111", required = false)
    private String whName;



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

    public boolean getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(String isSelect) {
        this.isSelect=false;

        if (("true").equals(isSelect)) this.isSelect=true;

    }

}
