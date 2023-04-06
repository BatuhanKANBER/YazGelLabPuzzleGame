package org.example;

import puzzle.GameScreen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GameScreen gameScreen;
        try {
            gameScreen=new GameScreen();
            gameScreen.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}