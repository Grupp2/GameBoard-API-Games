package backend;

import java.util.List;

import game.impl.Board;
import game.impl.Player;

public class State {


    private List<Player> players;

    private Board board;

    private String message;

    private int lastPlayerIndex;

    private int currentPlayerIndex;


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


    public int getLastPlayerIndex() {
        return lastPlayerIndex;
    }

    public void setLastPlayerIndex(int index){
        this.lastPlayerIndex = index;
    }


    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int index){
        this.currentPlayerIndex = index;
    }




}
