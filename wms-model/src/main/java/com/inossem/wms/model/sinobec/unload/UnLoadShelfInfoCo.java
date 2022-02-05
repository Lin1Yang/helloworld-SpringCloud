package com.inossem.wms.model.sinobec.unload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * FileName: ShelfLoadInfoCo
 * Date:     2020/3/20
 * Description: 下架单信息Co
 *
 * @author cxq
 */
public class UnLoadShelfInfoCo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8675030541819885449L;
	@ApiModelProperty(value="创建单据返回集合", name="shelfLoadDaoVos",  required=true)
    private List<UnLoadShelfDaoVo> creteShelfLoadDaoVos;

    public List<UnLoadShelfDaoVo> getCreteShelfLoadDaoVos() {
        return creteShelfLoadDaoVos;
    }

    public void setCreteShelfLoadDaoVos(List<UnLoadShelfDaoVo> creteShelfLoadDaoVos) {
        this.creteShelfLoadDaoVos = creteShelfLoadDaoVos;
    }
}
