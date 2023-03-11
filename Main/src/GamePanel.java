import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; //16*16 tile
    final int scale = 3;
    final int tileSize = originalTileSize * scale; //48*48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;


     int FPS = 60;


    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Set plater's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4; //Move by 4 pixels

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;  //0.01666 seconds
        double delta=0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta --;
            }
        }
    }

    //To go right : x increase
    //To go down : y increase
    public void update(){
        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if(keyH.downPressed==true){
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed==true) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed==true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }

}