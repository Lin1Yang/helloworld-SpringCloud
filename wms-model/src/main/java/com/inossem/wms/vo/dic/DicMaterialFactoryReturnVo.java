package com.inossem.wms.vo.dic;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author : sw
 * @date : 2019/2/20
 */
@ApiModel(value="com.inossem.wms.vo.dic.DicMaterialFactoryListVo", description="工厂物料信息返回信息")
public class DicMaterialFactoryReturnVo {

    @ApiModelProperty(value="列表集合", name="itemList",example="[{}]", required=true)
    private List<DicMaterialFactoryVo> itemList;

    @ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
    private int totalCount;



    @ApiModelProperty(value="计价方式集合", name="priceMethodList",example="[{}]", required=true)
    private List<Map<String,String>> priceMethodList;

   

  

   

    public List<Map<String, String>> getPriceMethodList() {
        return priceMethodList;
    }

    public void setPriceMethodList(List<Map<String, String>> priceMethodList) {
        this.priceMethodList = priceMethodList;
    }

    public List<DicMaterialFactoryVo> getItemList() {
        return itemList;
    }

    public void setItemList(List<DicMaterialFactoryVo> itemList) {
        this.itemList = itemList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
