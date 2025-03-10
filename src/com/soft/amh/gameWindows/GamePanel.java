package com.soft.amh.gameWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.soft.amh.constants.GameConstants.*;

public class GamePanel extends JPanel implements ActionListener {

    private float rectX, rectY;
    private int xDirection, yDirection, rectWidth, rectHeight;
    private Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT));
        xDirection = 1;
        yDirection = 1;
        rectWidth = 50;
        rectHeight = 50;

        timer = new Timer(1, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect((int) rectX, (int) rectY, rectWidth,rectHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(rectX < 0 || (rectX + rectWidth) > getWidth()){
            xDirection *= -1;
        }

        if(rectY < 0 || (rectY + rectHeight) > getHeight()){
            yDirection *= -1;
        }

        rectX+=xDirection;
        rectY+=yDirection;

        repaint();
    }
}