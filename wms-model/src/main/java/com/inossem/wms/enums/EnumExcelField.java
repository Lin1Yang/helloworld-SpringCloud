package com.inossem.wms.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EnumExcelField {


	Field_poCode("poCode", "poCode"),

	Field_shippingRef("shippingRef", "shippingRef"),
	Field_matCode("matCode", "matCode"),
	Field_PalletCode("palletCode", "PalletCode"),
	Field_cartonCode("cartonCode", "cartonCode"),
	Field_boxQty("weightQty", "boxQty"),
	Field_PCS_QTY("receiptQty", "PCS-QTY"),
	Field_vendorCode("vendorCode", "vendorCode"),
	Field_vendorName("vendorName", "vendorName"),
	Field_whCode("whCode", "whCode"),
	Field_corpCode("corpCode", "corpCode"),
	Field_poType("poType", "poType"),
	Field_soCode("soCode", "soCode"),
	
	;

    /** 描述 */
    private String name;
    /** 枚举值 */
    private String value;

    private EnumExcelField(String value, String name) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private static List<Map<String, String>> list;
    private static Map<String, String> map;

    public static List<Map<String, String>> toList() {
        if (list == null) {
            EnumExcelField[] ary = EnumExcelField.values();
            List<Map<String, String>> listTmp = new ArrayList<Map<String, String>>();
            for (int i = 0; i < ary.length; i++) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("value", String.valueOf(ary[i].getValue()));
                map.put("name", ary[i].getName());
                listTmp.add(map);
            }
            list = listTmp;
        }
        return list;
    }

    public static Map<String, String> toMap() {
        if (map == null) {
            EnumExcelField[] ary = EnumExcelField.values();
            Map<String, String> enumMap = new HashMap<String, String>();
            for (int num = 0; num < ary.length; num++) {
                enumMap.put(ary[num].getValue(), ary[num].getName());
            }
            map = enumMap;
        }
        return map;
    }

    public static String getNameByValue(String value) {
        return toMap().get(value);
    }

}
