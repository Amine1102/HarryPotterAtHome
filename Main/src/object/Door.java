package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Door extends SuperObject {

    GamePanel gp;

    public Door(GamePanel gp){

        this.gp = gp;
        name = "Door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/door.png"));
            tool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }


}
