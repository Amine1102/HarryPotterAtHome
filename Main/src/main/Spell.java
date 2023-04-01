package main;

import java.util.Random;

public class Spell implements AbstractSpell{

    private String nameSpell;
    private int damageSpell;
    private int successRate;

    public Spell(int successRate, String name, int damage){
        this.successRate = successRate;
        this.nameSpell = name;
        this.damageSpell = damage;
    }

    public void attack(Character ennemi){
        Random random = new Random();
        int chance = random.nextInt(100);

        if (chance <successRate){
            ennemi.damage(this.damageSpell);
        }else {
            System.out.println("Spell failled");
        }
    }
}
