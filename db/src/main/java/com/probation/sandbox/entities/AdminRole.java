package com.probation.sandbox.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum AdminRole {

    ADMIN(true),
    USER(false);

    private final static Map<Boolean, AdminRole> ENUM_MAP = new HashMap<>();

    static {
        for (AdminRole item : AdminRole.values()) {
            if (ENUM_MAP.containsKey(item.id)) {
                throw new RuntimeException("TypeOperation duplicate id");
            }
            ENUM_MAP.put(item.id, item);
        }
    }

    private final boolean id;

    public static AdminRole getById(boolean id) {

        AdminRole result = ENUM_MAP.get(id);
        if (result == null) {
            throw new IllegalArgumentException("Role - no matching constant for [" + id + "]");
        }
        return result;
    }
}
