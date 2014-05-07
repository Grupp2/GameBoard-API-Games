package backend.actionhelpers;

import game.impl.Move;
import backend.State;

public class MoveValidationHelper {

    private State state;
    private MoveHelper moveHelper;

    public MoveValidationHelper(State state, MoveHelper moveHelper){
        this.state = state;
        this.moveHelper = moveHelper;
    }

    public MoveValidationHelper(State state){
        this(state, new MoveHelper(state));
    }

    public boolean validate(Move move){
        if(isRequestForRepublish(move)){
            state.setMessage("");
            return false;
        }

        if(!isPlayersTurnToMove(move)){
            state.setMessage("It's not your turn!");
            return false;
        }

        if(!doesDestinationExist(move)){
            state.setMessage("Invalid location!");
            return false;
        }

        if(!isDestinationEmpty(move)){
            state.setMessage("There is already a piece in that location!");
            return false;
        }

        if(isTryingToMovePieceAlreadyPlaced(move)){
            state.setMessage("You cannot move a piece already placed on the board.");
            return false;
        }

        if(!isValidOthelloMove(move)){
            state.setMessage("You have to put your piece at a valid location!");
            return false;
        }

        state.setMessage("");
        return true;
    }

    public boolean isRequestForRepublish(Move move){
        return move == null;
    }

    public boolean isPlayersTurnToMove(Move move){
        return move.getPlayer() == state.getCurrentPlayer();
    }

    public boolean doesDestinationExist(Move move){
        return move.getDestination() != null;
    }

    public boolean isDestinationEmpty(Move move){
        return move.getDestination().getPiece() == null;
    }

    public boolean isTryingToMovePieceAlreadyPlaced(Move move){
        return move.getSource() != null;
    }

    public boolean isValidOthelloMove(Move move){

        return moveHelper.isLocationValidOthelloMoveForPlayer(move.getDestination(), state.getCurrentPlayer());
    }
}
