package impl;

import game.impl.Board;
import game.impl.Player;
import impl.util.TurnCounter;

import java.util.List;

public class State {


    private List<Player> players;

    private Board board;

    private String message;

    private TurnCounter turnCounter;


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board){
        this.board = board;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }


    public TurnCounter getTurnCounter(){
        return turnCounter;
    }

    public void setTurnCounter(TurnCounter turnCounter){
        this.turnCounter = turnCounter;
    }


    public Player getLastPlayer() {
        return turnCounter.getLastPlayer();
    }

    public Player getCurrentPlayer() {
        return turnCounter.getCurrentPlayer();
    }


    public Boolean hasEnded() {
        return players.get(0).getPieces().size() + players.get(1).getPieces().size() >= 64;
    }

    public Player getWinner() {

        int playerOneScore = players.get(0).getPieces().size();
        int playerTwoScore = players.get(1).getPieces().size();

        if(playerOneScore > playerTwoScore)
            return players.get(0);
        else if(playerOneScore < playerTwoScore)
            return players.get(1);

        return null;
    }




}
