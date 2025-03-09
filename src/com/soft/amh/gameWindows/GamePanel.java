package com.soft.amh.gameWindows;

import javax.swing.*;
import java.awt.*;

import static com.soft.amh.constants.GameConstants.*;

public class GamePanel extends JPanel{

    public GamePanel() {
        setPreferredSize(new Dimension(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT));
    }
}