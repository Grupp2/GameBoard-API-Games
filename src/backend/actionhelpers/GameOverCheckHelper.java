package backend.actionhelpers;

import backend.State;
import backend.classhelpers.MoveHelper;

public class GameOverCheckHelper {

    private State state;

    private MoveHelper moveHelper;

    public GameOverCheckHelper(State state, MoveHelper moveHelper){
        this.state = state;
        this.moveHelper = moveHelper;
    }

    public GameOverCheckHelper(State state){
        this(state, new MoveHelper(state));
    }

    public boolean makeGameOverCheck(){
        if(isBoardFull())
            return true;

        if(doesAnyPlayerNotHaveAnyPiecesLeft())
            return true;

        if(isCurrentPlayerOutOfValidMoves())
            return true;

        return false;
    }

    public boolean isBoardFull(){
        int playerOnePieceCount = state.getPlayers().get(0).getPieces().size();
        int playerTwoPieceCount = state.getPlayers().get(1).getPieces().size();

        return playerOnePieceCount + playerTwoPieceCount >= 64;
    }

    public boolean doesAnyPlayerNotHaveAnyPiecesLeft(){
        int playerOnePieceCount = state.getPlayers().get(0).getPieces().size();
        int playerTwoPieceCount = state.getPlayers().get(1).getPieces().size();

        return playerOnePieceCount == 0 || playerTwoPieceCount == 0;
    }

    public boolean isCurrentPlayerOutOfValidMoves(){
        return !moveHelper.doesPlayerHaveAnyValidMoves(state.getCurrentPlayer());
    }
}
