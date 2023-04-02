
package main.tests;

import main.*;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class WizardTest {

    @Test
    public void testConstructor() {
        Wand wand = new Wand(Core.DRAGON_HEARTSTRING, 10);
        Pet pet = Pet.TOAD;
        Wizard wizard = new Wizard("Harry", 150, 20, wand, pet);

        assertEquals("Harry", wizard.getName());
        assertEquals(150, wizard.getHealth());
        assertEquals(20, wizard.getDamage());
        assertEquals(wand, wizard.getWand());
        assertEquals(3, wizard.getPotions().size());
        assertEquals(pet, wizard.getPet());
    }

    @Test
    public void testSettersAndGetters() {
        Wand wand = new Wand(Core.DRAGON_HEARTSTRING, 10);
        Pet pet = Pet.TOAD;
        Wizard wizard = new Wizard("Harry", 150, 20, wand, pet);

        wizard.setName("Ron");
        assertEquals("Ron", wizard.getName());

        wizard.setHealth(200);
        assertEquals(200, wizard.getHealth());

        wizard.setDamage(30);
        assertEquals(30, wizard.getDamage());

        ArrayList<Potion> newPotions = new ArrayList<Potion>();
        newPotions.add(new Potion());
        wizard.setPotions(newPotions);
        assertEquals(newPotions, wizard.getPotions());
    }

    @Test
    public void testAttack() {
        Wand wand = new Wand(Core.DRAGON_HEARTSTRING, 10);
        Pet pet = Pet.TOAD;
        Wizard wizard = new Wizard("Harry", 150, 20, wand, pet);

        Wizard enemy = new Wizard("Voldemort", 200, 30, wand, null);
        wizard.attack(enemy);
        assertTrue(enemy.getHealth() < 200);
        // It's fail sometimes because of the acuracy, I didn't manage to make a usefull test
    }

    @Test
    public void testUsePotion() {
        Wand wand = new Wand(Core.DRAGON_HEARTSTRING, 10);
        Pet pet = Pet.TOAD;
        Wizard wizard = new Wizard("Harry", 150, 20, wand, pet);

        wizard.usePotion();
        assertEquals(2, wizard.getPotions().size());
    }
}
