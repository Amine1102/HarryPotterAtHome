package main;

import java.util.ArrayList;

public class Wizard implements Character{

    private String name;
    private int health;
    private int damage;
    private Wand wand;
    private String house;
    private ArrayList<Potion> potions;

    //Constructor

    public Wizard(String name, int health, int damage, Wand wand){
        this.name = name;
        if (health <0) {
            this.health = 0;
        }
        else if(health > 100) {
            this.health = 100;
        }
        else{
            this.health = health;
        }

        this.damage = damage;
        this.wand = wand;
        SortingHat.assignHouse(this);

        this.potions = new ArrayList<Potion>();

        for(int i=0; i<3; i++){
            this.potions.add(new Potion());
        }
    }

    //GETTER SETTER


    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public Wand getWand() {
        return wand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPotion(Potion p){
        this.potions.add(p);
    }

    public void usePotion(){

        if(this.potions.isEmpty()){
            System.out.println("You dont have any potion");
            return;
        }
        (potions.get(potions.size() - 1)).regenHealth(this);

        potions.remove(potions.size() - 1);
    }

    public void attack(Character c){
        c.damage((this.damage));
    }

    public void damage(int damage){
        this.health = this.health - damage;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }
}

