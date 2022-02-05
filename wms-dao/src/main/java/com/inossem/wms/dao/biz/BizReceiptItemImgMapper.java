package com.inossem.wms.dao.biz;

import java.util.List;

import com.inossem.wms.model.biz.BizReceiptItemImg;
import com.inossem.wms.model.biz.BizReceiptItemImgVo;
import org.apache.ibatis.annotations.Param;

public interface BizReceiptItemImgMapper {
    int deleteByPrimaryKey(Integer bizReceiptItemImgId);

    int insert(BizReceiptItemImg record);

    int insertSelective(BizReceiptItemImg record);

    BizReceiptItemImg selectByPrimaryKey(Integer bizReceiptItemImgId);

    int updateByPrimaryKeySelective(BizReceiptItemImg record);

    int updateByPrimaryKey(BizReceiptItemImg record);
    
    int updateByCondition(BizReceiptItemImgVo record);
    
    List<BizReceiptItemImgVo> selectByCondition(BizReceiptItemImg record);

    /**
     * （批量查询）根据单据类型、单号、行项目号
     * @param imgList
     * @return
     */
    List<BizReceiptItemImgVo> selectByReceiptList(@Param("list") List<BizReceiptItemImg> imgList);
    
    void insertBatch(List<BizReceiptItemImgVo> list);


	int delByCondition(BizReceiptItemImgVo vo);

    /**
     * （批量删除）根据单据类型、单号、行项目号
     * @param imgList
     * @return
     */
    int deleteByReceiptList(@Param("list") List<BizReceiptItemImgVo> imgList);

}