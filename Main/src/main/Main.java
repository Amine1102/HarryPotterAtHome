package main;

import java.util.Scanner;

// TODO Rajouter un 2eme niveau avec un autre sort
/*
Enemy : OK
Fight : Ok
Main : OK
ObjectLvl1 : OK
Potion : OK
SortingHat : OK
Wizard :
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Wizard
        System.out.println("Enter wizard's name : ");
        String name = scanner.nextLine();

        //Choose ur PET
        System.out.println("Choose your pet");
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