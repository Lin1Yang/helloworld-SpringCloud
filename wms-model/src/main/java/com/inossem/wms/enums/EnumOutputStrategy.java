package com.inossem.wms.enums;


import java.util.HashMap;
import java.util.Map;

public enum EnumOutputStrategy {
    OUTPUT_STRATEGY_MANUAL("1", "手工出库"),
    OUTPUT_STRATEGY_MINIMUM_QUANTITY_FIRST_OUT("A", "最小数量先出"),
    OUTPUT_STRATEGY_FIFO("F", "先进先出"),
    OUTPUT_STRATEGY_Quality_ASSURANCE_MATURITY_DATE_FIRST_OUT("H", "质保到期日先出"),
    OUTPUT_STRATEGY_INCLUDING_LARGE_SMALL_QUANTITIES("M", "包括大/小数量"),
    OUTPUT_STRATEGY_FIXED_BIN("P", "固定仓位");

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
            EnumOutputStrategy[] ary = EnumOutputStrategy.values();
            Map<String, String> tempMap = new HashMap<>();
            for (EnumOutputStrategy e : ary) {
                tempMap.put(e.getValue(), e.getName());
            }
            map=tempMap;
        }
        return map;
    }

    public static String getNameByValue(String value){
        return toMap().get(value);
    }

    private EnumOutputStrategy(String name, String value) {
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
