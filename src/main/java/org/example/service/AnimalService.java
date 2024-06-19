package org.example.service;

import org.example.entities.Animal;

import java.util.Optional;

public interface AnimalService {
    void addAnimal(Animal animal);
    void updateAnimal(Animal animal);
    void removeAnimalById(int animalId);
    Optional<Animal> getAnimalById(int animalId);
}
