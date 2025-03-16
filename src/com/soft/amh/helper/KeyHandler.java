package com.soft.amh.helper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       switch (e.getKeyCode()){
           case KeyEvent.VK_LEFT -> System.out.println("Left");
           case KeyEvent.VK_RIGHT -> System.out.println("Right");
           case KeyEvent.VK_UP -> System.out.println("Up");
           case KeyEvent.VK_DOWN -> System.out.println("Down");
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
