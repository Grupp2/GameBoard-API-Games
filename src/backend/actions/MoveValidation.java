package backend.actions;

import game.impl.Move;
import backend.util.GameRules;
import backend.State;

public class MoveValidation {

    private State state;
    private Move move;

    public MoveValidation(State state, Move move){
        this.state = state;
        this.move = move;
    }

    public boolean execute(){
        if(move.getPlayer() != state.getCurrentPlayer()){
            state.setMessage("It's not your turn!");
            return false;
        }

        if(move.getDestination() == null){
            state.setMessage("Invalid location!");
            return false;
        }

        if(!GameRules.isLocationEmpty(move.getDestination())){
            state.setMessage("There is already a piece in that location!");
            return false;
        }

        if(move.getSource() != null){
            state.setMessage("You cannot move a piece already placed on the board.");
            return false;
        }

        if(!GameRules.isLocationValidForMove(state, move.getDestination(), move.getPlayer())){
            state.setMessage("You have to put your piece at a valid location!");
            return false;
        }

        state.setMessage("");
        return true;
    }

}
