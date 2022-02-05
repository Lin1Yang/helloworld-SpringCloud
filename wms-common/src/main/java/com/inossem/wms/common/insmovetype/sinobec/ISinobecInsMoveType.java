package com.inossem.wms.common.insmovetype.sinobec;

import com.inossem.wms.vo.sinobec.SinobecInsMoveTypeVo;

public interface ISinobecInsMoveType {
	/**
	 * 生成记账ins凭证
	 *
	 * @param object
	 * @return
	 */
    SinobecInsMoveTypeVo generateInsDoc(Object object) throws Exception;


}
