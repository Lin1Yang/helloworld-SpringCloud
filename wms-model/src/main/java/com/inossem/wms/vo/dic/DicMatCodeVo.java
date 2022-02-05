package com.inossem.wms.vo.dic;


import io.swagger.annotations.ApiModel;

/**
 * @Description  物料范围组合
 * @ClassName：DicMatCodeVo :
 * @Package com.inossem.wms.vo.dic
 * @anthor：wyang
 * @date：2019/2/27
 * @版本：V1.0
 */
@ApiModel(value = "com.inossem.wms.vo.dic.DicMatCodeVo",description = "物料范围组合")
public class DicMatCodeVo {

    private String beginCode;

    private String endCode;

    public String getBeginCode() {
        return beginCode;
    }

    public void setBeginCode(String beginCode) {
        this.beginCode = beginCode;
    }

    public String getEndCode() {
        return endCode;
    }

    public void setEndCode(String endCode) {
        this.endCode = endCode;
    }
}
