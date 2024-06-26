package org.example.service;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.exceptions.AnimalIsNotCompatibleWithEnclosureSpecies;
import org.example.exceptions.NoPlaceLeftedForAnAnimal;

public interface AnimalAssignementService {

    void assignAnimalToEnclosure(Enclosure enclosure, Animal animalToAssign) throws NoPlaceLeftedForAnAnimal, AnimalIsNotCompatibleWithEnclosureSpecies;
}

