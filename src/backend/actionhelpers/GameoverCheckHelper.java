package backend.actionhelpers;

import backend.State;
import backend.util.GameRules;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;

import java.util.List;

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
        List<BoardLocation> allBoardLocations = state.getBoard().getLocations();

        for(int i = 0; i < allBoardLocations.size(); i++) {
            if(isLocationValidMoveForCurrentPlayer(state, allBoardLocations.get(i)))
                return false;

        }

        return true;
    }

    private boolean isLocationValidMoveForCurrentPlayer(State state, BoardLocation location){
        Move move = new Move(state.getCurrentPlayer(), new GamePiece(""), location);
        MoveValidator validator = new MoveValidator(state, move);

        return validator.isDestinationEmpty() && validator.isValidOthelloMove();
    }
}
