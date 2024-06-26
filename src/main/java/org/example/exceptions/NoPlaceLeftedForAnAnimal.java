package org.example.exceptions;

public class NoPlaceLeftedForAnAnimal extends Exception{

    public NoPlaceLeftedForAnAnimal(String animalName) {
        super("There is no place for "+animalName+"!") ;
    }
}
