package backend.actionhelpers;

import game.impl.Move;
import backend.State;

public class MoveValidationHelper {

    private State state;
    private Move move;

    public MoveValidationHelper(State state, Move move){
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
        MoveHelper moveHelper = new MoveHelper(state);
        return moveHelper.isLocationValidOthelloMoveForPlayer(move.getDestination(), state.getCurrentPlayer());
    }
}
