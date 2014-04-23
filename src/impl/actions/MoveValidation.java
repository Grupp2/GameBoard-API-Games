package impl.actions;

import game.impl.Move;
import impl.util.GameRules;
import impl.State;

/**
 * @author erik
 */
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

        if(!GameRules.isLocationEmpty(move.getDestination())){
            state.setMessage("There is already a piece in that location!");
            return false;
        }

        if(move.getSource() != null){
            state.setMessage("You cannot move a piece already placed on the board.");
            return false;
        }

        if(!GameRules.isLocationNextToPiece(state.getBoard(), move.getDestination())){
            state.setMessage("You have to put your piece next to an existing one.");
            return false;
        }

        state.setMessage("");
        return true;
    }

}
