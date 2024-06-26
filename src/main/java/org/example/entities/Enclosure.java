package org.example.entities;

import org.example.utils.SizeEnum;
import org.example.utils.SpeciesEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Enclosure {
    private UUID id;
    private String name;
    private SizeEnum size;
    private SpeciesEnum specieAuthorized;
    private List<Animal> animals;

    public Enclosure(String name, SizeEnum size, SpeciesEnum speciesAuthorized, List<Animal> animals) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.size = size;
        this.specieAuthorized = speciesAuthorized;
        this.animals = animals;
    }

    public Enclosure(String name, SizeEnum size, SpeciesEnum speciesAuthorized) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.size = size;
        this.specieAuthorized = speciesAuthorized;
        this.animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void changeSpecieAuthorized(SpeciesEnum speciesEnum){
        specieAuthorized = speciesEnum;
    }

    public SpeciesEnum getSpecieAuthorized() {
        return specieAuthorized;
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

}

