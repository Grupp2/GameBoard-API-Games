package othello.gui;

import game.api.GameState;
import game.impl.*;
import game.io.InputUnit;

import java.util.List;

public class OthelloGuiInputUnit extends InputUnit {
	private GameState state;
	private OthelloGameFrame gameFrame;
	private String input;
	
	private Move getNextMove(GameState state) {
        if(input.toLowerCase().equals("republish"))
            return null;

		Move result = null;
		try {

			result = new Move(state.getPlayerInTurn(), new GamePiece(
					getGamePieceID(state.getPlayerInTurn(), state)),
					getLocationById(state.getBoard(), input));
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

    private BoardLocation getLocationById(Board board, String id){
        List<BoardLocation> locations = board.getLocations();

        for(int i = 0; i < locations.size(); i++)
            if(locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }

	@Override
	public void setup(GameState state) {
		this.state = state;
		this.state.reset();
	}

	public void notifyListeners(String inputTileName) {
		input = inputTileName;
		notifyListenersOfMove(getNextMove(state));
	}
}
