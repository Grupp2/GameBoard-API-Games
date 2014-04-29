package backend.actions;


import backend.State;
import backend.util.GameRules;
import game.impl.BoardLocation;

import java.util.List;

public class HasEndedControl {

    private State state;

    public HasEndedControl(State state){
        this.state = state;
    }

    public boolean execute(){
        if(isBoardFull())
            return true;

        if(doesAnyPlayerNotHaveAnyPiecesLeft())
            return true;

        if(!GameRules.doesCurrentPlayerHaveAnyValidMovesLeft(state))
            return true;

        return false;
    }

    private boolean isBoardFull(){
        int playerOnePieceCount = state.getPlayers().get(0).getPieces().size();
        int playerTwoPieceCount = state.getPlayers().get(1).getPieces().size();

        return playerOnePieceCount + playerTwoPieceCount >= 64;
    }

    private boolean doesAnyPlayerNotHaveAnyPiecesLeft(){
        int playerOnePieceCount = state.getPlayers().get(0).getPieces().size();
        int playerTwoPieceCount = state.getPlayers().get(1).getPieces().size();

        return playerOnePieceCount == 0 || playerTwoPieceCount == 0;
    }
}
