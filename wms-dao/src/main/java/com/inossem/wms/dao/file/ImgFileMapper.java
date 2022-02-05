package com.inossem.wms.dao.file;

import com.inossem.wms.model.file.ImgFile;
import com.inossem.wms.model.file.ImgFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgFileMapper {
    int countByExample(ImgFileExample example);

    int deleteByExample(ImgFileExample example);

    int deleteByPrimaryKey(String imgCode);

    int insert(ImgFile record);

    int insertSelective(ImgFile record);

    List<ImgFile> selectByExample(ImgFileExample example);

    ImgFile selectByPrimaryKey(String imgCode);

    int updateByExampleSelective(@Param("record") ImgFile record, @Param("example") ImgFileExample example);

    int updateByExample(@Param("record") ImgFile record, @Param("example") ImgFileExample example);

    int updateByPrimaryKeySelective(ImgFile record);

    int updateByPrimaryKey(ImgFile record);

    /************ 2021-10-14 新加*****************/
    ImgFile selectByImgExt0(String documentNumber);
}