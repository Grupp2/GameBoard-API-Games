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
    
    public void notifyListeners(String loc) {
        if (loc.toLowerCase().equals("republish"))
            return;
        notifyListenersOfMove(new Move(state.getPlayerInTurn(), new GamePiece(Settings.PIECE_ACTION),
                getLocationById(state.getBoard(), loc)));
    }

}
