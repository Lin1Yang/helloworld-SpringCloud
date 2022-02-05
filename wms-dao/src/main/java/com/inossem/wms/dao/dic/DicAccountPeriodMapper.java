package com.inossem.wms.dao.dic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inossem.wms.co.dic.DicAccountPeriodCo;
import com.inossem.wms.model.dic.DicAccountPeriod;
import com.inossem.wms.vo.auth.UserAccountPeriod;
import com.inossem.wms.vo.dic.DicAccountPeriodVo;



public interface DicAccountPeriodMapper {
    int deleteByPrimaryKey(Integer accountPeriodId);

    int insert(DicAccountPeriod record);

    int insertSelective(DicAccountPeriod record);

    DicAccountPeriod selectByPrimaryKey(Integer accountPeriodId);

    int updateByPrimaryKeySelective(DicAccountPeriod record);

    int updateByPrimaryKey(DicAccountPeriod record);
    
    /**
     * 账期列表页分页
     * @param  
     * @author lys
     * @return 
     */
    List<DicAccountPeriodVo> selectPeriodListOnPaging(DicAccountPeriodCo periodCo);


    
    /**
     * 账期详情页
     * @param  
     * @author lys
     * @return 
     */
    List<DicAccountPeriodVo> selectPeriodViewByIds(List<Integer> idList);
    
    
    /**
     * 多条新增
     * @param  
     * @author lys
     * @return 
     */
    void insertPeriodList(List<DicAccountPeriod> periodList);
    
    /**
     * 多条修改
     * @param  
     * @author lys
     * @return 
     */
    void updatePeriodList(List<DicAccountPeriod> periodList);
    
    /**
     * 多条逻辑删除
     * @param  
     * @author lys
     * @return 
     */
    void deleteByIds(List<Integer> idList);
    
    /**
     * 多条查询
     * @param  
     * @author lys
     * @return 
     */
    List<DicAccountPeriodVo> selectByIds(List<Integer> idList);
    
    /**
     * 根据工厂编码查询实际过账日期
     * @param  
     * @author lys
     * @return 
     */
    List<DicAccountPeriod> selectPostDateByFtyCode(@Param("ftyCode")String ftyCode,@Param("postDate")String postDate);
    
    /**
     * 
     * @param  
     * @author lys
     * @return 
     */
    int countAccountPeriods(DicAccountPeriod record);
    
    /**
     * 根据板块、公司、账期年度查询
     * 
     * @param boardCode
     * @param corpCode
     * @param accountYear
     * @return
     * @author libin
     */
    List<DicAccountPeriod> selectByCo(@Param("boardCode") Integer boardCode,
    		@Param("corpCode") String corpCode);

	/**
	 * 根据用户id查询用户账期对象
	 * 
	 * @param userId
	 * @return
	 * @author libin
	 */
	UserAccountPeriod selectByUserId(Integer userId);

    /**
     * 如果是新增帐期，则获取所有的帐期列表
     * 如果是修改帐期，则获取除当前修改的帐期  所以帐期列表
     * @param periodCo
     * @return
     */
    List<DicAccountPeriodVo> selectAllPeriodList(DicAccountPeriodCo periodCo);
}