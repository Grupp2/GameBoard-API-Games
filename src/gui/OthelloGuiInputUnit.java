package gui;

import backend.util.GameRules;
import game.api.GameState;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.Player;
import game.io.InputUnit;

public class OthelloGuiInputUnit extends InputUnit {
	private GameState state;
	private OthelloGameFrame gameFrame;
	private String input;
	private Move getNextMove(GameState state) {
		Move result = null;
		try {
			result = new Move(state.getPlayerInTurn(), new GamePiece(
					getGamePieceID(state.getPlayerInTurn(), state)),
					GameRules.getLocationById(state.getBoard(), input));
		} catch (Exception ex) {
			gameFrame.setStatusLabelText(ex.getMessage());
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
		this.state = state;
		this.gameFrame = new OthelloGameFrame();
		gameFrame.setVisible(true);
	}

	public void notifyListeners(String inputTileName) {
		input = inputTileName;
		notifyListenersOfMove(getNextMove(state));
	}
}
