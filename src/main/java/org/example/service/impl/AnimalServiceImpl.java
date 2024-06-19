package org.example.service.impl;

import org.example.entities.Animal;
import org.example.repository.AnimalRepository;
import org.example.service.AnimalService;

import java.util.Optional;

public class AnimalServiceImpl implements AnimalService {
    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public void updateAnimal(Animal animal) {
        animalRepository.update(animal);
    }

    @Override
    public void removeAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }

    @Override
    public Optional<Animal> getAnimalById(int animalId) {
        return animalRepository.findById(animalId);
    }
}