package org.example.utils;

public enum SizeEnum {

    SMALL(3),
    MEDIUM(8),
    LARGE(12),
    XLARGE(20);

    private int sizeValue;

    SizeEnum(int size) {
        this.sizeValue = size;
    }

    public int getValue() {
        return sizeValue;
    }
}
