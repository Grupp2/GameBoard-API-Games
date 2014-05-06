package backend.actionhelpers;

import backend.State;
import backend.util.GameRules;

public class GameoverCheckHelper {

    private State state;

    public GameoverCheckHelper(State state){
        this.state = state;
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
        return !GameRules.doesCurrentPlayerHaveAnyValidMovesLeft(state);
    }
}
