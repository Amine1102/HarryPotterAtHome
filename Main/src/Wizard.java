public class Wizard extends Character{

    private String pet;
    private String house;
    private String wand;

    public Wizard(String pet, String house, String wand) {
        this.pet = pet;
        this.house = house;
        this.wand = wand;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getWand() {
        return wand;
    }

    public void setWand(String wand) {
        this.wand = wand;
    }
}
