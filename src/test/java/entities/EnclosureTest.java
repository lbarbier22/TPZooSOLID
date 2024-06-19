package entities;

import org.example.entities.Enclosure;
import org.example.entities.Species;
import org.example.utils.SizeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnclosureTest {

    private Enclosure enclosure;
    private Species species;

    @BeforeEach
    public void init() {
        List<String> authorizedSpecies = Arrays.asList("Lion", "Tiger", "Leopard");
        species = new Species(authorizedSpecies);
        enclosure = new Enclosure(1, "Savannah", SizeEnum.LARGE, species);
    }

    @Test
    public void testEnclosureCreation() {
        assertNotNull(enclosure);
        assertEquals(1, enclosure.getId());
        assertEquals("Savannah", enclosure.getName());
        assertEquals(SizeEnum.LARGE, enclosure.getSize());
        assertEquals(species, enclosure.getSpeciesAuthorized());
    }

    @Test
    public void testSetName() {
        enclosure.setName("Jungle");
        assertEquals("Jungle", enclosure.getName());
    }

    @Test
    public void testSetSize() {
        enclosure.setSize(SizeEnum.MEDIUM);
        assertEquals(SizeEnum.MEDIUM, enclosure.getSize());
    }

    @Test
    public void testSetSpeciesAuthorized() {
        List<String> newAuthorizedSpecies = Arrays.asList("Elephant", "Giraffe");
        Species newSpecies = new Species(newAuthorizedSpecies);
        enclosure.setSpeciesAuthorized(newSpecies);
        assertEquals(newSpecies, enclosure.getSpeciesAuthorized());
    }
}
