package impl;

import game.api.GameState;
import game.impl.*;

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
    public Board getBoard() {
        return gameBoard;
    }

    @Override
    public String getMessage() {
        return message;
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
    public Player getWinner() {
        int playerOneScore = GameRules.getPlayerScore(players.get(0)),
            playerTwoScore = GameRules.getPlayerScore(players.get(1));

        if(playerOneScore > playerTwoScore)
            return players.get(0);
        else if(playerOneScore < playerTwoScore)
            return players.get(1);

        return null;
    }

    @Override
    public Boolean hasEnded() {
        return GameRules.isBoardFull(gameBoard);
    }

    @Override
    public Boolean proposeMove(Move move) {
        if(isValidMove(move)){
            executeMove(move);
            return true;
        }
        return false;
    }

    private boolean isValidMove(Move move){
        if(move.getPlayer() != getPlayerInTurn()){
            message = "It's not your turn!";
            return false;
        }

        if(!GameRules.isLocationEmpty(move.getDestination())){
            message = "There is already a piece in that location!";
            return false;
        }

        if(move.getSource() != null){
            message = "You cannot move a piece already placed on the board";
            return false;
        }

        message = "";
        return true;
    }

    private void executeMove(Move move){
        move.execute();
        new BoardUpdateAction(this, new BoardParser(gameBoard, move.getDestination())).execute();
        turnCounter.increment();
    }

    @Override
    public void reset() {
        gameBoard = factory.createBoard();
        players = factory.createPlayers();
        turnCounter = factory.createTurnCounter(players);
        message = "";
    }


}
