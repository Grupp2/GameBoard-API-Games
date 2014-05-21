package battleships.backend;

import battleships.backend.actionhelpers.MoveStrategy;
import battleships.backend.actionhelpers.ResetHelper;
import battleships.backend.actionhelpers.TurnCounter;
import game.impl.Move;
import game.impl.Player;

public class GameActionsHandler {
    private State state;
    private MoveStrategy moveStrategy;
    private Move firstDeployMove;
    private TurnCounter turnCounter;
    
    public GameActionsHandler(State state) {
	    this.state = state;
	    this.turnCounter = new TurnCounter(state);
        this.moveStrategy = new MoveStrategy(state);
    }

    public Player calculateWinner() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean validateMove(Move move) {
    	boolean result = moveStrategy.getMoveValidator().makeMoveValidation(move, firstDeployMove);
    	if (!result && firstDeployMove==null)
    		firstDeployMove = move;
        return result;
    }

    public void executeMove(Move move) {
        moveStrategy.getMoveExecutor().executeMove(move, firstDeployMove);
        turnCounter.decrementMoveCounter();
        firstDeployMove = null;
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
