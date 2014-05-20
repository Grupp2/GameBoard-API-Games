package battleships.backend.actionhelpers;

import battleships.backend.Settings;
import battleships.backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;

import java.util.List;

public class NormalMoveValidationHelper implements MoveValidatable {
    private State state;
    
//    public NormalMoveValidationHelper(State state, ) {
//    	
//    }
    
    public NormalMoveValidationHelper(State state) {
        this.state = state;
    }
	@Override
	public boolean makeMoveValidation(Move move) {
        List<BoardLocation> boardLocations = state.getBoard().getLocations();
        List<GamePiece> destinationPieces = boardLocations.get(boardLocations.indexOf(move.getDestination())).getPieces();
        if (destinationPieces.size() == 2) {
            state.setMessage("Location already shot at.");
            return false;
        }
        if (destinationPieces.size() == 1) {
            GamePiece piece =destinationPieces.get(0);

            if (piece.getId().equals(Settings.PIECE_ALREADYHIT)) {
                state.setMessage("You've already shot at that location!");
                return false;
            } else if (piece.getId().equals(Settings.PIECE_SHIP)) {
                state.setMessage("You've hit a ship!");
                return true;
            }
        }

        return false;
	}

}
