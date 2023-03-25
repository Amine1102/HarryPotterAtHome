package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest extends SuperObject{

    public Chest(){
        name = "Chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}