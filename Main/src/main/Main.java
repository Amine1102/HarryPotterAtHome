package main;

import java.util.Scanner;

// TODO: 02/04/2023 Unit test
/*
Enemy : OK
Fight : There is an issue with Ravenclaw
Main : OK
ObjectLvl1 : OK
Potion : OK
SortingHat : OK
Wand :
Wizard :
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Wizard
        System.out.println("Enter wizard's name : ");
        String name = scanner.nextLine();

        //Choose ur PET
        System.out.println("Choose ur pet");
        System.out.println("1. OWL");
        System.out.println("2. RAT");
        System.out.println("3. CAT");
        System.out.println("4. TOAD");
        int choicePet = scanner.nextInt();
        Pet pet = null;
        switch (choicePet) {
            case 1:
                pet = Pet.OWL;
                break;
            case 2:
                pet = Pet.RAT;
                break;
            case 3:
                pet = Pet.CAT;
                break;
            case 4:
                pet = Pet.TOAD;
                break;
            default:
                System.out.println("Invalid input, pet will be set to default OWL");
                pet = pet.OWL;
                break;
        }


        // Create a Wand
        System.out.println("Choose wand's core : ");
        System.out.println("1. PHOENIX FEATHER");
        System.out.println("2. DRAGON HEARTHSTRING");
        System.out.println("3. UNICORN TAIL HAIR");
        int choice = scanner.nextInt();
        Core core = null;
        switch (choice) {
            case 1:
                core = Core.PHOENIX_FEATHER;
                break;
            case 2:
                core = Core.DRAGON_HEARTSTRING;
                break;
            case 3:
                core = Core.UNICORN_TAIL_HAIR;
                break;
            default:
                System.out.println(" invalid choice ! ");
        }


        System.out.println("Choose wand's size : ");
        int size = scanner.nextInt();

        //Sorting Hat
        SortingHat sortingHat = new SortingHat();

        int health = 100;
        int damage = 25;

        Wand wand = new Wand(core, size);
        Wizard wizard = new Wizard(name, health, damage, wand, pet);


        // Utiliser les méthodes et propriétés de l'objet Wizard créé
        System.out.println("Wizard Name : " + wizard.getName());
        System.out.println("Wizard Health : " + wizard.getHealth());
        System.out.println("Wizard Damage : " + wizard.getDamage());
        System.out.println("Size Wand : " + wizard.getWand().getSize());
        System.out.println("Core Wand : " + wizard.getWand().getCore());
        System.out.println("Your Pet : " + wizard.getPet());

        // Assigner une maison au sorcier
        String houses = SortingHat.assignHouse(wizard);
        System.out.println(wizard.getName() + "'s house is " + houses);

        Enemy enemy = new Enemy("Troll", 60, 5);

        Fight fight = new Fight(wizard, enemy);
        fight.startLevel1();

    }

}

// Bellow is the main for 2D wich will be used one day..
// But I lost too much time on 2D
// So now I have to focus on logical aspect of the game

/*

import main.Old.main.Old.tile.GamePanel;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {


        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Harry Potter RPG");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);


        gamePanel.setupGame();
        gamePanel.startGameThread();







    }
}
///////////
////////////////
///////////////////
////////////////////////
////////////////////////////////////////////

import java.util.Random;
import java.util.Scanner; //needed for user_input

public class Main {

    public static final Scanner USERINPUT = new Scanner(System.in);
    public static final Random RAND = new Random();
    public static Room[][] currDungeon;
    public static Player currPlayer;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        boolean status = false;
        do {
            IO.Welcome();
            String selection = USERINPUT.nextLine();
            switch (selection) {
                case "1":
                    newGame();
                    status = true;
                    break;
                case "2":
                    System.exit(0);
            }

        } while (status == false);

    }

    public static void newGame() {
        Dungeon dungeon = new Dungeon();
        boolean status = false;
        do {
            IO.newGameIntroduction();
            String selection = USERINPUT.nextLine();
            switch (selection) {
                case "1":
                    status = IO.displayPlayerStats("Gryffindor", "Tough, more resistant to damages ",
                            100, 20, 30, 3, 0.10);
                    currPlayer = Player.newGryffindor();


                    break;
                case "2":
                    status = IO.displayPlayerStats("Hufflepuff", "Potions are more efficients ",
                            80, 10, 50, 2, 0.18);
                    currPlayer = Player.newHufflepuff();


                    break;
                case "3":
                    status = IO.displayPlayerStats("Ravenclaw", "Max accuracy ",
                            80, 10, 50, 2, 0.18);
                    currPlayer = Player.newRavenclaw();


                    break;
                case "4":
                    status = IO.displayPlayerStats("Slyntherin", "Deals more damages ",
                            80, 10, 50, 2, 0.18);
                    currPlayer = Player.newSlytherin();

                    break;
            }
        } while (status == false);

        currDungeon = Dungeon.newRandomDungeon(currPlayer);
        dungeon.dungeonLogic(currPlayer, currDungeon);

    }


}




*/


