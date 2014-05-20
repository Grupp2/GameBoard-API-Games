package battleships.backend;

import battleships.backend.actionhelpers.MoveValidateable;
import battleships.backend.actionhelpers.ResetHelper;
import game.impl.Move;
import game.impl.Player;

public class GameActionsHandler {
    private State state;
    
    public GameActionsHandler(State state) {
	    this.state = state;
    }
    public MoveValidateable moveValidator;

    public Player calculateWinner() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean validateMove(Move move) {
        // TODO Auto-generated method stub
        return false;
    }

    public void executeMove(Move move) {
        // TODO Auto-generated method stub

    }

    public Boolean hasEndedCheck() {
        // TODO Auto-generated method stub
        return null;
    }

    public void reset() {
        ResetHelper resetHelper = new ResetHelper(state);
        resetHelper.reset();
    }
}
