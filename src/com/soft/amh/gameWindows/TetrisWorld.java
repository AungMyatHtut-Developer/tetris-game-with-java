package com.soft.amh.gameWindows;

import com.soft.amh.entity.Tetromino;
import com.soft.amh.entity.TetrominoType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TetrisWorld {

    List<Tetromino> tetrominoList;

    public TetrisWorld() {
        tetrominoList = new ArrayList<>();
        Tetromino tetromino1 = new Tetromino(100,100, TetrominoType.J2);
        Tetromino tetromino2 = new Tetromino(100,200, TetrominoType.T1);
        Tetromino tetromino3 = new Tetromino(300,200, TetrominoType.O);
        tetrominoList.add(tetromino1);
        tetrominoList.add(tetromino2);
        tetrominoList.add(tetromino3);
    }

    public void update() {
        for (Tetromino t : tetrominoList) {
            t.update();
        }
    }

    public void render(Graphics g) {
        for (Tetromino t : tetrominoList) {
            t.render(g);
        }
    }
}
