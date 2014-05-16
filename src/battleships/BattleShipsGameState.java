package battleships;

import java.util.List;

import game.api.GameState;
import game.impl.Board;
import game.impl.DieRollFactory;
import game.impl.Move;
import game.impl.Player;
import battleships.backend.State;

public class BattleShipsGameState implements GameState {
    private State state;
    
    
    public BattleShipsGameState() {
	state = new State();
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
	return state.getCurrentPlayer();
    }

    @Override
    public List<Player> getPlayers() {
	return state.getPlayers();
    }

    @Override
    public Player getWinner() {
	return null;
    }

    @Override
    public Boolean hasEnded() {
	return null;
    }

    @Override
    public Boolean proposeMove(Move move) {
	return null;
    }

    @Override
    public void reset() {
	
    }
    
    public boolean getIsDeployMode() {
	return state.isDeployMode();
    }

}
