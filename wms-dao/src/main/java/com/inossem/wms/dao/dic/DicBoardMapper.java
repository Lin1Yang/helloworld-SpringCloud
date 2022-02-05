package com.inossem.wms.dao.dic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inossem.wms.model.dic.DicBoard;
@Component
public interface DicBoardMapper {
    int deleteByPrimaryKey(Integer boardCode);

    int insert(DicBoard record);

    int insertSelective(DicBoard record);

    DicBoard selectByPrimaryKey(Integer boardCode);

    int updateByPrimaryKeySelective(DicBoard record);

    int updateByPrimaryKey(DicBoard record);

    List<DicBoard> getList();
}