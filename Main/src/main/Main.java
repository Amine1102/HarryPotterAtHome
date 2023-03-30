package main;

// Bellow is the main for 2D wich will be used one day..
// But I lost too much time on 2D
// So now I have to focus on logical aspect of the game

/*

import main.GamePanel;

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

*/

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
                    loadGame();
                    status = true;
                    break;
                case "3":
                    settings();
                    status = true;
                    break;
                case "4":
                    IO.credits();
                    status = true;
                    break;
                case "5":
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
                    status = IO.displayPlayerStats("Warrior", "A tough, "
                                    + "well-rounded fighter with a balanced skillset.",
                            100, 20, 30, 3, 0.10);
                    currPlayer = Player.newWarrior();

                    break;
                case "2":
                    status = IO.displayPlayerStats("Dueler", "A quick, nimble "
                            + "duelist with an aptitude for landing critical "
                            + "attacks.", 80, 10, 50, 2, 0.18);
                    currPlayer = Player.newDuelist();

                    break;
            }
        } while (status == false);

        currDungeon = Dungeon.newRandomDungeon(currPlayer);
        dungeon.dungeonLogic(currPlayer, currDungeon);

    }

    public static void loadGame() {

    }

    public static void settings() {

    }

}


