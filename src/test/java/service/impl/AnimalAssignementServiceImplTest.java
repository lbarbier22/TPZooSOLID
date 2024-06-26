package service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.service.impl.AnimalAssignementServiceImpl;
import org.example.utils.SizeEnum;
import org.example.utils.SpeciesEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalAssignementServiceImplTest {

    private AnimalAssignementServiceImpl animalAssignementService;
    Enclosure enclosure;
    Animal animal;

    @BeforeEach
    public void init() {
        enclosure = createTestLargeFelineEnclosureEmptyOfAnimal();
        animalAssignementService = new AnimalAssignementServiceImpl(enclosure);
        animal = createTestFelineAnimal();
    }

    @Test
    public void testAssignAnimalToEnclosure_NotCompatible() {
        animalAssignementService.assignAnimalToEnclosure(animal);
        assertTrue(enclosure.getAnimals().contains(animal));
    }

    private Enclosure createTestLargeFelineEnclosureEmptyOfAnimal() {
        return new Enclosure("Savannah", SizeEnum.LARGE, SpeciesEnum.FELINE);
    }

    private Animal createTestFelineAnimal() {
        return new Animal("Kaaris", SpeciesEnum.FELINE, LocalDate.of(1999,8,22));
    }
}
