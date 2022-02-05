package com.inossem.wms.enums;


import java.util.HashMap;
import java.util.Map;

public enum EnumInputStrategy {
    INPUT_STRATEGY_MANUAL("1", "手工入库"),
    INPUT_STRATEGY_LARGE_CAPACITY("B", "大容量仓储"),
    INPUT_STRATEGY_FIXED_BIN("F", "固定仓位"),
    INPUT_STRATEGY_INCREASE_EXISTING_STOCK("I", "增加现有库存"),
    INPUT_STRATEGY_NEXT_VACANT_BIN("L", "下一个空仓位"),
    INPUT_STRATEGY_UNITSTYPE("P", "仓储单位类型");

    /**
     * 描述
     */
    private String name;
    /**
     * 枚举值
     */
    private String value;

    private static Map<String, String> map;

    private static Map<String, String> toMap() {
        if (map == null) {
            EnumInputStrategy[] ary = EnumInputStrategy.values();
            Map<String, String> tempMap = new HashMap<>();
            for (EnumInputStrategy i : ary) {
                tempMap.put(i.getValue(), i.getName());
            }
            map = tempMap;
        }
        return map;
    }

    public static String getNameByValue(String value){
        return toMap().get(value);
    }
    private EnumInputStrategy(String name, String value) {
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
}
