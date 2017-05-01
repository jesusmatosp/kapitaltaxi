package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCivilEnum {
	SOLTERO(1),
    CASADO(2),
    VIUDO(3),
    DIVORSIADO(4);
    
    private Integer val;
    private static final Map<Integer, EstadoCivilEnum> lookup = new HashMap<Integer, EstadoCivilEnum>();

    EstadoCivilEnum(Integer val) {
        this.val = val;
    }

    static {
        for (EstadoCivilEnum d : EstadoCivilEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public int getValue() {
        return val;
    }

    public static EstadoCivilEnum get(Integer abbreviation) {
        return lookup.get(abbreviation);
    }
}
