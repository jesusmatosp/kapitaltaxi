package com.kapital.sitramas.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoDocumentoEnum {
	DNI(4),
    CE(5),
    PASAPORTE(6);
    
    private Integer val;
    private static final Map<Integer, TipoDocumentoEnum> lookup = new HashMap<Integer, TipoDocumentoEnum>();

    TipoDocumentoEnum(Integer val) {
        this.val = val;
    }

    static {
        for (TipoDocumentoEnum d : TipoDocumentoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    public int getValue() {
        return val;
    }

    public static TipoDocumentoEnum get(Integer abbreviation) {
        return lookup.get(abbreviation);
    }
}
