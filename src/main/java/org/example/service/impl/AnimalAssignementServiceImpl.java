package org.example.service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.service.AnimalAssignementService;


public class AnimalAssignementServiceImpl implements AnimalAssignementService {

    Enclosure enclosure;

    public AnimalAssignementServiceImpl(Enclosure enclosure) {
        this.enclosure = enclosure;
    }


    public void assignAnimalToEnclosure(Animal animalToAssign) {
        if(isAnimalIsCompatible(animalToAssign,enclosure)){
          enclosure.addAnimal(animalToAssign);
        }
    }

    private boolean isAnimalIsCompatible(Animal animal, Enclosure enclosure) {
        if (enclosure.getSpecieAuthorized().equals(animal.getSpecie())){
            return true;
        }else {
            return false;
        }
    }
}

