package service.impl;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.entities.Species;
import org.example.repository.EnclosureRepository;
import org.example.service.AnimalService;
import org.example.service.impl.EnclosureServiceImpl;
import org.example.utils.SizeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class EnclosureServiceImplTest {

    private EnclosureServiceImpl enclosureService;
    private EnclosureRepository enclosureRepository;
    private AnimalService animalService;

    @BeforeEach
    public void init() {
        enclosureRepository = mock(EnclosureRepository.class);
        animalService = mock(AnimalService.class);
        enclosureService = new EnclosureServiceImpl(animalService, enclosureRepository);
    }

    @Test
    public void testAddEnclosure() {
        Enclosure enclosure = createTestEnclosure();
        enclosureService.addEnclosure(enclosure);
        verify(enclosureRepository, times(1)).save(enclosure);
    }

    @Test
    public void testUpdateEnclosure() {
        Enclosure enclosure = createTestEnclosure();
        enclosureService.updateEnclosure(enclosure);
        verify(enclosureRepository, times(1)).update(enclosure);
    }

    @Test
    public void testRemoveEnclosure() {
        Enclosure enclosure = createTestEnclosure();
        enclosureService.removeEnclosure(enclosure);
        verify(enclosureRepository, times(1)).deleteById(enclosure.getId());
    }

    @Test
    public void testAssignAnimalToEnclosure_Compatible() {
        Enclosure enclosure = createTestEnclosure();
        Animal animal = createTestAnimal("Lion");

        when(animalService.getAnimalById(animal.getId())).thenReturn(Optional.of(animal));
        enclosureService.assignAnimalToEnclosure(animal, enclosure);

        assertEquals(enclosure.getId(), animal.getEnclosureId());
    }

    @Test
    public void testAssignAnimalToEnclosure_NotCompatible() {
        Enclosure enclosure = createTestEnclosure();
        Animal animal = createTestAnimal("Elephant");

        when(animalService.getAnimalById(animal.getId())).thenReturn(Optional.of(animal));
        enclosureService.assignAnimalToEnclosure(animal, enclosure);

        assertNotEquals(enclosure.getId(), animal.getEnclosureId());
    }

    private Enclosure createTestEnclosure() {
        List<String> authorizedSpecies = Arrays.asList("Lion", "Tiger", "Leopard");
        Species species = new Species(authorizedSpecies);
        return new Enclosure(1, "Savannah", SizeEnum.LARGE, species);
    }

    private Animal createTestAnimal(String species) {
        return new Animal(1, "Kaaris", species, 5);
    }
}
