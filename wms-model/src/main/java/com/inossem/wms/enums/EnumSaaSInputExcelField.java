package com.inossem.wms.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EnumSaaSInputExcelField {


	Field_poCode("poCode", "PO Code"),
	Field_receiptType("receiptType", "PO Type"),
	Field_shippingRef("shippingRef", "ShippingRef"),
	Field_matCode("matCode", "Item Code"),
	Field_bundleCode("bundleCode", "Lot Number"),
	Field_weightUnitCode("weightUnitCode", "UoM"),
	Field_weightQty("weightQty", "Qty"),
	Field_stockStatus("stockStatus", "Stock Status"),
	Field_vendorCode("vendorCode", "Vendor Code"),
	Field_vendorName("vendorName", "Vendor Name"),
	Field_whCode("whCode", "Warehouse Code"),
	Field_corpCode("corpCode", "Company Code"),
	Field_heatCode("heatCode", "Level 1"),
	Field_skitCode("skitCode", "Level 2"),
	
	/*Field_soCode("soCode", "So Code"),
	Field_soCode("soCode", "So Code"),
	Field_soCode("soCode", "So Code"),
	Field_soCode("soCode", "So Code"),
	Field_soCode("soCode", "So Code"),
	Field_soCode("soCode", "So Code"),
	Field_soCode("soCode", "So Code"),*/
	
	;

    /** 描述 */
    private String name;
    /** 枚举值 */
    private String value;

    private EnumSaaSInputExcelField(String value, String name) {
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
            EnumSaaSInputExcelField[] ary = EnumSaaSInputExcelField.values();
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
            EnumSaaSInputExcelField[] ary = EnumSaaSInputExcelField.values();
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
