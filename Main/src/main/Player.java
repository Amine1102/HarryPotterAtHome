package main;


import java.util.ArrayList;
import java.util.List;


public class Player {

    private final String name;
    private final String description;
    private final int maxHitPoints;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final int defense;
    private double critChance;
    private int currX;
    private int currY;
    private Room currRoom;
    private List<Item> inventory;

    public Player(String name, String description, int maxHitPoints,
                  int minDamage, int maxDamage, int defense, double critChance) {
        this.name = name;
        this.description = description;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = maxHitPoints;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defense = defense;
        this.critChance = critChance;
        this.currX = 14;
        this.currY = 14;
        inventory = new ArrayList<>();

    }

    public int attack() {
        return Main.RAND.nextInt(maxDamage - minDamage + 1);
    }

    public int defend(Monster monster) {
        int incomingAttack = monster.attack();
        int random = Main.RAND.nextInt(99) + 1;
        if (random <= monster.getCritChance()) {
            incomingAttack = incomingAttack * 2;
            IO.monsterCrit(); //TODO - move to different spot
        }
        IO.playerHitPointsMessage(incomingAttack, monster);
        hitPoints = (hitPoints * defense > incomingAttack)
                ? hitPoints - incomingAttack : 0;
        return hitPoints;
    }

    public void heal(Item potion){
        this.hitPoints =+ 20;
        inventory.remove(potion);
       // IO.heal(this.hitPoints);
    }

    public static Player newGryffindor() {
        return new Player("Gryffindor", "Tough, more resistant to damages"
                , 1000, 20, 30, 5, 10);
    }

    public static Player newHufflepuff() {
        return new Player("hufflepuff", "Potions are more efficients"
                , 1000, 10, 50, 2,
                18);
    }
    public static Player newRavenclaw() {
        return new Player("Ravenclaw", "Max accuracy"
                , 1000, 10, 50, 2,
                18);
    }
    public static Player newSlytherin() {
        return new Player("Slytherin", "Deals more damages",
                8000, 200, 80, 2,
                20);
    }

    public String getDescription() {
        return description;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public String getName() {
        return name;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getDefense() {
        return defense;
    }

    public double getCritChance() {
        return critChance;
    }

    public int getCurrX() {
        return currX;
    }

    public int getCurrY() {
        return currY;
    }

    public List<Item> getInventory() {
        return inventory;
    }


    public Room getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(Room room) {
        currRoom = room;
    }

    public void setCurrX(int currX) {
        this.currX = currX;
    }

    public void setCurrY(int currY) {
        this.currY = currY;
    }
}