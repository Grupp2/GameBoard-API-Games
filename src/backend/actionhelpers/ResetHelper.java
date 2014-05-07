package backend.actionhelpers;

import backend.Settings;
import backend.classhelpers.BoardHelper;
import backend.undoableactions.UndoableAction;
import backend.OthelloGameFactory;
import backend.State;

import game.impl.GamePiece;
import game.impl.Player;

import java.util.ArrayList;
import java.util.List;

public class ResetHelper {

    private State state;
    private OthelloGameFactory factory;
    private BoardHelper boardHelper;

    public ResetHelper(State state, OthelloGameFactory factory, BoardHelper boardHelper){
        this.state = state;
        this.factory = factory;
        this.boardHelper = boardHelper;
    }

    public ResetHelper(State state){
        this(state, new OthelloGameFactory(), new BoardHelper(state));
    }

    public void reset(){
        resetPlayers();
        resetBoard();
        resetTurn();
        resetActionsStack();
        resetMessage();

        setStartingPositions();
    }

    public void resetPlayers(){
        state.setPlayers(factory.createPlayers());
    }

    public void resetTurn(){
        state.setCurrentPlayer(state.getPlayers().get(0));
        state.setLastPlayer(null);
    }

    public void resetBoard(){
        state.setBoard(factory.createBoard());
    }

    public void resetActionsStack(){
        state.setUndoableActionsStack(new ArrayList<UndoableAction>());
        state.setLastExecutedActionIndex(-1);
    }

    public void resetMessage(){
        state.setMessage("");
    }

    public void setStartingPositions(){

        List<Player> players = state.getPlayers();
        GamePiece piece1 = new GamePiece(Settings.PLAYER_ONE_PIECE_ID),
                piece2 = new GamePiece(Settings.PLAYER_ONE_PIECE_ID),
                piece3 = new GamePiece(Settings.PLAYER_TWO_PIECE_ID),
                piece4 = new GamePiece(Settings.PLAYER_TWO_PIECE_ID);

        boardHelper.getLocationById(Settings.PLAYER_ONE_START_POSITION_1).setPiece(piece1);
        players.get(0).getPieces().add(piece1);

        boardHelper.getLocationById(Settings.PLAYER_ONE_START_POSITION_2).setPiece(piece2);
        players.get(0).getPieces().add(piece2);

        boardHelper.getLocationById(Settings.PLAYER_TWO_START_POSITION_1).setPiece(piece3);
        players.get(1).getPieces().add(piece3);

        boardHelper.getLocationById(Settings.PLAYER_TWO_START_POSITION_2).setPiece(piece4);
        players.get(1).getPieces().add(piece4);
    }
}
