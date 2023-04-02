package main.tests;

import main.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

    public class PotionTest {

        @Test
        public void testRegenHealth() {
            Pet pet = Pet.TOAD;
            Core core = Core.DRAGON_HEARTSTRING;


            Wizard wizard = new Wizard("Harry", 50, 50, new Wand(core, 12), pet);
            Potion potion = new Potion();
            potion.regenHealth(wizard);
            assertEquals(60, wizard.getHealth());

            wizard = new Wizard("Cedric", 45, 30, new Wand(core, 42), pet);

            potion.regenHealth(wizard);
            assertEquals(55, wizard.getHealth());
        }
    }


