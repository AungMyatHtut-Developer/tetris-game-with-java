package com.soft.amh.gameWindows;

import com.soft.amh.entity.Tetromino;
import com.soft.amh.entity.TetrominoType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TetrisWorld {

    private List<Tetromino> tetrominoList;
    private int[][] collisionData;
    private Color[][] colorData;
    private Random random;

    public TetrisWorld() {
        random = new Random();
        tetrominoList = new ArrayList<>();
        collisionData = new int[30][15];
        colorData = new Color[30][15];
        Tetromino tetromino3 = new Tetromino(300,200, TetrominoType.I, true, this);
        tetrominoList.add(tetromino3);
    }

    public void update() {
        Iterator<Tetromino> tetrominoIterator = tetrominoList.iterator();
        while (tetrominoIterator.hasNext()) {
            Tetromino t = tetrominoIterator.next();
            t.update();
            if (!t.isActive()) {
                addToCollisionData(t.getTetrominoData(),t.getX(), t.getY(), t.getTetrominoType());
                tetrominoIterator.remove();
            }
        }

        if (tetrominoList.isEmpty()) {
            tetrominoList.add(new Tetromino(260,100, generateRandomTetromino(), true, this));
        }

    }

    private void addToCollisionData(int[][] tetrominoData, int x, int y, TetrominoType tetrominoType) {

        for (int deltaY = 0; deltaY < tetrominoData.length; deltaY++) {
            for (int deltaX = 0; deltaX < tetrominoData[deltaY].length; deltaX++) {

                if (tetrominoData[deltaY][deltaX] == 1) {
                    //calculate position in collision grid
                    int gridX = (x - 100 + (deltaX * 20)) / 20;
                    int gridY = (y - 100 + (deltaY * 20)) / 20;

                    if (gridX >= 0 && gridX < collisionData[0].length && gridY >= 0 && gridY < collisionData.length) {
                        collisionData[gridY][gridX] = 1;
                        colorData[gridY][gridX] = tetrominoType.getColor();
                    }
                }
            }
        }

    }

    private TetrominoType generateRandomTetromino() {
        return switch (getRandomNumber(23)) {
            case 2 -> TetrominoType.I1;
            case 3 -> TetrominoType.O;
            case 4 -> TetrominoType.L;
            case 5 -> TetrominoType.L1;
            case 6 -> TetrominoType.L2;
            case 7 -> TetrominoType.L3;
            case 8 -> TetrominoType.J;
            case 9 -> TetrominoType.J1;
            case 10 -> TetrominoType.J2;
            case 11 -> TetrominoType.J3;
            case 12 -> TetrominoType.T;
            case 13 -> TetrominoType.T1;
            case 14 -> TetrominoType.T2;
            case 15 -> TetrominoType.T3;
            case 16 -> TetrominoType.Z;
            case 17 -> TetrominoType.Z1;
            case 18 -> TetrominoType.Z2;
            case 19 -> TetrominoType.Z3;
            case 20 -> TetrominoType.ZR;
            case 21 -> TetrominoType.ZR1;
            case 22 -> TetrominoType.ZR2;
            case 23 -> TetrominoType.ZR3;
            default -> TetrominoType.I;
        };
    }

    private int getRandomNumber(int bound) {
        return random.nextInt(bound);
    }

    public void render(Graphics g) {
        for (Tetromino t : tetrominoList) {
            t.render(g);
        }

        for (int deltaY = 0; deltaY < collisionData.length; deltaY++) {
            for (int deltaX = 0; deltaX < collisionData[deltaY].length; deltaX++) {

                if (collisionData[deltaY][deltaX] == 1) {
                    g.setColor(colorData[deltaY][deltaX]);
                    g.fillRect(deltaX * 20 + 100, deltaY * 20 + 100, 20,20);
                    g.setColor(Color.WHITE);
                    g.drawRect(deltaX * 20 + 101, deltaY * 20 + 101, 19, 19);
                }

            }
        }
    }

    public void setLeft(boolean status) {
        for (Tetromino t : tetrominoList) {
            if(t.isActive()) t.setLeft(status);
        }
    }
    public void setRight(boolean status) {
        for (Tetromino t : tetrominoList) {
            if(t.isActive()) t.setRight(status);
        }
    }
    public void switchShape() {
        for (Tetromino t : tetrominoList) {
            if(t.isActive()) t.switchShape();
        }
    }
    public void setDown(boolean status) {
        for (Tetromino t : tetrominoList) {
            if(t.isActive()) t.setDown(status);
        }
    }

    public int[][] getCollisionData() {
        return collisionData;
    }
}
