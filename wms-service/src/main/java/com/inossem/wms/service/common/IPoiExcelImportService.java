package com.inossem.wms.service.common;

import java.util.List;

import com.inossem.wms.model.dic.DicExcellCheck;

/**
 * POIExcel导入
 * @author 田阳
 * @date 2019年1月11日
 */
public interface IPoiExcelImportService {
	
	/**
	 * excel导入通用方法
	 * @param url   文件地址
	 * @param sheetIndex   sheet页，0开始
	 * @param enumExcelType   导入类型
	 * @param entityClass  实体类
	 * @param dicExcellCheckList  包含、不包含
	 * @param cutFlag  true:有失败就不插入数据库， false： 最后插入成功的数据
	 * @throws Exception
	 */
	void  insertExcelData(String url,Integer sheetIndex ,String enumExcelType,Class<?> entityClass,List<DicExcellCheck> dicExcellCheckList,boolean cutFlag) throws Exception;


}
