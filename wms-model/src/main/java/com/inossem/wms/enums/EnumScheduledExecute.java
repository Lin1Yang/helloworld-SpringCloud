package com.inossem.wms.enums;

public enum EnumScheduledExecute {


    ENUM_SCHEDULED_NOT_EXECUTE((byte)0),
    ENUM_SCHEDULED_IS_EXECUTE((byte)1);

    private Byte value;

    EnumScheduledExecute(Byte value) {
        this.value = value;
    }

    public Byte getValue() {
        return value;
    }
}
