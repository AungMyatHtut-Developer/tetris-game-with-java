package com.soft.amh.entity;

import java.awt.*;

public class Tetromino {

    private int x,y;
    private int blockWidth = 20, blockHeight = 20;
    private TetrominoType tetrominoType;
    private int movementSpeed = 20;
    private int updateCount;

    public Tetromino(int x, int y, TetrominoType tetrominoType) {
        this.x = x;
        this.y = y;
        this.tetrominoType = tetrominoType;
    }

    public void update() {
        if(updateCount > movementSpeed){
            y+=20;
            updateCount = 0;
        }else{
            updateCount++;
        }
    }

    public void render(Graphics g){
        int[][] tetrominoData = tetrominoType.getTetrominoData();
        for (int i = 0; i < tetrominoData.length; i++) {
            for (int j = 0; j < tetrominoData[i].length; j++) {
                if(tetrominoData[i][j] == 1){
                    g.setColor(tetrominoType.getColor());
                    g.fillRect(x + (i * blockWidth) , y + (j * blockHeight), blockWidth, blockHeight);
                    g.setColor(Color.WHITE);
                    g.drawRect(x + (i * blockWidth) , y + (j * blockHeight), blockWidth -1, blockHeight-1);
                }
            }
        }
    }
}
