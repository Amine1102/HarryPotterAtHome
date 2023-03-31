/*

package main.Old.object;

import main.Old.tile.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest extends SuperObject{

    GamePanel gp;

    public Chest(GamePanel gp){

        this.gp = gp;
        name = "Chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
            tool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


*/
