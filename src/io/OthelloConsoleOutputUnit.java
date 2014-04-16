package io;

import game.api.GameState;
import game.impl.Board;
import game.impl.BoardLocation;
import game.io.OutputUnit;

/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleOutputUnit implements OutputUnit {
    @Override
    public void publish(GameState gameState) {
        Board board = gameState.getBoard();
        System.out.println("1 2 3 4 5 6 7 8");

        for (BoardLocation loc : board.getLocations())
            loc.getId();


    }
}
