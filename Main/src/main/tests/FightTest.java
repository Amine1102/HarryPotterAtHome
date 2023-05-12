package main.tests;

import main.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FightTest {

    //Fail sometimes when the player miss
    // IF "you missed", restart test

    @Test
    public void testAttackLvl1() {

        Wizard player = new Wizard("Harry", 100, 20,new Wand(Core.PHOENIX_FEATHER, 12), Pet.OWL);
        Enemy enemy = new Enemy("Voldemort", 100, 30);
        Fight fight = new Fight(player, enemy);
        ObjectLvl1 rock = new ObjectLvl1("rock", 50, 45);

        fight.attackLvl1(enemy, player, rock);

        assertTrue(enemy.getHealth() < 100);
    }
}
