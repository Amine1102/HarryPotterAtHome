package main;

import entity.Wizard;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; //16*16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //48*48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Wizard Wizard = new Wizard(this, keyH);

    //Set plater's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4; //Move by 4 pixels

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
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
        Wizard.update();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Wizard.draw(g2);

        g2.dispose();
    }

}
