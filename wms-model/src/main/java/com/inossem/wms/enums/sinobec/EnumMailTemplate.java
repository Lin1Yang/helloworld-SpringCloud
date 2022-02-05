package com.inossem.wms.enums.sinobec;

import java.util.HashMap;
import java.util.Map;



public enum EnumMailTemplate {


	SINOBEC_INPUT_PURCHASE(101,"purchaseOrderTemplate","Purchase Order "),
	SINOBEC_INPUT_CUSTOMER_RETURN(102,"returnTemplate","Return "),
	SINOBEC_INPUT_TRANSFER_IN(103,"transferInTemplate","Transfer in "),
	SINOBEC_INPUT_ADJUSTMENT_IN(104,"adjustmentInTemplate","Adjustment In "),
	SINOBEC_INPUT_MASK_IN(105,"",""),
	SINOBEC_INPUT_MASK_RETURN(106,"",""),

	//销售出库
	SINOBEC_OUTPUT_SALE(201,"salesOrderTemplate","Sales Order "),
	//转出
	SINOBEC_OUTPUT_TRANSFER_OUT(202,"transferOutTemplate.","Transfer Out "),
	//委外加工转出
	SINOBEC_OUTPUT_COMMISSIONED_PROCESSING(203,"adjustmentOutTemplate","Adjustment Out "),
	//委外加工转出
	SINOBEC_OUTPUT_MASK_OUT(204,"",""),
	
	
	SINOBEC_TASK_PUT_AWAY(301,"",""),
	SINOBEC_TASK_PICK(302,"",""),
	SINOBEC_TASK_ARRANGE(303,"",""),
	SINOBEC_STOCK_TAKE_BIN_ARRANGE(304,"",""),
	
	SINOBEC_STOCK_TAKE(400,"",""),
	
	;
	
	/** 描述 */
	private String templateName;
	/** 枚举值 */
	private Integer value;
	
	private String subject;

	private EnumMailTemplate(Integer value, String templateName,String subject) {
		this.subject = subject;
		this.value = value;
		this.templateName = templateName;
	}
	private static Map<Integer, String> templateaMap;
	
	private static Map<Integer, String> subjectMap;

	private static Map<Integer, String> toTemplateMap() {
		if (templateaMap == null) {
			EnumMailTemplate[] ary = EnumMailTemplate.values();
			Map<Integer, String> tempMap = new HashMap<>();
			for (EnumMailTemplate o : ary) {
				tempMap.put(o.getValue(), o.getTemplateName());
			}
			templateaMap = tempMap;
		}
		return templateaMap;
	}
	
	private static Map<Integer, String> toSubjectMap() {
		if (subjectMap == null) {
			EnumMailTemplate[] ary = EnumMailTemplate.values();
			Map<Integer, String> tempMap = new HashMap<>();
			for (EnumMailTemplate o : ary) {
				tempMap.put(o.getValue(), o.getSubject());
			}
			subjectMap = tempMap;
		}
		return subjectMap;
	}

	public static String getTemplateNameByValue(Integer value){
		return toTemplateMap().get(value);
	}

	public static String getSubjectByValue(Integer value){
		return toSubjectMap().get(value);
	}

	

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


}
