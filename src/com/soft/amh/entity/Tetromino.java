package com.soft.amh.entity;

import java.awt.*;

public class Tetromino {

    private int x,y;
    private int blockWidth = 20, blockHeight = 20;
    private TetrominoType tetrominoType;
    private int downSpeed = 20;
    private int updateCount;
    private int leftRightSpeed = 1;
    private int leftRightUpdateCount;

    private boolean isActive;
    private boolean left,right,up,down;

    public Tetromino(int x, int y, TetrominoType tetrominoType, boolean isActive) {
        this.x = x;
        this.y = y;
        this.tetrominoType = tetrominoType;
        this.isActive = isActive;
    }

    public void update() {

        if(leftRightUpdateCount > leftRightSpeed){
            move();
            leftRightUpdateCount = 0;
        }else{
            leftRightUpdateCount++;
        }

        if(updateCount > downSpeed){
            y+=20;
            updateCount = 0;
        }else{
            updateCount++;
        }

        //check left boundary
        if(x < 100 - tetrominoType.getOffsetXL()){
            x = 100 - tetrominoType.getOffsetXL();
        }
        //check right boundary
        if( (x + (blockWidth * 4)) - tetrominoType.getOffsetXR() > 400){
            x = (400 - (blockWidth * 4)) + tetrominoType.getOffsetXR();
        }

        if (y > 700) {
            isActive = false;
        }
    }

    private void move() {
        if (left && !right) {
            x -= 20;
        }

        if (right && !left) {
            x += 20;
        }

        if (down && !up){
            y += 20;
        }
    }

    public void switchShape(){
        tetrominoType = tetrominoType.next();
    }

    public void render(Graphics g){
        int[][] tetrominoData = tetrominoType.getTetrominoData();
        for (int deltaY = 0; deltaY < tetrominoData.length; deltaY++) {
            for (int deltaX = 0; deltaX < tetrominoData[deltaY].length; deltaX++) {
                if(tetrominoData[deltaY][deltaX] == 1){
                    g.setColor(tetrominoType.getColor());
                    g.fillRect(x + (deltaX * blockWidth) , y + (deltaY * blockHeight), blockWidth, blockHeight);
                    g.setColor(Color.WHITE);
                    g.drawRect(x + (deltaX * blockWidth) , y + (deltaY * blockHeight), blockWidth -1, blockHeight-1);
                    g.drawRect(x,y,blockWidth*4, blockHeight*4);
                }
            }
        }
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isActive() {
        return isActive;
    }
}
