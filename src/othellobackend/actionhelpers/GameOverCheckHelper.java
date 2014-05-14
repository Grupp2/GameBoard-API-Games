package othellobackend.actionhelpers;

import othellobackend.State;
import othellobackend.classhelpers.MoveHelper;
import othellobackend.classhelpers.PlayerHelper;

public class GameOverCheckHelper {

    private State state;
    private MoveHelper moveHelper;
    private PlayerHelper playerHelper;

    public GameOverCheckHelper(State state, MoveHelper moveHelper, PlayerHelper playerHelper){
        this.state = state;
        this.moveHelper = moveHelper;
        this.playerHelper = playerHelper;
    }

    public GameOverCheckHelper(State state){
        this(state, new MoveHelper(state), new PlayerHelper(state));
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
        int playerOnePieceCount = playerHelper.getPlayerOne().getPieces().size();
        int playerTwoPieceCount = playerHelper.getPlayerTwo().getPieces().size();

        return playerOnePieceCount + playerTwoPieceCount >= 64;
    }

    public boolean doesAnyPlayerNotHaveAnyPiecesLeft(){
        int playerOnePieceCount = playerHelper.getPlayerOne().getPieces().size();
        int playerTwoPieceCount = playerHelper.getPlayerTwo().getPieces().size();

        return playerOnePieceCount == 0 || playerTwoPieceCount == 0;
    }

    public boolean isCurrentPlayerOutOfValidMoves(){
        return !moveHelper.doesPlayerHaveAnyValidMoves(state.getCurrentPlayer());
    }
}
