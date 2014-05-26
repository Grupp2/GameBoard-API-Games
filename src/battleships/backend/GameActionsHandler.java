package battleships.backend;

import battleships.backend.actionhelpers.MoveStrategy;
import battleships.backend.actionhelpers.ResetHelper;
import battleships.backend.actionhelpers.TurnCounter;
import battleships.backend.actionhelpers.WinnerCalculation;
import game.impl.Move;
import game.impl.Player;

public class GameActionsHandler {
    private State state;
    private MoveStrategy moveStrategy;
    private TurnCounter turnCounter;
    private WinnerCalculation winnerCalc;
    public GameActionsHandler(State state, TurnCounter turnCounter, MoveStrategy moveStrategy) {
        this.state = state;
        this.turnCounter = turnCounter;
        this.moveStrategy = moveStrategy;
        this.winnerCalc = new WinnerCalculation(state);
    }

    public GameActionsHandler(State state) {
        this.state = state;
        this.turnCounter = new TurnCounter(state);
        this.moveStrategy = new MoveStrategy(state, turnCounter);
        this.winnerCalc = new WinnerCalculation(state);
    }


    public Player calculateWinner() {
        return winnerCalc.getWinner();
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
        return winnerCalc.isGameOver();
    }

    public void reset() {
        ResetHelper resetHelper = new ResetHelper(state);
        resetHelper.reset();
    }

    public int getDeployMovesRemaining() {
        return turnCounter.getRemainingDeployMoves();
    }
}
