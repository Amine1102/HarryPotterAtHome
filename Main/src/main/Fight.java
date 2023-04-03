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
            System.out.println("Ravenclaw never miss ! "); //ravenclaw are more accurate
            player.setDamage(obj.getDmg());
            System.out.println("You dealt " + player.getDamage() + " damage to " + enemy.getName() + "!");
        }
        else if(succesChance <8){ //If not ravenclaw, 80% of succes
            if(obj.getName() == "pierre"){
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

    public static ObjectLvl1 pierre = new ObjectLvl1("pierre",10, 25);
    public static ObjectLvl1 rock = new ObjectLvl1("cailloux",50, 12);
    public boolean startLevel1() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("You find yourself in the dungeon's bathroom ");
        System.out.println("A battle has  started between " + wizard.getName() + " and " + enemy.getName() + "!! \n");

        while (!gameOver) {
            System.out.println("Choose your action ");
            System.out.println("1. Use Wingardium Leviosa ");
            System.out.println("2. Use potion");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose one obect for your spell : ");
                    System.out.println("choice 1 is : " + " " + pierre.toString());
                    System.out.println("choice 2 is : " + " " + rock.toString());
                    int choiceObjToGet = scanner.nextInt();
                    System.out.println("Choose one obect for your spell : ");
                    if (choiceObjToGet == 1) {
                        this.attackLvl1(enemy, wizard, pierre);
                        this.removeOne(pierre);
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