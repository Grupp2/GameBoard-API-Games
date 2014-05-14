package backend.actionhelpers;

import backend.Settings;
import backend.classhelpers.BoardHelper;
import backend.classhelpers.PlayerHelper;
import backend.OthelloGameFactory;
import backend.State;

import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

public class ResetHelper {

    private State state;
    private OthelloGameFactory factory;
    private BoardHelper boardHelper;
    private PlayerHelper playerHelper;

    public ResetHelper(State state, OthelloGameFactory factory, BoardHelper boardHelper, PlayerHelper playerHelper){
        this.state = state;
        this.factory = factory;
        this.boardHelper = boardHelper;
        this.playerHelper = playerHelper;
    }

    public ResetHelper(State state){
        this(state, new OthelloGameFactory(), new BoardHelper(state), new PlayerHelper(state));
    }


    public void doResetAction(){
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

    public void resetBoard(){
        state.setBoard(factory.createBoard());
    }

    public void resetActionsStack(){
        state.setUndoableActionsStack(factory.createUndoableActionStack());
        state.setLastExecutedActionIndex(factory.createLastExecutedActionIndex());
    }

    public void resetTurn(){
        state.setCurrentPlayer(playerHelper.getPlayerOne());
        state.setLastPlayer(null);
    }

    public void resetMessage(){
        state.setMessage(factory.createStateMessage());
    }

    public void setStartingPositions(){

        GamePiece playerOnePiece1 = factory.createPlayerOnePiece();
        GamePiece playerOnePiece2 = factory.createPlayerOnePiece();
        GamePiece playerTwoPiece1 = factory.createPlayerTwoPiece();
        GamePiece playerTwoPiece2 = factory.createPlayerTwoPiece();

        Player playerOne = playerHelper.getPlayerOne();
        Player playerTwo = playerHelper.getPlayerTwo();

        BoardLocation playerOneStartLocation1 = boardHelper.getLocationById(Settings.PLAYER_ONE_START_POSITION_1);
        BoardLocation playerOneStartLocation2 = boardHelper.getLocationById(Settings.PLAYER_ONE_START_POSITION_2);
        BoardLocation playerTwoStartLocation1 = boardHelper.getLocationById(Settings.PLAYER_TWO_START_POSITION_1);
        BoardLocation playerTwoStartLocation2 = boardHelper.getLocationById(Settings.PLAYER_TWO_START_POSITION_2);


        playerOneStartLocation1.setPiece(playerOnePiece1);
        playerOne.getPieces().add(playerOnePiece1);

        playerOneStartLocation2.setPiece(playerOnePiece2);
        playerOne.getPieces().add(playerOnePiece2);

        playerTwoStartLocation1.setPiece(playerTwoPiece1);
        playerTwo.getPieces().add(playerTwoPiece1);

        playerTwoStartLocation2.setPiece(playerTwoPiece2);
        playerTwo.getPieces().add(playerTwoPiece2);
    }
}
