package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import game.api.GameState;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;
import game.io.InputUnit;

/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleInputUnit extends InputUnit {
	
	private final BufferedReader inputSourceReader = new BufferedReader(new InputStreamReader(System.in));

    private Move getNextMove(GameState state) {
        Move result = null;
        try {
            List<String> input = Arrays.asList(inputSourceReader.readLine().split(" "));
            if (input.size() > 1) {
                result = new Move(state.getPlayerInTurn(), resolveBoardLocation(state, input.get(0)), resolveBoardLocation(state, input.get(1)));
            } else if (input.size() > 0) {
                result = new Move(state.getPlayerInTurn(), getFirstUnusedPiece(state), resolveBoardLocation(state, input.get(0)));
            }
        } catch (IOException ex) {
        }
        return result;
    }

    private BoardLocation resolveBoardLocation(GameState state, String code) {
        try {
            for (BoardLocation location : state.getBoard().getLocations()) {
                if (location.getId().equals(code)) {
                    return location;
                }
            }
        } catch (Exception ex) {
        }
        return null;
    }

    private GamePiece getFirstUnusedPiece(GameState state) {
        for (GamePiece piece : state.getPlayerInTurn().getPieces()) {
            boolean found = true;
            for (BoardLocation location : state.getBoard().getLocations()) {
                if (location.getPiece() != null && location.getPiece().equals(piece)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return piece;
            }
        }
        return null;
    }

    @Override
    public void setup(GameState state) {
        while (!state.hasEnded()) {
            notifyListenersOfMove(getNextMove(state));
        }
        System.exit(0);
    }
}
