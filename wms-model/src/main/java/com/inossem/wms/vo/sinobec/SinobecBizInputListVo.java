package com.inossem.wms.vo.sinobec;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SinobecBizInputListVo
 * @Description 
 * @Author wsail
 * @Date 2020/3/24 17:37
 **/
@ApiModel(value = "com.inossem.wms.vo.sinobec.SinobecBizInputListVo")
public class SinobecBizInputListVo {

    @ApiModelProperty(value = "返回结果")
    private Map<String, List<SinobecBizInputVo>> resultMap;

    @ApiModelProperty(value = "分页数量")
    private Integer totalCount;

    private List<SinobecBizInputVo> list;

    public List<SinobecBizInputVo> getList() {
        return list;
    }

    public void setList(List<SinobecBizInputVo> list) {
        this.list = list;
    }

    public Map<String, List<SinobecBizInputVo>> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, List<SinobecBizInputVo>> resultMap) {
        this.resultMap = resultMap;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
