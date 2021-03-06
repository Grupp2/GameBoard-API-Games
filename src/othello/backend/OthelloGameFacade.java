package othello.backend;

import game.api.GameState;
import game.impl.Board;
import game.impl.DieRollFactory;
import game.impl.Move;
import game.impl.Player;

import java.util.List;

public class OthelloGameFacade implements GameState{

    private State state;
    private GameActionsHandler gameActionsHandler;

    public OthelloGameFacade(State state, GameActionsHandler gameActionsHandler){
        this.state = state;
        this.gameActionsHandler = gameActionsHandler;
    }

    public OthelloGameFacade(){
        this.state = new State();
        this.gameActionsHandler = new GameActionsHandler(this.state);
    }

    @Override
    public List<Player> getPlayers() {
        return state.getPlayers();
    }

    @Override
    public Board getBoard() {
        return state.getBoard();
    }

    @Override
    public String getMessage() {
        return state.getMessage();
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
    public DieRollFactory getDieRollFactory() {
        return null;
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
        if(!gameActionsHandler.validateMove(move))
            return false;

        gameActionsHandler.executeMove(move);
        return true;
    }

    @Override
    public void reset() {
        gameActionsHandler.reset();
    }

    public boolean canUndo(){
        return state.getLastExecutedActionIndex() > -1;
    }

    public void undo(){
        if(!canUndo())
            state.setMessage("No moves to undo!");
        else
            gameActionsHandler.undo();
    }
}
