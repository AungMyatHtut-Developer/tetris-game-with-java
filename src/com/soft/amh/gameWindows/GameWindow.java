package com.soft.amh.gameWindows;

import java.awt.*;

public class GameWindow implements Runnable{

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Thread gameThread;
    private boolean isGameRunning;

    public GameWindow() {
        gamePanel = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
        initGameLoop();
    }


    private void initGameLoop(){
        gameThread = new Thread(this);
        isGameRunning = true;
        gameThread.start();
    }

    @Override
    public void run() {

        double targetFps = 1_000_000_000 / 60;
        //double targetUps = 60 / 1_000;
        long currentTimeForFps =0;
        long lastTimeForFps = System.nanoTime();


        long currentTimeForFpsTracker =0;
        long lastTimeForFpsTracker = System.currentTimeMillis();
        int fps = 0;
        while (isGameRunning){

            currentTimeForFps = System.nanoTime();
            if(currentTimeForFps - lastTimeForFps >= targetFps){
                lastTimeForFps = currentTimeForFps;
                update();
                render(gamePanel.getGraphics());
                fps++;
            }

            currentTimeForFpsTracker = System.currentTimeMillis();
            if(currentTimeForFpsTracker - lastTimeForFpsTracker >= 1_000){
                lastTimeForFpsTracker = currentTimeForFpsTracker;
                System.out.println("FPS : "+ fps);
                fps=0;
            }

        }
    }


    public void update(){
        //update game components
    }

    public void render(Graphics graphics){
        //render game ui
        gamePanel.repaint();
    }
}
