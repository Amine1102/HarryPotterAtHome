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

    public void start(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("A battle has  started between " + wizard.getName() + "and " +  enemy.getName() + "!! \n");

        while (!gameOver){
            System.out.println("Choose your action ");
            System.out.println("1. Attack ");
            System.out.println("2. Use potion");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    wizard.attack(enemy);
                    break;
                case 2:
                    wizard.usePotion();
                    break;
                default:
                    System.out.println("invalid choice ! ");
                    continue;
            }

            if (enemy.getHealth() <=0){
                System.out.println("Congratulations, you have defeated " + enemy.getName() + "!");
                gameOver = true;
                break;
            }

            enemy.attack(wizard);

            if(wizard.getHealth()<=0){
                System.out.println("You have been killed by " + enemy.getName() + "!!");
                gameOver = true;
            }

            System.out.println(wizard.getName() + "has " + wizard.getHealth() + "health left.");
            System.out.println(enemy.getName() + "has " + enemy.getHealth() + "health left.");

        }

        scanner.close();
    }
}
