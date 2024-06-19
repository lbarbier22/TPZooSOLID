package org.example.entities;

import org.example.utils.SizeEnum;

public class Enclosure {
    private int id;
    private String name;
    private SizeEnum size;
    private Species speciesAuthorized;

    public Enclosure(int id, String name, SizeEnum size, Species speciesAuthorized) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.speciesAuthorized = speciesAuthorized;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpeciesAuthorized() {
        return speciesAuthorized;
    }

    public void setSpeciesAuthorized(Species speciesAuthorized) {
        this.speciesAuthorized = speciesAuthorized;
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

}

