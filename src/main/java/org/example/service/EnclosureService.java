package org.example.service;

import org.example.entities.Animal;
import org.example.entities.Enclosure;

import java.util.List;
import java.util.Optional;

public interface EnclosureService {
    void addEnclosure(Enclosure enclosure);

    void updateEnclosure(Enclosure enclosure);

    void removeEnclosure(Enclosure enclosure);

    void assignAnimalToEnclosure(Animal animal, Enclosure enclosure);
}

