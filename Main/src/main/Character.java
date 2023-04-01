package main;

import java.util.ArrayList;

public interface Character {
    

    public abstract void attack(Character c);
    public abstract void damage(int damage);
    public abstract int getDamage();
    public abstract int getHealth();
    public abstract ArrayList<Potion> getPotions();

    String getName();


}
