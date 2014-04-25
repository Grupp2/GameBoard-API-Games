package backend;

import game.impl.Board;
import game.impl.Player;
import backend.util.TurnCounter;

import java.util.List;

public class State {


    private List<Player> players;

    private Board board;

    private String message;

    private TurnCounter turnCounter;

    private Player lastPlayer;

    private Player currentPlayer;


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


    public Player getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(Player player){
        this.lastPlayer = player;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player){
        this.currentPlayer = player;
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
