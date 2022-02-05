package com.inossem.wms.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EnumSaaSOutputExcelField {


	Field_poCode("soCode", "SO Code"),
	Field_receiptType("receiptType", "SO Type"),
	Field_shippingRef("shippingRef", "ShippingRef"),
	Field_matCode("matCode", "Item Code"),
	Field_bundleCode("bundleCode", "Lot Number"),
	Field_weightUnitCode("weightUnitCode", "UoM"),
	Field_weightQty("weightQty", "Qty"),
	
	
	Field_heatCode("heatCode", "Level 1"),
	Field_skitCode("skitCode", "Level 2"),
	
	
	;

    /** 描述 */
    private String name;
    /** 枚举值 */
    private String value;

    private EnumSaaSOutputExcelField(String value, String name) {
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
            EnumSaaSOutputExcelField[] ary = EnumSaaSOutputExcelField.values();
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
            EnumSaaSOutputExcelField[] ary = EnumSaaSOutputExcelField.values();
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
