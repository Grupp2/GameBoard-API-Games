package battleships.backend.actionhelpers;

import java.util.List;

import battleships.backend.Settings;
import battleships.backend.State;
import battleships.backend.classhelpers.MoveToPieceConverter;
import game.impl.Board;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.BoardLocation;

public class DeployMoveExecutor_OLD implements MoveExecutor {
	private State state;
	private List<BoardLocation> pieceLocationsArray;
	
	public DeployMoveExecutor_OLD(State state) {
		this.state = state;
	}
	
	private void createPieceLocationArray(Move move) {
        Move firstMove = null;
		MoveToPieceConverter mtp = new MoveToPieceConverter();
		pieceLocationsArray = mtp.pieceLocations(firstMove.getDestination(), move.getDestination());
	}
	
	private BoardLocation getLocationById(Board board, String id) {
        List<BoardLocation> locations = board.getLocations();

        for (int i = 0; i < locations.size(); i++)
            if (locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }

	@Override
	public void executeMove(Move move) {
        Move firstMove = null;
		createPieceLocationArray(move);
		BoardLocation locationToAlter;
		for (int i = 0; i < pieceLocationsArray.size(); i++){
			locationToAlter = getLocationById(state.getBoard(), pieceLocationsArray.get(i).getId());
			locationToAlter.setPiece(new GamePiece(Settings.PIECE_SHIP));
		}
	}
}
