package service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.entities.Visite;
import org.example.entities.Zoo;
import org.example.exceptions.RemoveEnclosureToZooException;
import org.example.exceptions.TooMuchEnclosuresInVisite;
import org.example.service.impl.EnclosureAssignementServiceImpl;
import org.example.utils.SizeEnum;
import org.example.utils.SpeciesEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EnclosureAssignementServiceImplTest {

    private EnclosureAssignementServiceImpl enclosureAssignementService;
    Enclosure largeFelineEnclosureEmpty;
    Animal felineAnimal;
    Visite visiteAlreadyFull;
    Zoo zoo = new Zoo();

    @BeforeEach
    public void init() {
        largeFelineEnclosureEmpty = createTestLargeFelineEnclosureEmptyOfAnimal();
        felineAnimal = createTestFelineAnimal();
        visiteAlreadyFull = createVisiteThatIsAlreadyFull();
        enclosureAssignementService = new EnclosureAssignementServiceImpl(zoo);
    }

    @Test
    public void testAssignEnclosureToZoo() {
        enclosureAssignementService.assignEnclosureToZoo(largeFelineEnclosureEmpty);
        assertTrue(zoo.getEnclosuresInZoo().contains(largeFelineEnclosureEmpty));
    }

    @Test
    public void testRemoveEnclosureToZooThatContainsAnimalsItShouldFail(){
        enclosureAssignementService.assignEnclosureToZoo(largeFelineEnclosureEmpty);
        largeFelineEnclosureEmpty.addAnimal(felineAnimal);

        Exception removeEnclosureToZooException = assertThrows(RemoveEnclosureToZooException.class, () ->
            enclosureAssignementService.removeEnclosureToZoo(largeFelineEnclosureEmpty));

        String actualMessage = removeEnclosureToZooException.getMessage();
        String expectedMessage = "Cannot remove this enclosure 'Savannah' from the zoo because it contains animals !";

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testAssignEnclosureToVisiteThatIsAlreadyFull(){
        Exception tooMuchEnclosuresInVisite = assertThrows(TooMuchEnclosuresInVisite.class, () ->
                enclosureAssignementService.assignEnclosureToVisite(visiteAlreadyFull, largeFelineEnclosureEmpty));

        String actualMessage = tooMuchEnclosuresInVisite.getMessage();
        String expectedMessage = "There is too much enclosures to this visite, You need to remove some enclosures first!";

        assertTrue(actualMessage.contains(expectedMessage));

    }

    private Visite createVisiteThatIsAlreadyFull() {
        Enclosure enclosure1 = new Enclosure("Savannah", SizeEnum.LARGE, SpeciesEnum.FELINE);
        Enclosure enclosure2 = new Enclosure("Santa Home", SizeEnum.XLARGE, SpeciesEnum.FELINE);
        Enclosure enclosure3 = new Enclosure("Oceania", SizeEnum.SMALL, SpeciesEnum.FISH);
        Enclosure enclosure4 = new Enclosure("SeaLand", SizeEnum.MEDIUM, SpeciesEnum.BIRD);
        Enclosure enclosure5 = new Enclosure("JungleSpeed", SizeEnum.LARGE, SpeciesEnum.FELINE);

        List<Enclosure> listOfEnclosures = List.of(enclosure1,enclosure2,enclosure3,enclosure4,enclosure5);

        return new Visite(LocalDate.of(2024,8,22), LocalTime.of(13,00), LocalTime.of(15,00), listOfEnclosures);
    }

    private Enclosure createTestLargeFelineEnclosureEmptyOfAnimal() {
        return new Enclosure("Savannah", SizeEnum.LARGE, SpeciesEnum.FELINE);
    }

    private Animal createTestFelineAnimal() {
        return new Animal("Kaaris", SpeciesEnum.FELINE, LocalDate.of(1999,8,22));
    }
}
