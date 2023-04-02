package main.tests;

import main.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SortingHatTest {

    @Test
    public void testAssignHouse() {
        Wizard wizard = new Wizard("Harry", 100, 50, new Wand(Core.PHOENIX_FEATHER, 12), Pet.OWL);
        String house = SortingHat.assignHouse(wizard);

        assertNotNull(house);
        assertTrue(house.equals("Gryffindor") || house.equals("Slytherin") || house.equals("Ravenclaw") || house.equals("Hufflepuff"));
        assertEquals(house, wizard.getHouse());
    }

}
