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

    private List<UndoableAction> undoableActionsStack;

    private int lastExecutedActionIndex;


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


    public void setUndoableActionsStack(List<UndoableAction> undoableActionsStack){
        this.undoableActionsStack = undoableActionsStack;
    }

    public List<UndoableAction> getUndoableActionsStack(){
        return undoableActionsStack;
    }


    public void setLastExecutedActionIndex(int lastExecutedActionIndex){
        this.lastExecutedActionIndex = lastExecutedActionIndex;
    }

    public int getLastExecutedActionIndex(){
        return lastExecutedActionIndex;
    }


    public void pushActionOnUndoStack(UndoableAction action){
        for(int i = undoableActionsStack.size(); i > lastExecutedActionIndex; i--){
            undoableActionsStack.remove(i);
        }

        undoableActionsStack.add(action);
        lastExecutedActionIndex++;
    }

    public void undo(){
        if(lastExecutedActionIndex < 0)
            throw new RuntimeException("No more undoableActionsStack to undo!");

        undoableActionsStack.get(lastExecutedActionIndex--).undo();
    }

    public void redo(){
        if(lastExecutedActionIndex >= undoableActionsStack.size()-1)
            throw new RuntimeException("No more undoableActionsStack to redo!");

        undoableActionsStack.get(++lastExecutedActionIndex).execute();
    }
}
