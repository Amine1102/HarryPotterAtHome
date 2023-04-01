package main;

public class Potion {
    public Potion(){

    }

    public void regenHealth(Wizard wizard){
        int currentHealth = wizard.getHealth();
        int health = 10;
        if (wizard.getHouse() == "Huflepuff"){
            health +=5;
        }

        int newHealth = currentHealth + health;
        wizard.setHealth(newHealth);
        System.out.println(wizard.getName() + " live's is up to " + Integer.toString(health));
    }

}


