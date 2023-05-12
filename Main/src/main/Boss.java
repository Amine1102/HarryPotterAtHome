package main;
import java.util.ArrayList;

public class Boss implements AbstractEnemy{
    private String name;
    private int health;
    private int damage;

    public Boss(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    @Override
    public void attack(Character c){
        c.damage((this.damage));
    }
    @Override
    public void damage(int damage){
        this.health = this.health - damage;
    }
    @Override
    public int getDamage() {
        return 0;
    }
    @Override
    public int getHealth() {
        return 0;
    }
    @Override
    public ArrayList<Potion> getPotions() {
        return null;
    }
    @Override
    public String getName() {
        return null;
    }
}
