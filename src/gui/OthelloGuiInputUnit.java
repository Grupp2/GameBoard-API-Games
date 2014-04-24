package gui;

import impl.util.GameRules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import game.api.GameState;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.Player;
import game.io.InputUnit;

public class OthelloGuiInputUnit extends InputUnit {
	private GameState state;
	private OthelloGameFrame gameFrame;

	private Move getNextMove(GameState state)
	{
		Move result = null;
		try {
			String input = readGameBoard();
			result = new Move(state.getPlayerInTurn(), new GamePiece(
						getGamePieceID(state.getPlayerInTurn(), state)),
						GameRules.getLocationById(state.getBoard(), input));
		} catch (Exception ex) {
		}
		return result;
	}
	
	private String readGameBoard() {
		
		return null;
	}

	private String getGamePieceID(Player player, GameState gameState)
	{
		if (player == gameState.getPlayers().get(0))
			return "O";
		else
			return "X";
	}

	@Override
	public void setup(GameState state)
	{
		this.state = state;
		this.gameFrame = new OthelloGameFrame(state);
		gameFrame.setVisible(true);
	}
	
	public void notifyListeners() {
		
	}
}
