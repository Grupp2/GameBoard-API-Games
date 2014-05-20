package battleships.backend;

import game.api.GameState;
import game.impl.Board;
import game.impl.DieRollFactory;
import game.impl.Move;
import game.impl.Player;

import java.util.List;

/**
 * Created by hugg on 2014-05-20.
 */
public class BattleShipsGameFacade implements GameState {
    private GameActionsHandler gameActionsHandler;
    private State state;

    public BattleShipsGameFacade() {
        this.state = new State();
        gameActionsHandler = new GameActionsHandler(state);

    }
    @Override
    public List<Player> getPlayers() {
        return state.getPlayers();
    }

    @Override
    public Player getLastPlayer() {
        return state.getLastPlayer();
    }

    @Override
    public Player getPlayerInTurn() {
        return state.getCurrentPlayer();
    }

    @Override
    public Board getBoard() {
        return state.getBoard();
    }

    @Override
    public Boolean hasEnded() {
        return gameActionsHandler.hasEndedCheck();
    }

    @Override
    public Player getWinner() {
        return gameActionsHandler.calculateWinner();
    }

    @Override
    public Boolean proposeMove(Move move) {
        if (gameActionsHandler.validateMove(move)) {
            gameActionsHandler.executeMove(move);
            return true;
        }
        return false;
    }

    @Override
    public String getMessage() {
        return state.getMessage();
    }

    @Override
    public DieRollFactory getDieRollFactory() {
        return null;
    }

    @Override
    public void reset() {
        gameActionsHandler.reset();
    }
}
