package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum ParametroEnum {
	TIPO_USUARIO(1L),
	TIPO_DOCUMENTO(2L);
    
    private Long val;
    private static final Map<Long, ParametroEnum> lookup = new HashMap<Long, ParametroEnum>();

    ParametroEnum(Long val) {
        this.val = val;
    }

    static {
        for (ParametroEnum d : ParametroEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public Long getValue() {
        return val;
    }

    public static ParametroEnum get(Long abbreviation) {
        return lookup.get(abbreviation);
    }
}
