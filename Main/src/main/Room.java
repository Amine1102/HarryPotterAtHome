package main;

public final class Room {

    private final String description;
    private final Monster monster;
    private final int numOfMonsters;
    private final boolean isBossRoom;
    //private final boolean lighting;

    private Room(String description, Monster monster, boolean isBossRoom,
                 int numOfMonsters) {
        this.description = description;
        this.monster = monster;
        //this.lighting = lighting;
        this.isBossRoom = isBossRoom;
        this.numOfMonsters = numOfMonsters;
    }

    public static Room newRoomInstance() {
        String description = null;
        int numOfMonsters = 0;
        //boolean lighting = true;
        boolean isBossRoom = false;
        int random = Main.RAND.nextInt(3) + 1; //Change random value parameter to add more room types
        switch (random) {
            case 1:
                description = "The Philopher's Stone";
                numOfMonsters = 1;
                //lighting = false;
                break;
            case 2:
                description = "The chamber of Secret";
                numOfMonsters = 1;
                //lighting = true;
                break;
            case 3:
                description = "The prisonner of Azkaban";
                numOfMonsters = 1;
                //lighting = true;
                break;
            case 4:
                description = "The Goblet of fire";
                numOfMonsters = 1;
                isBossRoom = true;
                break;

            case 5:
                description = "The order of the Phoenix";
                numOfMonsters = 1;
                break;

            case 6:
                description = "The half blood prince";
                numOfMonsters = 1;
                break;
            case 7:
                description = "The deathly Hallows";
                numOfMonsters = 1;
                break;

        }
        return new Room(description, Monster.newRandomMonster(), false,
                numOfMonsters);

    }

    @Override
    public String toString() {
        return description;
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getNumOfMonsters() {
        return numOfMonsters;
    }

    public boolean isIsBossRoom() {
        return isBossRoom;
    }

}
