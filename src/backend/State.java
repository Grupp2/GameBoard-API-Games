package backend;

import java.util.List;

import game.impl.Board;
import game.impl.Player;

public class State {


    private List<Player> players;

    private Board board;

    private String message;

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


    public Player getLastPlayer(){
        return lastPlayer;
    }

    public void setLastPlayer(Player player){
        this.lastPlayer = player;
    }


    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player){
        this.currentPlayer = player;
    }




}
