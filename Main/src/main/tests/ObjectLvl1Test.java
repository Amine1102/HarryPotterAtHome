package main.tests;

import static org.junit.Assert.*;

import main.ObjectLvl1;
import org.junit.Test;

public class ObjectLvl1Test {

    @Test
    public void testObjectLvl1() {
        ObjectLvl1 obj = new ObjectLvl1("Rock", 3, 10);
        assertEquals("Potion", obj.getName());
        assertEquals(3, obj.getNbObj());
        assertEquals(10, obj.getDmg());
    }

    @Test
    public void testSetName() {
        ObjectLvl1 obj = new ObjectLvl1("Chair", 1, 20);
        obj.setName("Greatsword");
        assertEquals("Greatsword", obj.getName());
    }

    @Test
    public void testSetNbObj() {
        ObjectLvl1 obj = new ObjectLvl1("grass", 1, 0);
        obj.setNbObj(2);
        assertEquals(2, obj.getNbObj());
    }

    @Test
    public void testSetDmg() {
        ObjectLvl1 obj = new ObjectLvl1("Bow", 1, 15);
        obj.setDmg(20);
        assertEquals(20, obj.getDmg());
    }

    @Test
    public void testToString() {
        ObjectLvl1 obj = new ObjectLvl1("Ring", 2, 5);
        assertEquals("You have 2 Ring, and this make 5", obj.toString());
    }

}

