package org.example.utils;

public enum SizeEnum {

    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    XLARGE("extra-large");

    private String sizeValue;

    SizeEnum(String size) {
        this.sizeValue = size;
    }

    public String getValue() {
        return sizeValue;
    }
}
