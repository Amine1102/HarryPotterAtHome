package main.tests;

import main.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FightTest {

    private Wizard wizard;
    private Enemy enemy;
    private Fight fight;
    private Wand wand;
    private Core core;
    private Pet pet;

    @Before
    public void setUp() {
        wand = new Wand(core, 12);
        wizard = new Wizard("Harry", 100, 25, wand, pet);
        enemy = new Enemy("troll", 50, 10);
        fight = new Fight(wizard, enemy);
    }

    @Test
    public void testAttackLvl1() {
        ObjectLvl1 obj = new ObjectLvl1("pierre",10, 25);
        int initialEnemyHealth = enemy.getHealth();
        fight.attackLvl1(enemy, wizard, obj);
        assertNotEquals(initialEnemyHealth, enemy.getHealth());
    }

    @Test
    public void testRemoveOne() {
        ObjectLvl1 obj = new ObjectLvl1("pierre",10, 25);
        int initialNbObj = obj.getNbObj();
        fight.removeOne(obj);
        assertNotEquals(initialNbObj, obj.getNbObj());
    }

    /* @Test
    public void testStartLevel1() {
        fight.startLevel1();
        assertTrue(fight.startLevel1());
    }

     */
}