package service.impl;

import org.example.entities.Animal;
import org.example.repository.AnimalRepository;
import org.example.service.AnimalService;
import org.example.service.impl.AnimalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AnimalServiceImplTest {

    private AnimalService animalService;
    private AnimalRepository animalRepositoryMocked;
    Animal lorieKoala;

    @BeforeEach
    public void init() {
        lorieKoala = new Animal(1, "Lorie", "Koala", 9);

        animalRepositoryMocked = Mockito.mock(AnimalRepository.class);
        animalService = new AnimalServiceImpl(animalRepositoryMocked);

        when(animalRepositoryMocked.findById(1)).thenReturn(Optional.of(lorieKoala));
    }

    @Test
    public void testAddAnimal() {
        animalService.addAnimal(lorieKoala);

        Animal animalRetrieved = animalService.getAnimalById(1).orElse(null);
        assertNotNull(animalRetrieved);
        assertEquals("Lorie", animalRetrieved.getName());
    }

    @Test
    public void testUpdateAnimal() {
        animalService.addAnimal(lorieKoala);

        lorieKoala.setName("Flipper");
        animalService.updateAnimal(lorieKoala);

        Animal retrievedAnimal = animalService.getAnimalById(1).orElse(null);
        assertNotNull(retrievedAnimal);
        assertEquals("Flipper", retrievedAnimal.getName());
    }
}

