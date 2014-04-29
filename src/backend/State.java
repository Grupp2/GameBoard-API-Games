package backend;

import java.util.List;

import backend.undoableactions.UndoableAction;
import game.impl.Board;
import game.impl.Player;

public class State {

    private List<Player> players;

    private Board board;

    private String message;

    private Player lastPlayer;

    private Player currentPlayer;

    private List<UndoableAction> actions;

    private int currentActionIndex;


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


    public void setActions(List<UndoableAction> actions){
        this.actions = actions;
    }

    public List<UndoableAction> getActions(){
        return actions;
    }


    public void setCurrentActionIndex(int currentActionIndex){
        this.currentActionIndex = currentActionIndex;
    }

    public int getCurrentActionIndex(){
        return currentActionIndex;
    }


    public void pushAction(UndoableAction action){
        for(int i = actions.size(); i > 1+currentActionIndex; i--){
            actions.remove(i);
        }

        actions.add(action);
        currentActionIndex++;
    }

    public void undo(){
        if(currentActionIndex < 0)
            throw new RuntimeException("No more actions to undo!");

        actions.get(currentActionIndex--).undo();
    }

    public void redo(){
        if(currentActionIndex >= actions.size())
            throw new RuntimeException("No more actions to redo!");

        actions.get(currentActionIndex++).execute();
    }
}
