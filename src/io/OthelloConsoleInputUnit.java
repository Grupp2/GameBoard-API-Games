package io;

import game.api.GameState;
import game.impl.Board;
import game.io.InputUnit;

/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleInputUnit extends InputUnit {
    @Override
    public void setup(GameState gameState) {
        Board board = gameState.getBoard();
        for (int i = 0; i <= 8; i++)
            System.out.println(i);


    }
}
