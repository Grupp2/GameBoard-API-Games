package battleships.gui;

import battleships.backend.Settings;
import game.api.GameState;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;
import game.io.InputUnit;

import java.util.List;

public class BattleShipsInputUnit extends InputUnit{
	private GameState state;
	
    @Override
    public void setup(GameState state) {
    	this.state = state;
        this.state.reset();
    }

    private BoardLocation getLocationById(Board board, String id) {
        List<BoardLocation> locations = board.getLocations();

        for (int i = 0; i < locations.size(); i++)
            if (locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }
    
    public void notifyListeners(String locationId) {
        if (locationId.toLowerCase().equals("republish"))
            return;

        GamePiece piece = new GamePiece(Settings.PIECE_ACTION);
        BoardLocation targetLocation = getLocationById(state.getBoard(), locationId);

        Move theMove = new Move(state.getPlayerInTurn(), piece, targetLocation);

        notifyListenersOfMove(theMove);
    }

}
