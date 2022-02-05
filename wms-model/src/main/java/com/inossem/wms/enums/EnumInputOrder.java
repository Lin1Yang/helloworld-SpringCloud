package com.inossem.wms.enums;


import java.util.HashMap;
import java.util.Map;

public enum EnumInputOrder {
    INPUT_ORDER_STORAGE_BEFORE_SHELVING((byte) 10, "A-先入库后上架"),
    INPUT_ORDER_STORAGE_AFTER_SHELVING((byte) 20, "B-先上架后入库"),
    INPUT_ORDER_STORAGE_AND_SHELVING((byte) 30, "C-同时入库上架");

    /**
     * 描述
     */
    private byte name;
    /**
     * 枚举值
     */
    private String value;

    private static Map<Object, String> map;

    private static Map<Object, String> toMap() {
        if (map == null) {
            EnumInputOrder[] ary = EnumInputOrder.values();
            Map<Object, String> tempMap = new HashMap<>();
            for (EnumInputOrder o : ary) {
                tempMap.put(o.getName(), o.getValue());
            }
            map = tempMap;
        }
        return map;
    }

    public static String getNameByValue(byte value){
        return toMap().get(value);
    }

    private EnumInputOrder(byte name, String value) {
        this.name = name;
        this.value = value;
    }

    public byte getName() {
        return name;
    }

    public EnumInputOrder setName(byte name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public EnumInputOrder setValue(String value) {
        this.value = value;
        return this;
    }
}
