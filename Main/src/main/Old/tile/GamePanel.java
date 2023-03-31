/*

package main.Old.tile;

import entity.Player;
import main.KeyHandler;
import main.Old.AssetSetter;
import main.Old.CollisionChecker;
import main.Old.UI;
import main.Old.object.SuperObject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; //16*16 main.Old.tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //48*48 main.Old.tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    int FPS = 60;


    //System
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;


    //Entity & objects
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10]; //10 Slots for objects


    // Game state
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;


    //Set plater's default position
    int playerX = 22;
    int playerY = 22;
    int playerSpeed = 4; //Move by 4 pixels

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){

        aSetter.setObject();
        gameState = playState;

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }



    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >=1){

                update();
                repaint();
                delta--;
                drawCount ++;
            }
            if (timer >= 1000000000){
                System.out.println("FPS : " + drawCount);
                drawCount = 0;
                timer=0;

            }
        }
    }

    //To go right : x increase
    //To go down : y increase
    public void update(){
        if(gameState == playState){
            player.update();
        }
        if (gameState == pauseState){
            //Pause the game with the key we want (p)
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //main.Old.tile
        tileM.draw(g2);

        //obj
        for (int i= 0; i<obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        //player
        player.draw(g2);
        }

        //UI
        ui.draw(g2);

        g2.dispose();
    }

}
*/