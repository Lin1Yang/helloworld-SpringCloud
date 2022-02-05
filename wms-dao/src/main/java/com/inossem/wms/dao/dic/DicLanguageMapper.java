package com.inossem.wms.dao.dic;

import com.inossem.wms.model.dic.DicLanguage;
import com.inossem.wms.page.PageCommon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DicLanguageMapper {
    int deleteByPrimaryKey(String langCode);

    int insert(DicLanguage record);

    int insertSelective(DicLanguage record);

    DicLanguage selectByPrimaryKey(String langCode);
    
    int updateByPrimaryKeySelective(DicLanguage record);

    /**
     * 查询所有	is_delete = 0
     * @return
     */
    List<DicLanguage> selectAllLanguageList();
    
    List<DicLanguage> selectLanguageOnPaging(PageCommon pc);
}