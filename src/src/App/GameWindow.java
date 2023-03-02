package src.App;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameWindow extends JPanel  implements Runnable{
    /*
        Game Tile Size shows the tile that each of the images on screen should be in pixels, this is not the amount that are displayed in each tile but rather the orignal one
        Scalable value shows the value that is used to upscale the original images on the screen
        Game Column and Row amounts show the amount of rows and columns that can be displayed on screen at one time
     */
    static int GameTileSize = 16;
    static int ScalableValue = 3;
    static int gameColumnAmount = 24;
    static int gameRowAmount = 20;

    /*
        3D Rendering Equations From https://homepages.inf.ed.ac.uk/rbf/CVonline/LOCAL_COPIES/EPSRC_SSAZ/node3.html
     */


    /*
        ActualTileSize uses the variables from above to calculate how big each tile actually should be
        Game Width and Height takes into account the columns and rows and calculates the window heights and widths using all the factors provided above
     */
    static int ActualTileSize = GameTileSize * ScalableValue;
    static int gameWidth = 1920; //gameColumnAmount*ActualTileSize;
    static int gameHeight = 1080; //gameRowAmount*ActualTileSize;


    //Game Values
    int FPS = 144;

    /*
        Matrix Stuff
     */
    double[][] TwoDProjMat = {
        {1,0,0,0},
        {0,1,0,0},
        {0,0,1,0}
    };
    double[][] CameraMat = {
            {0},
            {0},
            {0},
            {1}
    };

    Matrix TwoDProjectionMatrix = new Matrix(TwoDProjMat);


    //Starting thread, managing frame updates
    Thread gameThread;
    public void startWindowThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //Loop that runs the thread, allows for it to sleep and start and ensures proper frame speed
    @Override
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }

        }
    }

    public void update(){
        ;
    }

    //Function that paints the updated version of the frame {FPS} times a second.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;
        graphics.fillOval(gameWidth/2,gameHeight/2,100,100);
    }
}