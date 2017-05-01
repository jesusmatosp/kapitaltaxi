package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum SexoEnum {
	MASCULINO("M"),
    FEMENINO("F");
    
    private String val;
    private static final Map<String, SexoEnum> lookup = new HashMap<String, SexoEnum>();

    SexoEnum(String val) {
        this.val = val;
    }

    static {
        for (SexoEnum d : SexoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public String getValue() {
        return val;
    }

    public static SexoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
