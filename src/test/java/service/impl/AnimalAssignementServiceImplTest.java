package service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.exceptions.AnimalIsNotCompatibleWithEnclosureSpecies;
import org.example.exceptions.NoPlaceLeftedForAnAnimal;
import org.example.exceptions.TooMuchEnclosuresInVisite;
import org.example.service.impl.AnimalAssignementServiceImpl;
import org.example.utils.SizeEnum;
import org.example.utils.SpeciesEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalAssignementServiceImplTest {

    private AnimalAssignementServiceImpl animalAssignementService;
    Enclosure smallFelineEnclosureEmpty;
    Animal birdAnimal;

    @BeforeEach
    public void init() {
        smallFelineEnclosureEmpty = createTestSmallFelineEnclosureEmptyOfAnimal();
        animalAssignementService = new AnimalAssignementServiceImpl();
        birdAnimal = createTestBirdAnimal();
    }

    @Test
    public void testAssignAnimalToEnclosure_NotCompatible() throws AnimalIsNotCompatibleWithEnclosureSpecies, NoPlaceLeftedForAnAnimal {
        Exception animalIsNotCompatibleWithEnclosureSpecies = assertThrows(AnimalIsNotCompatibleWithEnclosureSpecies.class, () ->
                animalAssignementService.assignAnimalToEnclosure(smallFelineEnclosureEmpty, birdAnimal));

        String actualMessage = animalIsNotCompatibleWithEnclosureSpecies.getMessage();
        String expectedMessage = "The animal named 'Titi' is not compatible with the species (feline) of the enclosure !";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAssignAnimalToEnclosure_Full() throws AnimalIsNotCompatibleWithEnclosureSpecies, NoPlaceLeftedForAnAnimal {
        Animal felineKaaris = new Animal("Kaaris", SpeciesEnum.FELINE, LocalDate.of(1999,8,22));
        Animal felineBooba = new Animal("Booba", SpeciesEnum.FELINE, LocalDate.of(1999,8,22));
        Animal felineDamso = new Animal("Damso", SpeciesEnum.FELINE, LocalDate.of(1999,8,22));
        Animal felineFouinyBabe = new Animal("FouinyBabe", SpeciesEnum.FELINE, LocalDate.of(1999,8,22));

        animalAssignementService.assignAnimalToEnclosure(smallFelineEnclosureEmpty, felineKaaris);
        animalAssignementService.assignAnimalToEnclosure(smallFelineEnclosureEmpty, felineBooba);
        animalAssignementService.assignAnimalToEnclosure(smallFelineEnclosureEmpty, felineDamso);

        assertTrue(smallFelineEnclosureEmpty.getAnimals().contains(felineKaaris));
        assertTrue(smallFelineEnclosureEmpty.getAnimals().contains(felineBooba));
        assertTrue(smallFelineEnclosureEmpty.getAnimals().contains(felineDamso));


        Exception noPlaceLeftedForAnAnimal = assertThrows(NoPlaceLeftedForAnAnimal.class, () ->
                animalAssignementService.assignAnimalToEnclosure(smallFelineEnclosureEmpty, felineFouinyBabe));

        String actualMessage = noPlaceLeftedForAnAnimal.getMessage();
        String expectedMessage = "There is no place for FouinyBabe!";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    private Enclosure createTestSmallFelineEnclosureEmptyOfAnimal() {
        return new Enclosure("Savannah", SizeEnum.SMALL, SpeciesEnum.FELINE);
    }

    private Animal createTestBirdAnimal() {
        return new Animal("Titi", SpeciesEnum.BIRD, LocalDate.of(1999,8,22));
    }
}
