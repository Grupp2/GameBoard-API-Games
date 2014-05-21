package battleships.backend.actionhelpers;

import java.util.List;

import battleships.backend.State;
import battleships.backend.classhelpers.MoveToPieceConverter;
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
		
		return false;
	}
}
