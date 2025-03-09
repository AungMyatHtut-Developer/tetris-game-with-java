package com.soft.amh.gameWindows;

public class GameWindow {

    private GameFrame gameFrame;
    private GamePanel gamePanel;

    public GameWindow() {
        gamePanel = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
    }
}
