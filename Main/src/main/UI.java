package main;

import java.awt.*;

public class UI {
    private final Font arial_40;
    GamePanel gp;
    public boolean gameFinished = false;


    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }

    public void draw(Graphics2D g2){

        if(gameFinished == true){
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            String text;
            int textLength;
            int x;
            int y;

            text = "You found it";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);  //align to the center
            g2.drawString(text, x, y);

            gp.gameThread = null;
        }
        else{
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawString("Key = " + gp.player.hasKey, 20, 50);

        }
    }
}
