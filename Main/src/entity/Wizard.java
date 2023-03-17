package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
        direction = "up";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/main/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/main/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/main/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/main/boy_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/main/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/main/boy_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/main/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/main/boy_left_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }
        else if(keyH.downPressed==true){
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed==true) {
            direction = "left";
            x -= speed;
        }
        else if (keyH.rightPressed==true) {
            direction = "right";
            x += speed;
        }

    }


    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (direction){
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "right":
                image = right1;
                break;
            case "left":
                image = left1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
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