package com.inossem.wms.dao.file;

import com.inossem.wms.model.file.LogFile;

public interface LogFileMapper {
    int deleteByPrimaryKey(String fileCode);

    int insert(LogFile record);

    int insertSelective(LogFile record);

    LogFile selectByPrimaryKey(String fileCode);

    int updateByPrimaryKeySelective(LogFile record);

    int updateByPrimaryKey(LogFile record);
}