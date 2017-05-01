package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoProgramacionEnum {
	BORRADOR(0),
    ENVIADO(1),
    PROGRAMADO(2);
    
    private Integer val;
    private static final Map<Integer, EstadoProgramacionEnum> lookup = new HashMap<Integer, EstadoProgramacionEnum>();

    EstadoProgramacionEnum(Integer val) {
        this.val = val;
    }

    static {
        for (EstadoProgramacionEnum d : EstadoProgramacionEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public int getValue() {
        return val;
    }

    public static EstadoProgramacionEnum get(Integer abbreviation) {
        return lookup.get(abbreviation);
    }
}
