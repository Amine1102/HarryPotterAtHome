package main;

import java.util.Random;



public class SortingHat {
        private static String[] houses = {"Gryffindor", "Slytherin", "Ravenclaw", "Hufflepuff"};

        public static String assignHouse(Wizard wizard){
            Random random = new Random();
            int index = random.nextInt(houses.length);
            String house = houses[index];

            wizard.setHouse(house);
            return house;
        }
    }

