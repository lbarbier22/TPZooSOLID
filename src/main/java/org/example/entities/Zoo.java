package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Enclosure> enclosures;
    private List<Animal> animals;

    public Zoo(List<Enclosure> enclosures) {
        this.enclosures = enclosures;
    }

    public Zoo() {
        this.enclosures = new ArrayList<>();
    }

    public void addAnimalToZoo(Animal animal){
        animals.add(animal);
    }

    public void relieveAnimalOfZoo(Animal animal){
        animals.remove(animal);
    }

    public void addEnclosureToZoo(Enclosure enclosure){
        enclosures.add(enclosure);
    }

    public void removeEnclosureToZoo(Enclosure enclosure){
        enclosures.remove(enclosure);
    }

    public List<Enclosure> getEnclosuresInZoo() {
        return enclosures;
    }

    public List<Animal> getAllAnimalsInZoo() {
        return animals;
    }
}
