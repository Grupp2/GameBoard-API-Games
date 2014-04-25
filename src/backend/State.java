package backend;

import java.util.List;

import game.impl.Board;
import game.impl.Player;

public class State {


    private List<Player> players;

    private Board board;

    private String message;

    private int lastPlayerIndex = -1;

    private int currentPlayerIndex = -1;


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
        Player player = null;
        try{
            player = players.get(lastPlayerIndex);
        }
        catch(Exception e){}

        return player;
    }

    public void setLastPlayer(Player player){
        int index = players.indexOf(player);

        if(index == -1)
            throw new RuntimeException("Invalid player");

        this.lastPlayerIndex = index;
    }


    public Player getCurrentPlayer(){
        Player player = null;
        try{
            player = players.get(currentPlayerIndex);
        }
        catch(Exception e){}

        return player;
    }

    public void setCurrentPlayer(Player player){
        int index = players.indexOf(player);

        if(index == -1)
            throw new RuntimeException("Invalid player");

        this.currentPlayerIndex = index;
    }




}
