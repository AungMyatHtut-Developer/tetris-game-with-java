package com.soft.amh.gameWindows;

import javax.swing.*;
import java.awt.*;

import static com.soft.amh.constants.GameConstants.GAME_SCREEN_HEIGHT;
import static com.soft.amh.constants.GameConstants.GAME_SCREEN_WIDTH;

public class GamePanel extends JPanel {

    private float rectX, rectY;
    private int xDirection, yDirection, rectWidth, rectHeight;

    public GamePanel() {
        setPreferredSize(new Dimension(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT));
        xDirection = 1;
        yDirection = 1;
        rectWidth = 50;
        rectHeight = 50;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect((int) rectX, (int) rectY, rectWidth,rectHeight);
    }
}