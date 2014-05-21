package battleships.backend.actionhelpers;

import java.util.List;

import battleships.backend.Settings;
import battleships.backend.State;
import battleships.backend.classhelpers.MoveToPieceConverter;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.BoardLocation;

public class DeployMoveExecutor implements MoveExecutable {
	private State state;
	private List<BoardLocation> pieceLocationsArray;
	
	public DeployMoveExecutor(State state) {
		this.state = state;
	}
	
	private void createPieceLocationArray(Move move, Move firstMove) {
		MoveToPieceConverter mtp = new MoveToPieceConverter();
		pieceLocationsArray = mtp.pieceLocations(firstMove.getDestination(), move.getDestination());
	}

	@Override
	public boolean executeMove(Move move, Move firstMove) {
		createPieceLocationArray(move, firstMove);
		List<BoardLocation> boardLocations = state.getBoard().getLocations();
		BoardLocation locationToAlter = boardLocations.get(boardLocations.indexOf(move.getDestination()));
		for (int i = 0; i < pieceLocationsArray.size(); i++)
			locationToAlter.setPiece(new GamePiece(Character.toString(Settings.PIECE_SHIP)));
		return false;
	}
}
