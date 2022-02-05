package com.inossem.wms.dao.sinobec;

import com.inossem.wms.vo.dic.DicCorpVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SinobecRelUserCorpMapper {
    List<DicCorpVo> selectCorpByUser(@Param("userId") Integer userId );

    List<DicCorpVo> selectCorpByUserNotRel(@Param("userId") Integer userId );

    int deleteByUser(@Param("userId") Integer userId);

    int insertRelUserCorp (List<DicCorpVo> corpList);
}