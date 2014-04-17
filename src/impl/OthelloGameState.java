package impl;

import game.api.GameState;
import game.impl.*;

import java.util.ArrayList;
import java.util.List;

public class OthelloGameState implements GameState {

    private OthelloGameFactory factory;

    private List<Player> players;
    private Board gameBoard;

    private TurnCounter turnCounter;
    private String message;


    public OthelloGameState(OthelloGameFactory factory){
        this.factory = factory;
        reset();
    }

    public OthelloGameState(){
        this(new OthelloGameFactory());
        reset();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Player getLastPlayer() {
        return turnCounter.getLastPlayer();
    }

    @Override
    public Player getPlayerInTurn() {
        return turnCounter.getCurrentPlayer();
    }

    @Override
    public Board getBoard() {
        return gameBoard;
    }

    @Override
    public Boolean hasEnded() {
        return null;
    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public Boolean proposeMove(Move move) {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void reset() {
        gameBoard = factory.createBoard();
        players = factory.createPlayers();
        turnCounter = new TurnCounter(players);
        message = "";
    }
}
