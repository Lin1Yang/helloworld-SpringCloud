package com.inossem.wms.dao.sequence;

import org.springframework.stereotype.Component;

@Component
public interface SequenceDAO {
	
	/**
	 * 根据流水号求下一位流水
	 * 详细方法见数据库next_value 函数
	 * @param sequenceCode	流水code
	 * @return
	 */
	String selectNextValue(String sequenceCode);
	
	/**
	 * 根据流水号取当天的流水
	 * 详细方法见数据库next_value_daily 函数
	 * @param sequenceCode	流水code
	 * @return
	 */
	String selectNextValueDaily(String sequenceCode);
	
	/**
	 * 根据流水号取对应主数据的流水
	 * 例如工厂的erp批次流水，使用fty_8000获取8000工厂的erp批次流水
	 * @param sequenceCode	流水code
	 * @return
	 */
	String selectNextValueByCode(String sequenceCode);
	
	/**
	 * 根据流水号取当天的流水
	 * 详细方法见数据库next_value_code_daily 函数
	 * 例如工厂的erp批次流水，使用fty_8000获取8000工厂的erp批次流水
	 * @param sequenceCode	流水code
	 * @return
	 */
	String selectNextValueDailyByCode(String sequenceCode);
}
