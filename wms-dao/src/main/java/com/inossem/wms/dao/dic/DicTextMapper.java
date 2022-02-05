package com.inossem.wms.dao.dic;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicTextKey;
@Component
public interface DicTextMapper {
    int deleteByPrimaryKey(DicTextKey key);

    int insert(DicText record);

    int insertSelective(DicText record);
    
    int insertBatchDicText(List<DicText> list);

    DicText selectByPrimaryKey(DicTextKey key);

    List<DicText> selectByTid(DicTextKey key);

    int updateByPrimaryKeySelective(DicText record);
	
	/**
	 * 通过主键和语言查询是否存在记录
	 * 
	 * @param DicText
	 * @return 
	 * @author yuely
	 */
	DicText selectTidAndLangCodeIsExist(DicText dicText);
	
	/**
	 * 删除tid的相关内容
	 * 
	 * @param DicText
	 * @return 
	 * @author yuely
	 */
	int deleteByTid(DicText dicText);

    int updateByPrimaryKey(DicText record);

    List<DicText> select();
    
    List<DicText> selectListByTid(@Param("tid") String tid);
    
    /**
     *根据tid数组查询国际化文本
     * @param tidList
     * @return
     */
    List<DicText> selectListByTids(List<String> tidList);
}