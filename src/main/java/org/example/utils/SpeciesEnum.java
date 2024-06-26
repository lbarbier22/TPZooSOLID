package org.example.utils;

public enum SpeciesEnum {

    FELINE("feline"),
    BIRD("bird"),
    FISH("fish");

    private String sizeValue;

    SpeciesEnum(String size) {
        this.sizeValue = size;
    }

    public String getValue() {
        return sizeValue;
    }
}
