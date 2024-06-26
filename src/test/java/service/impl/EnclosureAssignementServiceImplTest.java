package service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.entities.Zoo;
import org.example.exceptions.RemoveEnclosureToZooException;
import org.example.service.impl.EnclosureAssignementServiceImpl;
import org.example.utils.SizeEnum;
import org.example.utils.SpeciesEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EnclosureAssignementServiceImplTest {

    private EnclosureAssignementServiceImpl enclosureAssignementService;
    Enclosure enclosure;
    Animal animal;
    Zoo zoo = new Zoo();

    @BeforeEach
    public void init() {
        enclosure = createTestLargeFelineEnclosureEmptyOfAnimal();
        animal = createTestFelineAnimal();
        enclosureAssignementService = new EnclosureAssignementServiceImpl(zoo);
    }

    @Test
    public void testAssignEnclosureToZoo() {
        enclosureAssignementService.assignEnclosureToZoo(enclosure);
        assertTrue(zoo.getEnclosuresInZoo().contains(enclosure));
    }

    @Test
    public void testRemoveEnclosureToZooThatContainsAnimalsItShouldFail(){
        enclosureAssignementService.assignEnclosureToZoo(enclosure);
        enclosure.addAnimal(animal);

        Exception removeEnclosureToZooException = assertThrows(RemoveEnclosureToZooException.class, () ->
            enclosureAssignementService.removeEnclosureToZoo(enclosure));

        String actualMessage = removeEnclosureToZooException.getMessage();
        String expectedMessage = "Cannot remove this enclosure 'Savannah' from the zoo because it contains animals !";

        assertTrue(actualMessage.contains(expectedMessage));

    }

    private Enclosure createTestLargeFelineEnclosureEmptyOfAnimal() {
        return new Enclosure("Savannah", SizeEnum.LARGE, SpeciesEnum.FELINE);
    }

    private Animal createTestFelineAnimal() {
        return new Animal("Kaaris", SpeciesEnum.FELINE, LocalDate.of(1999,8,22));
    }
}
