package main;

import java.util.ArrayList;

public class Enemy  implements AbstractEnemy{
    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void attack(Character c){
        c.damage((this.damage));
    }

    public void damage(int damage){
        this.health = this.health - damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public ArrayList<Potion> getPotions() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}


