package com.inossem.wms.model.sinobec.out;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

 /**
  * 功能描述: 〈出库单信息Co〉
  *
  * @return:
  * @since: 1.0.0
  * @Author: cxq
  * @Date: 2020/3/26 0026 11:04
  */
public class OutputInfoCo implements Serializable {

     /**
	 * 
	 */
	private static final long serialVersionUID = -2987574267197436672L;
	@ApiModelProperty(value="创建单据返回集合", name="shelfLoadDaoVos",  required=true)
     private List<OutputDaoVo> creteOutputVos;

     public List<OutputDaoVo> getCreteOutputVos() {
         return creteOutputVos;
     }

     public void setCreteOutputVos(List<OutputDaoVo> creteOutputVos) {
         this.creteOutputVos = creteOutputVos;
     }
 }
