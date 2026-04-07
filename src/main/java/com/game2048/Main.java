package com.game2048;

import com.game2048.controller.GameController;
import com.game2048.view.HeadlessView;

public class Main {
    
    public static void main(String[] args) {
        GameController game = new GameController(new HeadlessView(), 4);
        game.startGame();
    }

}