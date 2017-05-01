package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoUsuarioEnum {
	CLIENTE(1L),
	PROGRAMADOR_KAPITAL(2L),
	CONDUCTOR(3L);
	
    private Long val;
    private static final Map<Long, TipoUsuarioEnum> lookup = new HashMap<Long, TipoUsuarioEnum>();
    
    TipoUsuarioEnum(Long val) {
        this.val = val;
    }
    static {
        for (TipoUsuarioEnum d : TipoUsuarioEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public long getValue() {
        return val;
    }

    public static TipoUsuarioEnum get(Long abbreviation) {
        return lookup.get(abbreviation);
    }
}
