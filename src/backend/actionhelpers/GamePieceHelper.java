package backend.actionhelpers;

import backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import java.util.List;

public class GamePieceHelper {

    private State state;

    public static final String PLAYER_ONE_PIECEID = "O";
    public static final String PLAYER_TWO_PIECEID = "X";

    public GamePieceHelper(State state){
        this.state = state;
    }

    public Player getOwnerOfPiece(GamePiece piece){
        if(state.getPlayers().get(0).hasPiece(piece))
            return state.getPlayers().get(0);

        return state.getPlayers().get(1);
    }

    public void changeOwnerOfPiece(GamePiece piece){
        BoardLocation location = getLocationOfPiece(piece);
        Player newOwner, oldOwner = getOwnerOfPiece(piece);
        String newPieceId;


        if(oldOwner == state.getPlayers().get(0)){
            newOwner = state.getPlayers().get(1);
            newPieceId = PLAYER_TWO_PIECEID;
        }
        else{
            newOwner = state.getPlayers().get(0);
            newPieceId = PLAYER_ONE_PIECEID;
        }

        oldOwner.getPieces().remove(piece);
        piece = new GamePiece(newPieceId);
        newOwner.getPieces().add(piece);
        location.setPiece(piece);
    }

    public BoardLocation getLocationOfPiece(GamePiece piece){
        List<BoardLocation> locations = state.getBoard().getLocations();

        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).getPiece() == piece)
                return locations.get(i);
        }

        return new BoardLocation("Null location");
    }
}
