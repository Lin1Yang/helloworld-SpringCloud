package com.inossem.wms.model.sinobec.query;

import com.inossem.wms.model.sinobec.SinobecInsDocBin;
import com.inossem.wms.page.IPageResultCommon;

/**
 * FileName: InsDocInfoVo
 * Date:     2020/3/31 0031 10:26
 * Description: Ins凭证查询VO
 *
 * @author cxq
 */
public class InsDocInfoDaoVo extends SinobecInsDocBin implements IPageResultCommon {
    private int totalCount;

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public void setTotalCount(int totalCount) {
        this.totalCount=totalCount;
    }
}
