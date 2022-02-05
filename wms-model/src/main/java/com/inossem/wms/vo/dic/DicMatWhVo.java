package com.inossem.wms.vo.dic;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 
 * @ClassName：DicMatWhVo :
 * @Package com.inossem.wms.vo.dic
 * @anthor：wyang
 * @date：2019/2/22
 * @版本：V1.0
 */
@ApiModel(value="com.inossem.wms.vo.dic.DicMatWhVo", description="保存物料信息出参对象")
public class DicMatWhVo {

    @ApiModelProperty(value = "是否配置",name="isSelect", example = "true", required = true)
    private Boolean isSelect;

    @ApiModelProperty(value = "仓库编码", name="whCode",example = "123", required = true)
    private String whCode;

    @ApiModelProperty(value = "仓库描述", name="whName",example = "111", required = true)
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

    public String getIsSelect() {
        String str="false";
        if(this.isSelect) str="true";

        return str;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public DicMatWhVo(Boolean isSelect, String whCode, String whName) {
        this.isSelect = isSelect;
        this.whCode = whCode;
        this.whName = whName;
    }

    public DicMatWhVo() {
    }
}
