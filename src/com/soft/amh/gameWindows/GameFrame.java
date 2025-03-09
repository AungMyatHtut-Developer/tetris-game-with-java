package com.soft.amh.gameWindows;

import javax.swing.*;

public class GameFrame {

    private JFrame jFrame;

    public GameFrame(GamePanel gamePanel){
        jFrame = new JFrame();
        jFrame.setTitle("Tetris Clone");
        jFrame.add(gamePanel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(3);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}