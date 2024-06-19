package org.example.service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.repository.EnclosureRepository;
import org.example.service.AnimalService;
import org.example.service.EnclosureService;

import java.util.List;


public class EnclosureServiceImpl implements EnclosureService {
    private final EnclosureRepository enclosureRepository;
    private final AnimalService animalService;

    public EnclosureServiceImpl(AnimalService animalService, EnclosureRepository enclosureRepository) {
        this.enclosureRepository = enclosureRepository;
        this.animalService = animalService;
    }

    @Override
    public void addEnclosure(Enclosure enclosure) {
        enclosureRepository.save(enclosure);
    }

    @Override
    public void updateEnclosure(Enclosure enclosure) {
        enclosureRepository.update(enclosure);
    }

    @Override
    public void removeEnclosure(Enclosure enclosure) {
        enclosureRepository.deleteById(enclosure.getId());
    }

    @Override
    public void assignAnimalToEnclosure(Animal animalToAssign, Enclosure enclosure) {
        if(isCompatible(animalToAssign,enclosure)){
          enclosure.addAnimals(animalToAssign.getId());
        }
    }

    private boolean isCompatible(Animal animal, Enclosure enclosure) {
        if (enclosure.getSpeciesAuthorized().getSpecies().contains(animal.getSpecies())){
            return true;
        }else {
            return false;
        }
    }
}

