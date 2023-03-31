/*

package main.Old.object;

import main.Old.tile.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends SuperObject{

    GamePanel gp;

    public Key(GamePanel gp){
        this.gp = gp;
        name = "Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
            tool.scaleImage(image, gp.tileSize, gp.tileSize);

        }catch (IOException e){
            e.printStackTrace();
        }
        solidArea.x = 5;
    }
}


*/