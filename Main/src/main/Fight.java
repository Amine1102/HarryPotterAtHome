package main;
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

    public void startLevel1(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("You find yourself in the dungeon's bathroom ");
        System.out.println("A battle has  started between " + wizard.getName() + "and " +  enemy.getName() + "!! \n");

        while (!gameOver){
            System.out.println("Choose your action ");
            System.out.println("1. Use Wingardium Leviosa ");
            System.out.println("2. Use potion");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    wizard.attack(enemy);
                    System.out.println("You hit " + enemy.getName() + " right on his FACE ! ");
                    break;
                case 2:
                    wizard.usePotion();
                    System.out.println(" You Heal yourself");
                    break;
                default:
                    System.out.println(" invalid choice ! ");
                    continue;
            }

            if (enemy.getHealth() <=0){
                System.out.println("Congratulations, you have defeated " + enemy.getName() + "!");
                System.out.println("You can now level up");
                wizard.levelUp();
                gameOver = true;
                break;
            }

            enemy.attack(wizard);
            System.out.println("The ");

            if(wizard.getHealth()<=0){
                System.out.println("You have been killed by " + enemy.getName() + "!!");
                gameOver = true;
            }

            System.out.println(wizard.getName() + " has " + wizard.getHealth() + " health left.");
            System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health left.");

        }

        scanner.close();
    }
}
