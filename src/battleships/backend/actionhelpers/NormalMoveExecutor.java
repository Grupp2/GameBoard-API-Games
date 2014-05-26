package battleships.backend.actionhelpers;

import battleships.backend.Settings;
import battleships.backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;

import java.util.List;


public class NormalMoveExecutor implements MoveExecutor {
    private State state;

    public NormalMoveExecutor(State state) {
        this.state = state;
    }

    @Override
    public void executeMove(Move move) {

        if(isDestinationEmpty(move)){
            state.setMessage("You missed!");
            move.getDestination().setPiece(new GamePiece(Settings.PIECE_MISS_ID));
            incrementTurn();
        }
        else if(isShipAtDestination(move)){
            state.setMessage("You hit a ship!");
            move.getDestination().setPiece(new GamePiece(Settings.PIECE_HIT_ID));
            incrementTurn();
        }
        else
            throw new RuntimeException("Invalid move");

    }

    private boolean isDestinationEmpty(Move move){
        return move.getDestination().getPiece() == null;
    }

    private boolean isShipAtDestination(Move move){
        GamePiece piece = move.getDestination().getPiece();
        return piece.getId().charAt(Settings.PIECE_TYPE_INDEX) == Settings.SHIP_ID;
    }

    private void incrementTurn(){
        if(isPlayerOneTurn())
            state.setCurrentPlayer(state.getPlayers().get(Settings.PLAYER_TWO_INDEX));

        else
            state.setCurrentPlayer(state.getPlayers().get(Settings.PLAYER_ONE_INDEX));
    }

    private boolean isPlayerOneTurn(){
        return state.getPlayerInTurn() == state.getPlayers().get(Settings.PLAYER_ONE_INDEX);
    }
}
