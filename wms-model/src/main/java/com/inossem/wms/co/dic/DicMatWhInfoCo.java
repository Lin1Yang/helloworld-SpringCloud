package com.inossem.wms.co.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description  物料仓库关联入参
 * @ClassName：DicMatWhInfoCo :
 * @Package com.inossem.wms.co.dic
 * @anthor：wyang
 * @date：2019/2/25
 * @版本：V1.0
 */
@ApiModel(value="com.inossem.wms.co.dic.DicMatWhInfoCo", description="保存物料信息入参对象")
public class DicMatWhInfoCo  {

    @ApiModelProperty(value ="批量分配的仓库集合", required = true )
    private List<DicMatWhCo> matWhCoList;


    @ApiModelProperty(value = "物料编码", name="matCode",example = "89757", required = true)
    private String matCode;

    public List<DicMatWhCo> getMatWhCoList() {
        return matWhCoList;
    }

    public void setMatWhCoList(List<DicMatWhCo> matWhCoList) {
        this.matWhCoList = matWhCoList;
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }
}
