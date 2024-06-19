package org.example.entities;

import org.example.utils.SizeEnum;

import java.util.List;

public class Enclosure {
    private int id;
    private String name;
    private SizeEnum size;
    private Species speciesAuthorized;
    private List<Integer> animalsIn;

    public Enclosure(int id, String name, SizeEnum size, Species speciesAuthorized, List<Integer> animalsIn) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.speciesAuthorized = speciesAuthorized;
        this.animalsIn = animalsIn;
    }

    public List<Integer> getAnimalsIn() {
        return animalsIn;
    }

    public void addAnimals(int animalId) {
        this.animalsIn.add(animalId);
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

