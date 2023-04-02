package main.tests;

import static org.junit.Assert.*;

import main.Core;
import main.Enemy;
import main.Wand;
import main.Wizard;
import org.junit.Before;
import org.junit.Test;

public class EnemyTest {

    private Enemy enemy;

    @Before
    public void setUp() {
        enemy = new Enemy("Goblin", 50, 10);
    }

    @Test
    public void testAttack() {
        Core core = Core.DRAGON_HEARTSTRING;
        Wizard wizard = new Wizard("Harry", 100, 10, new Wand(core, 10), null);
        int initialHealth = wizard.getHealth();
        enemy.attack(wizard);
        int newHealth = wizard.getHealth();
        assertEquals(initialHealth - enemy.getDamage(), newHealth);
    }

    @Test
    public void testDamage() {
        int initialHealth = enemy.getHealth();
        enemy.damage(10);
        int newHealth = enemy.getHealth();
        assertEquals(initialHealth - 10, newHealth);
    }

    @Test
    public void testGetDamage() {
        assertEquals(10, enemy.getDamage());
    }

    @Test
    public void testGetHealth() {
        assertEquals(50, enemy.getHealth());
    }

    @Test
    public void testGetName() {
        assertEquals("Goblin", enemy.getName());
    }
}
