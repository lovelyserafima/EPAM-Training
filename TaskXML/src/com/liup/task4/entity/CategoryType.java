package com.liup.task4.entity;

public enum CategoryType {
    NEWS("news"),
    ENTERTAINMENT("entertainment"),
    SCIENCE("science");
    private final String value;

    CategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CategoryType fromValue(String v) {
        for (CategoryType c : CategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
