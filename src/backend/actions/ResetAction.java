package backend.actions;


import backend.undoableactions.UndoableAction;
import game.impl.Board;
import game.impl.GamePiece;
import game.impl.Player;
import backend.OthelloGameFactory;
import backend.State;
import backend.util.GameRules;

import java.util.ArrayList;
import java.util.List;

public class ResetAction {

    private State state;
    private OthelloGameFactory factory;

    public ResetAction(State state, OthelloGameFactory factory){
        this.state = state;
        this.factory = factory;
    }

    public ResetAction(State state){
        this(state, new OthelloGameFactory());
    }

    public void execute(){
        resetPlayers();
        resetBoard();
        resetTurn();
        resetActionsStack();
        resetMessage();

        setStartingPositions();
    }

    private void resetPlayers(){
        state.setPlayers(factory.createPlayers());
    }

    private void resetTurn(){
        state.setCurrentPlayer(state.getPlayers().get(0));
        state.setLastPlayer(null);
    }

    private void resetBoard(){
        state.setBoard(factory.createBoard());
    }

    private void resetActionsStack(){
        state.setUndoableActionsStack(new ArrayList<UndoableAction>());
        state.setLastExecutedActionIndex(-1);
    }

    private void resetMessage(){
        state.setMessage("");
    }

    private void setStartingPositions(){

        List<Player> players = state.getPlayers();
        Board gameBoard = state.getBoard();

        GamePiece piece1 = new GamePiece("O"),
                piece2 = new GamePiece("O"),
                piece3 = new GamePiece("X"),
                piece4 = new GamePiece("X");

        GameRules.getLocationById(gameBoard, "D5").setPiece(piece1);
        players.get(0).getPieces().add(piece1);

        GameRules.getLocationById(gameBoard, "E4").setPiece(piece2);
        players.get(0).getPieces().add(piece2);

        GameRules.getLocationById(gameBoard, "D4").setPiece(piece3);
        players.get(1).getPieces().add(piece3);

        GameRules.getLocationById(gameBoard, "E5").setPiece(piece4);
        players.get(1).getPieces().add(piece4);
    }
}
