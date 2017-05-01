package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoEnum {
	ACTIVO(1),
    INACTIVO(0);
    
    private Integer val;
    private static final Map<Integer, EstadoEnum> lookup = new HashMap<Integer, EstadoEnum>();

    EstadoEnum(Integer val) {
        this.val = val;
    }

    static {
        for (EstadoEnum d : EstadoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public int getValue() {
        return val;
    }

    public static EstadoEnum get(Integer abbreviation) {
        return lookup.get(abbreviation);
    }
}
