package org.example.service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.exceptions.AnimalIsNotCompatibleWithEnclosureSpecies;
import org.example.exceptions.NoPlaceLeftedForAnAnimal;
import org.example.service.AnimalAssignementService;


public class AnimalAssignementServiceImpl implements AnimalAssignementService {

    public AnimalAssignementServiceImpl() {
    }


    public void assignAnimalToEnclosure(Enclosure enclosure, Animal animalToAssign) throws NoPlaceLeftedForAnAnimal, AnimalIsNotCompatibleWithEnclosureSpecies {
        if(isTherePlaceForAnAnimal(enclosure)){
            if (isAnimalIsCompatible(animalToAssign,enclosure)){
                enclosure.addAnimal(animalToAssign);
            } else {
                throw new AnimalIsNotCompatibleWithEnclosureSpecies(animalToAssign.getName(), enclosure.getSpecieAuthorized().getValue());
            }
        } else {
            throw new NoPlaceLeftedForAnAnimal(animalToAssign.getName());
        }
    }

    private static boolean isTherePlaceForAnAnimal(Enclosure enclosure) {
        return enclosure.getAnimals().size() < enclosure.getSize().getValue();
    }

    private boolean isAnimalIsCompatible(Animal animal, Enclosure enclosure) {
        if (enclosure.getSpecieAuthorized().equals(animal.getSpecie())){
            return true;
        }else {
            return false;
        }
    }
}

