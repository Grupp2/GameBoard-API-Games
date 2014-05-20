package battleships;

import java.util.List;

import game.api.GameState;
import game.impl.Board;
import game.impl.DieRollFactory;
import game.impl.Move;
import game.impl.Player;
import battleships.backend.GameActionsHandler;
import battleships.backend.State;

public class BattleShipsGameState implements GameState {
    private State state;
    private GameActionsHandler handler;
    
    
    public BattleShipsGameState() {
	    state = new State();
	    handler = new GameActionsHandler(state);
    }
    
    @Override
    public Board getBoard() {
	    return state.getBoard();
    }

    @Override
    public DieRollFactory getDieRollFactory() {
	    return null;
    }

    @Override
    public Player getLastPlayer() {
	    return state.getLastPlayer();
    }

    @Override
    public String getMessage() {
	    return state.getMessage();
    }

    @Override
    public Player getPlayerInTurn() {
	    return state.getPlayerInTurn();
    }

    @Override
    public List<Player> getPlayers() {
	    return state.getPlayers();
    }

    @Override
    public Player getWinner() {
	    return handler.calculateWinner();
    }

    @Override
    public Boolean hasEnded() {
	    return handler.hasEndedCheck();
    }

    @Override
    public Boolean proposeMove(Move move) {
	    if(!handler.validateMove(move))
            return false;

        handler.executeMove(move);
        return true;
    }

    @Override
    public void reset() {
	    handler.reset();
    }
    
    public boolean getIsDeployMode() {
	    return state.isDeployMode();
    }

}
