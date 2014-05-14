package othello.backend.classhelpers;

import othello.backend.Settings;
import othello.backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import java.util.List;

public class GamePieceHelper {

    private State state;
    private PlayerHelper playerHelper;

    public GamePieceHelper(State state, PlayerHelper playerHelper){
        this.state = state;
        this.playerHelper = playerHelper;
    }

    public GamePieceHelper(State state){
        this(state, new PlayerHelper(state));
    }


    public Player getOwnerOfPiece(GamePiece piece){
        if(playerHelper.getPlayerOne().hasPiece(piece))
            return playerHelper.getPlayerOne();

        return playerHelper.getPlayerTwo();
    }

    public void changeOwnerOfPiece(GamePiece piece){
        BoardLocation location = getLocationOfPiece(piece);
        Player newOwner, oldOwner = getOwnerOfPiece(piece);
        String newPieceId;


        if(oldOwner == playerHelper.getPlayerOne()){
            newOwner = playerHelper.getPlayerTwo();
            newPieceId = Settings.PLAYER_TWO_PIECE_ID;
        }
        else{
            newOwner = playerHelper.getPlayerOne();
            newPieceId = Settings.PLAYER_ONE_PIECE_ID;
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
