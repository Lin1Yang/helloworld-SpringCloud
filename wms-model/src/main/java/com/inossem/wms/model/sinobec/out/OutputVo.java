package com.inossem.wms.model.sinobec.out;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 功能描述: 〈下架vo〉
 *
 * @return:
 * @since: 1.0.0
 * @Author: cxq
 * @Date: 2020/3/23 0023 17:30
 */
public class OutputVo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 919894374247647860L;

	@ApiModelProperty(value="查看已保存，返回集合", name="outputVos",  required=true)
    private List<OutputDaoVo> viewOutputVos;

    @ApiModelProperty(value="创建单据返回集合", name="shelfLoadDaoVos",  required=true)
    private List<OutputDaoVo> creteOutputVos;

    public List<OutputDaoVo> getViewOutputVos() {
        return viewOutputVos;
    }

    public void setViewOutputVos(List<OutputDaoVo> viewOutputVos) {
        this.viewOutputVos = viewOutputVos;
    }

    public List<OutputDaoVo> getCreteOutputVos() {
        return creteOutputVos;
    }

    public void setCreteOutputVos(List<OutputDaoVo> creteOutputVos) {
        this.creteOutputVos = creteOutputVos;
    }
}
