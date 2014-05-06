package backend.actionhelpers;

import game.impl.BoardLocation;
import game.impl.Move;
import backend.util.GameRules;
import backend.State;
import game.impl.Player;

public class MoveValidator {

    private State state;
    private Move move;

    public MoveValidator(State state, Move move){
        this.state = state;
        this.move = move;
    }

    public boolean isMoveNull(){
        return move == null;
    }

    public boolean isPlayersTurnToMove(){
        return move.getPlayer() == state.getCurrentPlayer();
    }

    public boolean doesDestinationExist(){
        return move.getDestination() != null;
    }

    public boolean isDestinationEmpty(){
        return GameRules.isLocationEmpty(move.getDestination());
    }

    public boolean isTryingToMovePieceAlreadyPlaced(){
        return move.getSource() != null;
    }

    public boolean isValidOthelloMove(){
        return GameRules.isLocationValidForMove(state, move.getDestination(), move.getPlayer());
    }
}
