package main.tests;

import main.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testSortingHat() {

        Pet pet = Pet.TOAD;
        Core core = Core.DRAGON_HEARTSTRING;
        SortingHat sortingHat = new SortingHat();

        Wizard wizard1 = new Wizard("Harry", 100, 50, new Wand(Core.PHOENIX_FEATHER, 12), Pet.OWL);
        String house1 = sortingHat.assignHouse(wizard1);
        assertNotNull(house1);

        Wizard wizard2 = new Wizard("Hermione", 100, 50, new Wand(Core.DRAGON_HEARTSTRING, 14), Pet.CAT);
        String house2 = sortingHat.assignHouse(wizard2);
        assertNotNull(house2);

        Wizard wizard3 = new Wizard("Ron", 100, 50, new Wand(Core.UNICORN_TAIL_HAIR, 10), Pet.RAT);
        String house3 = sortingHat.assignHouse(wizard3);
        assertNotNull(house3);
    }

}
