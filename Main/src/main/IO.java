package main;

import java.io.*;

public final class IO {

    public static void playerCrit() {
        System.out.println("Nice! You landed a critical hit! (x2 Damage)");
    }

    public static void monsterCrit() {
        System.out.println("Ouch! The monster landed a critical hit! "
                + "(x2 Damage)");
    }

    public static void Welcome() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome traveler.......");
        System.out.println("To the mines of Moria! ");
        System.out.println("-----------------------");
        System.out.println("       MAIN MENU       ");
        System.out.println("_______________________");
        System.out.println();
        System.out.println(" 1.      New Game        ");
        System.out.println();
        System.out.println(" 2.     Exit Game        ");
        System.out.println();
        System.out.print(" Make a Selection: ");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void newGameIntroduction() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------");
        System.out.println("The SORTING HAT will now assign you a house");
        System.out.println("------------------");
        System.out.println();
        System.out.println("1. Gryffondor");
        System.out.println("----------");
        System.out.println("Tough, more resistant to damages");
        System.out.println();
        System.out.println("2. hufflepuff");
        System.out.println("----------");
        System.out.println("Potions are more efficients");
        System.out.println();
        System.out.println("3. Ravenclaw");
        System.out.println("----------");
        System.out.println("Max accuracy");
        System.out.println();
        System.out.println("4. Slyntherin");
        System.out.println("----------");
        System.out.println("Deals more damages");
        System.out.println();
        System.out.println("________________________");
        System.out.print("Choose Either House: ");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static boolean displayPlayerStats(String name, String description,
                                             int maxHitPoints, int minDamage, int maxDamage, int defense,
                                             double critChance) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(name);
        System.out.println("-------");
        System.out.println(description);
        System.out.println();
        System.out.println("MAX HP: " + maxHitPoints);
        System.out.println();
        System.out.println(
                "ATTACK: " + minDamage + "-" + maxDamage);
        System.out.println();
        System.out.println("DEFENSE(Scale:1-5): " + defense);
        System.out.println();
        System.out.println("CRIT CHANCE: " + critChance + "%");
        System.out.println();
        System.out.println("ARE YOU SURE YOU WANT TO PLAY AS A "
                + name.toUpperCase() + "? "
                + "(y/n)");
        System.out.println();
        System.out.println();
        System.out.println();
        if (Main.USERINPUT.nextLine().equals("y")) {
            return true;
        } else {
            return false;
        }
    }


    public static void movePlayer(Player player) {

        if (Dungeon.isNorthDirection() == true) {
            System.out.println("North (n)\n");
        }
        if (Dungeon.isSouthDirection() == true) {
            System.out.println("South (s)\n");
        }
        if (Dungeon.isEastDirection() == true) {
            System.out.println("East (e)\n");
        }
        if (Dungeon.isWestDirection() == true) {
            System.out.println("West (w)\n");
        }

        System.out.print("Where would you like to travel?: ");
        String selection = Main.USERINPUT.nextLine();
        if (selection.equals("n") && Dungeon.isNorthDirection()) {
            player.setCurrY(player.getCurrY() + 1);
        } else if (selection.equals("s") && Dungeon.isSouthDirection()) {
            player.setCurrY(player.getCurrY() - 1);
        } else if (selection.equals("e") && Dungeon.isEastDirection()) {
            player.setCurrX(player.getCurrX() + 1);
        } else if (selection.equals("w") && Dungeon.isWestDirection()) {
            player.setCurrX(player.getCurrX() - 1);
        }

    }

    public static void battleIntro(Player player, Room room) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("You arrive at Room [" + player.getCurrX() + "]["
                + player.getCurrY() + "]");
        System.out.println("You enter the room and look around and see...");
        System.out.println(room.getDescription() + "\n\n");
        System.out.println("Number of monsters: " + room.getNumOfMonsters());
        System.out.println("Your fight with " + room.getMonster().getName()
                + " begins.\n");
    }

    public static void battle(Player player, Monster monster) {
        while (player.isAlive() && monster.isAlive()) {
            System.out.println("\nMonster HP: " + monster.getHitPoints()
                    + "    " + "Player HP: " + player.getHitPoints());
            System.out.println("----------------------------------");
            System.out.print("\nAttack (a)   Heal (h)");
            String action = Main.USERINPUT.nextLine();
            if (action.equals("a")) {
                monster.defend(player);
                if (monster.isAlive()) {
                    player.defend(monster);
                }
            }
        }
        if (!player.isAlive()) {
            System.out.println("Your lifeless body hits the floor.  GAME OVER");
        } else if (!monster.isAlive()) {
            System.out.println("The monster has been defeated!");
            System.out.println("--------------------------------\n");
        }

    }

    public static void playerHitPointsMessage(int damage, Monster monster) {
        System.out.println("The " + monster.getName() + " hit you for "
                + damage + " damage.");
    }

    public static void monsterHitPointsMessage(int damage, Monster monster) {
        System.out.println("You hit the " + monster.getName()
                + " for " + damage + " damage.");
    }

}