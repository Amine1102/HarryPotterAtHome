package main;
import java.util.Random;
import java.util.Scanner;

public class Fight {

    private Wizard wizard;
    private Enemy enemy;
    private boolean gameOver;

    public Fight(Wizard wizard, Enemy enemy){
        this.wizard = wizard;
        this.enemy = enemy;
        this.gameOver = false;

    }

    public void removeOne(ObjectLvl1 obj){
        obj.setNbObj(obj.getNbObj() -1);
    };
    public void attackLvl1(Character enemy, Wizard player, ObjectLvl1 obj){
        Random rand = new Random();
        int succesChance = rand.nextInt(10); //Random int between 0 .. 9
        if(player.getHouse()== "Ravenclaw"){
            if(obj.getName() == "rock"){
                player.setDamage(obj.getDmg());
                System.out.println("You dealt " + player.getDamage() + " damage to " + enemy.getName() + "!");
            }
            else if(obj.getName() == "paper"){
                player.setDamage(obj.getDmg());
                System.out.println("You dealt " + player.getDamage() + " damage to " + enemy.getName() + "!");
            }
            System.out.println("Ravenclaw never miss ! "); //ravenclaw are more accurate
            enemy.damage((player.getDamage()));
        }
        else if(succesChance <8){ //If not ravenclaw, 80% of succes
            if(obj.getName() == "rock"){
                player.setDamage(obj.getDmg());
                System.out.println("You dealt " + player.getDamage() + " damage to " + enemy.getName() + "!");
            }
            else if(obj.getName() == "paper"){
                player.setDamage(obj.getDmg());
                System.out.println("You dealt " + player.getDamage() + " damage to " + enemy.getName() + "!");
            }
            enemy.damage((player.getDamage()));
            //System.out.println("You dealt " + player.getDamage() + " damage to " + enemy.getName() + "!");
        }
        else{
            System.out.println("You missed ! ");
        }
    }

    public static ObjectLvl1 paper = new ObjectLvl1("paper",20, 5);
    public static ObjectLvl1 rock = new ObjectLvl1("rock",5, 25);
    public boolean startLevel1() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" ...");
        System.out.println("You find yourself in the dungeon's bathroom ");
        System.out.println("Someone ... or something is rushing you ! ");
        System.out.println("A battle has  started between " + wizard.getName() + " and " + enemy.getName() + "!! \n");

        while (!gameOver) {
            System.out.println("What do you want to do ?  ");
            System.out.println("1. Use Wingardium Leviosa ");
            System.out.println("2. Use potion");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Which object do you want to use with Wingardium Leviosa? ");
                    System.out.println("choice 1 : Paper " + paper.toString());
                    System.out.println("choice 2 : Rock  " + rock.toString());
                    int choiceObjToGet = scanner.nextInt();
                    if (choiceObjToGet == 1) {
                        this.attackLvl1(enemy, wizard, paper);
                        this.removeOne(paper);
                    } else if (choiceObjToGet == 2) {
                        this.attackLvl1(enemy, wizard, rock);
                        this.removeOne(rock);
                    }

                    break;
                case 2:
                    wizard.usePotion();
                    if (wizard.getPotions().size() == 0) {
                        System.out.println("No potions !!");
                    } else {
                        System.out.println(" You Heal yourself");
                    }
                    break;
                default:
                    System.out.println(" invalid choice ! ");
                    continue;
            }

            boolean victory;

            if (enemy.getHealth() <= 0) {
                System.out.println("Congratulations, you have defeated " + enemy.getName() + "!");
                System.out.println("You can now level up");
                wizard.levelUp();
                gameOver = true;
                return true;
                //break;
            }

            enemy.attack(wizard);
            System.out.println(enemy.getName() + " Hit you ! ");

            if (wizard.getHealth() <= 0) {
                System.out.println("You have been killed by " + enemy.getName() + "!!");
                gameOver = true;
                return false;

            }

            System.out.println(wizard.getName() + " has " + wizard.getHealth() + " health left.");
            System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left.");


        }

        scanner.close();
        return false;
    }
}