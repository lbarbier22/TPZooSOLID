package org.example.entities;

import java.util.List;

public class Species {

    private List<String> species;

    public Species(List<String> species) {
        this.species = species;
    }

    public void addSpecies(String species){
        this.species.add(species);
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }
}
