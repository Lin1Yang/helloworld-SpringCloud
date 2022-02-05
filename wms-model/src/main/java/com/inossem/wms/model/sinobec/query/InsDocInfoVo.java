package com.inossem.wms.model.sinobec.query;

import java.util.List;

/**
 * FileName: InsDocInfoVo
 * Date:     2020/3/31 0031 10:26
 * Description: Ins凭证查询VO
 *
 * @author cxq
 */
public class InsDocInfoVo {

    private List<InsDocInfoDaoVo> insDocInfoDaoVoList;

    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<InsDocInfoDaoVo> getInsDocInfoDaoVoList() {
        return insDocInfoDaoVoList;
    }

    public void setInsDocInfoDaoVoList(List<InsDocInfoDaoVo> insDocInfoDaoVoList) {
        this.insDocInfoDaoVoList = insDocInfoDaoVoList;
    }
}
