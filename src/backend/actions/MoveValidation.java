package backend.actions;

import game.impl.BoardLocation;
import game.impl.Move;
import backend.util.GameRules;
import backend.State;
import game.impl.Player;

public class MoveValidation {

    private State state;
    private Move move;

    public MoveValidation(State state, Move move){
        this.state = state;
        this.move = move;
    }

    public boolean execute(){
        if(!isPlayersTurnToMove()){
            state.setMessage("It's not your turn!");
            return false;
        }

        if(!doesDestinationExist()){
            state.setMessage("Invalid location!");
            return false;
        }

        if(!isDestinationEmpty()){
            state.setMessage("There is already a piece in that location!");
            return false;
        }

        if(isTryingToMovePieceAlreadyPlaced()){
            state.setMessage("You cannot move a piece already placed on the board.");
            return false;
        }

        if(!isValidOthelloMove()){
            state.setMessage("You have to put your piece at a valid location!");
            return false;
        }

        state.setMessage("");
        return true;
    }

    private boolean isPlayersTurnToMove(){
        return move.getPlayer() == state.getCurrentPlayer();
    }

    private boolean doesDestinationExist(){
        return move.getDestination() != null;
    }

    private boolean isDestinationEmpty(){
        return GameRules.isLocationEmpty(move.getDestination());
    }

    private boolean isTryingToMovePieceAlreadyPlaced(){
        return move.getSource() != null;
    }

    private boolean isValidOthelloMove(){
        return GameRules.isLocationValidForMove(state, move.getDestination(), move.getPlayer());
    }
}
