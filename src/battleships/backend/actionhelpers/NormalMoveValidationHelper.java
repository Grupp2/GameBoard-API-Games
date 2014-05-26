package battleships.backend.actionhelpers;

import battleships.backend.Settings;
import battleships.backend.State;
import battleships.backend.classhelpers.BoardHelper;
import game.impl.GamePiece;
import game.impl.Move;

public class NormalMoveValidationHelper implements MoveValidator {
    private State state;
    private BoardHelper boardHelper;

    public NormalMoveValidationHelper(State state, BoardHelper boardHelper) {
        this.state = state;
        this.boardHelper = boardHelper;
    }

    public NormalMoveValidationHelper(State state) {
        this(state, new BoardHelper(state));
    }

    @Override
	public boolean makeMoveValidation(Move move) {
        if(!isShotOnCorrectBoardHalf(move)){
            state.setMessage("You cannot shoot on your own board half");
            return false;
        }
        else if(alreadyShotAtLocation(move)){
            state.setMessage("That location has already been shot at");
            return false;
        }

        return true;
	}

    private boolean isShotOnCorrectBoardHalf(Move move){
        if(isPlayerOneTurn())
            return boardHelper.getPlayerOneBoardHalf().contains(move.getDestination());

        return boardHelper.getPlayerTwoBoardHalf().contains(move.getDestination());
    }

    private boolean alreadyShotAtLocation(Move move){
        GamePiece pieceAtDestination = move.getDestination().getPiece();

        return (pieceAtDestination != null && !isShipPiece(pieceAtDestination));
    }

    private boolean isShipPiece(GamePiece piece){
        return piece.getId().charAt(Settings.PIECE_TYPE_INDEX) == Settings.SHIP_ID;
    }

    private boolean isPlayerOneTurn(){
        return state.getPlayerInTurn() == state.getPlayers().get(Settings.PLAYER_ONE_INDEX);
    }

}
