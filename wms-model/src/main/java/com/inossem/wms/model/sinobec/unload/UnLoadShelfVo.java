package com.inossem.wms.model.sinobec.unload;

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
public class UnLoadShelfVo implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -4889325731504175198L;

	@ApiModelProperty(value="创建单据返回集合", name="shelfLoadDaoVos",  required=true)
    private List<UnLoadShelfDaoVo> creteShelfLoadDaoVos;

    @ApiModelProperty(value="查看已保存，返回集合", name="shelfLoadDaoVos",  required=true)
    private List<UnLoadShelfDaoVo> viewShelfLoadDaoVos;

    public List<UnLoadShelfDaoVo> getCreteShelfLoadDaoVos() {
        return creteShelfLoadDaoVos;
    }

    public void setCreteShelfLoadDaoVos(List<UnLoadShelfDaoVo> creteShelfLoadDaoVos) {
        this.creteShelfLoadDaoVos = creteShelfLoadDaoVos;
    }

    public List<UnLoadShelfDaoVo> getViewShelfLoadDaoVos() {
        return viewShelfLoadDaoVos;
    }

    public void setViewShelfLoadDaoVos(List<UnLoadShelfDaoVo> viewShelfLoadDaoVos) {
        this.viewShelfLoadDaoVos = viewShelfLoadDaoVos;
    }
}
