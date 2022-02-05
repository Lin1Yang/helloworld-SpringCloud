package com.inossem.wms.vo.dic;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description 
 * @ClassName：DicMatWhListVo :
 * @Package com.inossem.wms.vo.dic
 * @anthor：wyang
 * @date：2019/2/22
 * @版本：V1.0
 */
@ApiModel(value="com.inossem.wms.vo.dic.DicMatWhVo", description="保存物料信息出参对象")
public class DicMatWhListVo {

    @ApiModelProperty(value="物料仓库", name="matWhVoList", required=true)
    private List<DicMatWhVo> matWhVoList;

    public List<DicMatWhVo> getMatWhVoList() {
        return matWhVoList;
    }

    public void setMatWhVoList(List<DicMatWhVo> matWhVoList) {
        this.matWhVoList = matWhVoList;
    }
}
