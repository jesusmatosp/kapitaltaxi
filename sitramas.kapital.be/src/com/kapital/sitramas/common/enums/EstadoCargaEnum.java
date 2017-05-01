package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCargaEnum {
	INICIADO("INICIADO"),
    COMPLETADO("COMPLETADO");
    
    private String val;
    private static final Map<String, EstadoCargaEnum> lookup = new HashMap<String, EstadoCargaEnum>();

    EstadoCargaEnum(String val) {
        this.val = val;
    }

    static {
        for (EstadoCargaEnum d : EstadoCargaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public String getValue() {
        return val;
    }

    public static EstadoCargaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }
}
