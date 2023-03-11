package entity;

import com.sun.media.jfxmedia.events.PlayerEvent;
import entity.Character;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Wizard extends Character {

    GamePanel gp;
    KeyHandler keyH;

    public Wizard(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update(){
        if(keyH.upPressed == true){
            y -= speed;
        }
        else if(keyH.downPressed==true){
            y += speed;
        }
        else if (keyH.leftPressed==true) {
            x -= speed;
        }
        else if (keyH.rightPressed==true) {
            x += speed;
        }

    }


    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }




    /*
    private String pet;
    private String house;
    private String wand;


    public Wizard(String pet, String house, String wand) {
        super();
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

    @Override
    public int health() {
        return 100;
    }
}


     */

}