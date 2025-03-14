package com.soft.amh.gameWindows;

import javax.swing.*;
import java.awt.*;

import static com.soft.amh.constants.GameConstants.GAME_SCREEN_HEIGHT;
import static com.soft.amh.constants.GameConstants.GAME_SCREEN_WIDTH;

public class GamePanel extends JPanel {

    private GameWindow gameWindow;

    public GamePanel(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setPreferredSize(new Dimension(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameWindow.render(g);
    }
}