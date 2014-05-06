package backend.actionhelpers;

import game.impl.BoardLocation;
import game.impl.Move;
import backend.State;

import java.util.List;

public class MoveValidator {

    private State state;
    private Move move;

    public MoveValidator(State state, Move move){
        this.state = state;
        this.move = move;
    }

    public boolean isRequestForRepublish(){
        return move == null;
    }

    public boolean isPlayersTurnToMove(){
        return move.getPlayer() == state.getCurrentPlayer();
    }

    public boolean doesDestinationExist(){
        return move.getDestination() != null;
    }

    public boolean isDestinationEmpty(){
        return move.getDestination().getPiece() == null;
    }

    public boolean isTryingToMovePieceAlreadyPlaced(){
        return move.getSource() != null;
    }

    public boolean isValidOthelloMove(){
        List<BoardLocation> locations = new LocationsToFlipCalculation(state, move.getDestination(), move.getPlayer()).getLocationsToFlip();

        return locations.size() > 0;
    }
}
