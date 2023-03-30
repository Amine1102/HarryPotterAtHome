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


