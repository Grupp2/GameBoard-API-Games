package battleships.backend;

import battleships.backend.actionhelpers.MoveStrategy;
import battleships.backend.actionhelpers.ResetHelper;
import battleships.backend.actionhelpers.TurnCounter;
import game.impl.Move;
import game.impl.Player;

public class GameActionsHandler {
    private State state;
    private MoveStrategy moveStrategy;
    private TurnCounter turnCounter;

    public GameActionsHandler(State state, TurnCounter turnCounter, MoveStrategy moveStrategy) {
        this.state = state;
        this.turnCounter = turnCounter;
        this.moveStrategy = moveStrategy;
    }

    public GameActionsHandler(State state) {
        this.state = state;
        this.turnCounter = new TurnCounter(state);
        this.moveStrategy = new MoveStrategy(state, turnCounter);
    }


    public Player calculateWinner() {
        return null;
    }

    public boolean validateMove(Move move) {
    	return moveStrategy.getMoveValidator().makeMoveValidation(move);
    }

    public void executeMove(Move move) {

        if (turnCounter.getRemainingDeployMoves()==10){
        	Player newPlayer = state.getPlayers().get(Settings.PLAYER_TWO_INDEX);
        	state.setCurrentPlayer(newPlayer);
        }

        moveStrategy.getMoveExecutor().executeMove(move);
    }

    public Boolean hasEndedCheck() {
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
