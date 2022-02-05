package com.inossem.wms.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计价方式
 * @author : sw
 * @date : 2019/2/20
 */
public enum EnumPriceMethod {

    MOVE("移动平均", "V"),

    STANDARD("标准价", "S");

    /** 描述 */
    private String name;
    /** 枚举值 */
    private String value;

    private EnumPriceMethod(String name, String value) {
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
            EnumPriceMethod[] ary = EnumPriceMethod.values();
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
            EnumPriceMethod[] ary = EnumPriceMethod.values();
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
