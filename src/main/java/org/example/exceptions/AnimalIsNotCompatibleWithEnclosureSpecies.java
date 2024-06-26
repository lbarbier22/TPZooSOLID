package org.example.exceptions;

public class AnimalIsNotCompatibleWithEnclosureSpecies extends Exception{

    public AnimalIsNotCompatibleWithEnclosureSpecies(String animalName, String enclosureSpecies) {
        super("The animal named '"+animalName+"' is not compatible with the species ("+enclosureSpecies+") of the enclosure !") ;
    }
}
