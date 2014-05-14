package othelloconsoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import othellobackend.OthelloGameFacade;
import game.api.GameState;
import game.impl.*;
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
			if (input.equals("UNDO")) {
				if (((OthelloGameFacade) state).canUndo())
					((OthelloGameFacade) state).undo();
				else
					System.out.println("Cannot undo move.");

			} else {
				result = new Move(state.getPlayerInTurn(), new GamePiece(
						getGamePieceID(state.getPlayerInTurn(), state)),
						getLocationById(state.getBoard(), input));
			}
		} catch (IOException ex) {
		}
		return result;
	}

    private BoardLocation getLocationById(Board board, String id){
        List<BoardLocation> locations = board.getLocations();

        for(int i = 0; i < locations.size(); i++)
            if(locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
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
