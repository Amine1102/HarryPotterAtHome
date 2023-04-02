package main;

public class ObjectLvl1 {

    private String name;
    private int nbObj ;
    private int dmg;

    public ObjectLvl1(String name, int nbObj, int dmg ){
        this.setName(name);
        this.setNbObj(nbObj);
        this.setDmg(dmg);
    }

    @Override
    public String toString() {
        return "name :"+this.name+ ", number of this : "+nbObj+ ", and damage that should make : "+ this.dmg;
    }

    public String getName(String pierre) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbObj() {
        return nbObj;
    }

    public void setNbObj(int nbObj) {
        this.nbObj = nbObj;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}