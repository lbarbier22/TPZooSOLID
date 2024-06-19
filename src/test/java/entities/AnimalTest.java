package entities;

import org.example.entities.Animal;
import org.example.entities.Enclosure;
import org.example.entities.Species;
import org.example.utils.SizeEnum;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    Enclosure enclosureSmall;
    Animal michelLion;

    @BeforeEach
    public void init(){
        michelLion = new Animal(1,"Michel", "Lion", 5);

        Species speciesLargeCats = new Species(List.of("Lion", "Tiger", "Leopard"));
        enclosureSmall = new Enclosure(2, "SmallLionEnclosure", SizeEnum.SMALL, speciesLargeCats, List.of(1));

    }

    @Test
    public void testAnimalCreationSuccess() {
        assertEquals("Michel", michelLion.getName());
        assertEquals("Lion", michelLion.getSpecies());
        assertEquals(5, michelLion.getAge());
    }

    @Test
    public void testAnimalSetters() {
        michelLion.setName("Mufasa");
        michelLion.setAge(6);

        assertEquals("Mufasa", michelLion.getName());
        assertEquals(6, michelLion.getAge());
    }
}
