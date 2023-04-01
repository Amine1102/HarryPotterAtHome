package main.tests;

import main.Potion;
import main.Wand;
import main.Wizard;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WizardTest {

    @Test
    public void testWizardName() {
        Wizard wizard = new Wizard("Harry", 100, 10, new Wand("Holly", 11));
        Assertions.assertEquals("Harry", wizard.getName());
    }

    @Test
    public void testWizardHealth() {
        Wizard wizard = new Wizard("Hermione", 80, 10, new Wand("Vine", 10));
        Assertions.assertEquals(80, wizard.getHealth());
        wizard.setHealth(90);
        Assertions.assertEquals(90, wizard.getHealth());
        wizard.setHealth(-10);
        Assertions.assertEquals(0, wizard.getHealth());
        wizard.setHealth(200);
        Assertions.assertEquals(100, wizard.getHealth());
    }

    @Test
    public void testWizardDamage() {
        Wizard wizard = new Wizard("Ron", 90, 15, new Wand("Oak", 12));
        Assertions.assertEquals(15, wizard.getDamage());
        wizard.setDamage(20);
        Assertions.assertEquals(20, wizard.getDamage());
    }

    @Test
    public void testWizardPotions() {
        Wizard wizard = new Wizard("Neville", 80, 8, new Wand("Cherry", 9));
        Assertions.assertEquals(3, wizard.getPotions().size());

        Potion potion = new Potion();
        wizard.addPotion(potion);
        Assertions.assertEquals(4, wizard.getPotions().size());

        wizard.usePotion();
        Assertions.assertEquals(3, wizard.getPotions().size());
    }
}
