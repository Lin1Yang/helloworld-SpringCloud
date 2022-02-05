package com.inossem.wms.dao.dic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inossem.wms.co.dic.DicCorpCo;
import com.inossem.wms.model.dic.DicCorp;
import com.inossem.wms.vo.dic.DicCorpVo;
/**
 * @author Gyl
 */
@Component
public interface DicCorpMapper {
    /**根据主键删除
     * @param corpCode
     * @return
     */
    int deleteByPrimaryKey(String corpCode);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(DicCorp record);

    /**
     * 按照条件插入
     * @param record
     * @return
     */
    int insertSelective(DicCorp record);

    /**
     * 按照主键查找
     * @param corpCode
     * @return
     */
    DicCorpVo selectByPrimaryKey(String corpCode);

    /**
     * 根据条件更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DicCorp record);

    /**
     * 按照主键更新全部信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(DicCorp record);

    /**
     * 按照条件分页查询
     * @param corpCode
     * @return
     */
    List<DicCorpVo> selectSelectiveOnPaging(DicCorpCo corpCode);

    /*int selectSelectiveCount(DicCorpCo corpCode);*/

    /**
     * 分页获取所有
     * @return
     */
    List<DicCorpVo> selectAllCorpList();

/*    int selectAllCorpListCount();*/
    
    /**
     * 查询所有公司拓展
     * @author 刘宇 2018年12月27日18:38:05
     * @return
     */
    List<DicCorpVo> selectAllCorpVoList();

    /**
     * 按照条件插入或者更新
     * @param dicCorp
     */
    void insertOrUpdateSelective(DicCorp dicCorp);
    
    /**
     * 按照板块查询公司
     * @param boardCode
     * @return
     */
    List<DicCorpVo> selectByBoardCode(Integer boardCode);
}