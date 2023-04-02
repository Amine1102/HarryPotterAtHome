package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
        else if(health > 200) {
            this.health = 200;
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


    public void attack(Character c){
        Random rand = new Random();
        int succesChance = rand.nextInt(10); //Random int between 0 .. 9
        if(getHouse()== "Ravenclaw"){
            succesChance =10;
            System.out.println("Ravenclaw never miss ! "); //ravenclaw are more accurate
        }
        if(succesChance <6){ //If not ravenclaw, 60% of succes
            c.damage((this.damage));
            System.out.println("You dealt " + this.damage + " damage to " + c.getName() + "!");
        }
        else{
            System.out.println("You missed ! ");
        }
    }

    public void usePotion(){


        if(this.potions.isEmpty()){
            System.out.println("You dont have any potion");
            return;
        }
        (potions.get(potions.size() - 1)).regenHealth(this);

        potions.remove(potions.size() - 1);
        System.out.println("You have : " + potions.size() +" potions");

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




    public void damage(int damage){
        this.health = this.health - damage;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public void levelUp(){ //When u win a fight
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have " + this.getHealth() + " health");
        System.out.println("You deal " + this.getDamage() + " damage");
        System.out.println("You can now level up ! ");
        System.out.println("Choose your upgrade : ");
        System.out.println("1. Increase Health ");
        System.out.println("2. Increase Damage");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                this.health +=20;
                System.out.println("Your health has been increased by 20!");
                System.out.println("Your new health is now " + getHealth()  + " !");
                break;
            case 2:
                this.damage +=10;
                System.out.println("Your damage has been increased by 10!");
                System.out.println("You will deal " + getDamage()  + " damage !");

                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}

