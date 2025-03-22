package com.soft.amh.entity;

import com.soft.amh.gameWindows.TetrisWorld;

import java.awt.*;

import static com.soft.amh.helper.CollisionHelper.canMove;

public class Tetromino {

    private int x,y;
    private int blockWidth = 20, blockHeight = 20;
    private TetrominoType tetrominoType;
    private TetrisWorld tetrisWorld;
    private int downSpeed = 20;
    private int updateCount;
    private int leftRightSpeed = 1;
    private int leftRightUpdateCount;

    private boolean isActive;
    private boolean left,right,up,down;

    public Tetromino(int x, int y, TetrominoType tetrominoType, boolean isActive, TetrisWorld tetrisWorld) {
        this.tetrisWorld = tetrisWorld;
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
            if(canMoveDown()){
                y+=20;
            }else{
                isActive = false;
            }
            updateCount = 0;
        }else{
            updateCount++;
        }


        checkBoundaries();
    }

    private void checkBoundaries() {
        //check left boundary
        if(x < 100 - tetrominoType.getOffsetXL()){
            x = 100 - tetrominoType.getOffsetXL();
        }
        //check right boundary
        if( (x + (blockWidth * 4)) - tetrominoType.getOffsetXR() > 400){
            x = (400 - (blockWidth * 4)) + tetrominoType.getOffsetXR();
        }

        //check down boundary
        if ( (y + (blockHeight * 4 ) - tetrominoType.getOffsetYD()) > 700) {
            y = (700 - (blockHeight * 4)) + tetrominoType.getOffsetYD();
            isActive = false;
        }
    }

    private void move() {
        if (left && !right) {

            if(canMoveLeft()){
                x -= 20;
            } else if (!canMoveRight()) {
                isActive = false;
            }
        }

        if (right && !left) {
            if(canMoveRight()){
                x += 20;
            } else if (!canMoveLeft()) {
                isActive = false;
            }
        }

        if (down && !up){
            if(canMoveDown()){
                y += 20;
            }else {
                isActive = false;
            }
        }
    }

    private boolean canMoveRight() {
       return canMove(tetrisWorld.getCollisionData(), x + 20, y, tetrominoType);
    }

    private boolean canMoveLeft() {
        return canMove(tetrisWorld.getCollisionData(), x - 20, y, tetrominoType);
    }

    private boolean canMoveDown() {
        return canMove(tetrisWorld.getCollisionData(), x , y + 20, tetrominoType);
    }

    public void switchShape(){
        TetrominoType nextType = tetrominoType.next();
        if(canMove(tetrisWorld.getCollisionData(), x, y, nextType)){
            tetrominoType = nextType;
        }
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
                    //g.drawRect(x,y,blockWidth*4, blockHeight*4);
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

    public TetrominoType getTetrominoType() {
        return tetrominoType;
    }
    public int[][] getTetrominoData() {
        return tetrominoType.getTetrominoData();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
