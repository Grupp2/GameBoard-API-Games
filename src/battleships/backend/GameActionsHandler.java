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
	    this(state, new TurnCounter(state), new MoveStrategy(state));
    }
    
    public GameActionsHandler(State state, TurnCounter turnCounter) {
    	this(state, turnCounter, new MoveStrategy(state));
    }
    
    public GameActionsHandler(State state, TurnCounter turnCounter, MoveStrategy moveStrategy) {
    	this.state = state;
	    this.turnCounter = turnCounter;
        this.moveStrategy = moveStrategy;
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
        if (turnCounter.getRemainingDeployMoves()==10){
        	Player tmp = null;
        	for (int i = 0; i < state.getPlayers().size(); i++)
        		if (state.getPlayers().get(i).getName().equals(Settings.PLAYER_TWO_NAME))
        			tmp = state.getPlayers().get(i);
        	state.setCurrentPlayer(tmp);
        }
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

    public int getDeployMovesRemaining() {
        return turnCounter.getRemainingDeployMoves();
    }
}
