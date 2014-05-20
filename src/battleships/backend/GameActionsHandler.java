package battleships.backend;

import battleships.backend.actionhelpers.MoveValidatable;
import battleships.backend.actionhelpers.MoveValidatorStrategy;
import battleships.backend.actionhelpers.ResetHelper;
import game.impl.Move;
import game.impl.Player;

public class GameActionsHandler {
    private State state;
    private MoveValidatorStrategy moveValidatorStrategy;
    
    public GameActionsHandler(State state) {
	    this.state = state;
        this.moveValidatorStrategy = new MoveValidatorStrategy(state);
    }

    public Player calculateWinner() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean validateMove(Move move) {
        return moveValidatorStrategy.getMoveValidator().makeMoveValidation(move);
    }

    public void executeMove(Move move) {
        moveValidatorStrategy.getMoveValidator().makeMoveValidation(move);
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
