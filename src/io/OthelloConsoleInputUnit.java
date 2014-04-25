package io;

import backend.util.GameRules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import game.api.GameState;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.Player;
import game.io.InputUnit;

/**
 * Created by HuggTop on 2014-04-16.
 */
public class OthelloConsoleInputUnit extends InputUnit {

	private final BufferedReader inputSourceReader = new BufferedReader(
			new InputStreamReader(System.in));

	private Move getNextMove(GameState state) {
		Move result = null;
		try {
			String input = inputSourceReader.readLine().replaceAll("\\s", "")
					.toUpperCase();
			if (input.equals("undo")) {
				

			} else {
				result = new Move(state.getPlayerInTurn(), new GamePiece(
						getGamePieceID(state.getPlayerInTurn(), state)),
						GameRules.getLocationById(state.getBoard(), input));
			}
		} catch (IOException ex) {
		}
		return result;
	}

	private String getGamePieceID(Player player, GameState gameState) {
		if (player == gameState.getPlayers().get(0))
			return "O";
		else
			return "X";
	}

	@Override
	public void setup(GameState state) {
		while (!state.hasEnded()) {
			notifyListenersOfMove(getNextMove(state));
		}
		System.exit(0);
	}
}
