package io;

import game.api.GameState;
import game.impl.Board;
import game.impl.BoardLocation;
import game.io.OutputUnit;
import game.impl.*;

/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleOutputUnit implements OutputUnit {
    @Override
    public void publish(GameState gameState) {
        Board board = gameState.getBoard();
        GamePiece piece;
        System.out.println("  1  2  3  4  5  6  7  8");
        char[] rows = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
        int b = 0;
        int lim = 8;
        for (int i = 0; i < 8; i++) {
        	System.out.print(rows[i] + " ");
        	for (;b < lim; b++) {
        		if ((piece = board.getLocations().get(b).getPiece()) != null)
        			System.out.print(piece.getId() + "  ");
        		else
        			System.out.print("  ");
        	}
        	lim += 8;
        	System.out.println();
        }
            

    }
}
