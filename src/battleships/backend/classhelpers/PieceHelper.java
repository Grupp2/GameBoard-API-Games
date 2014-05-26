package battleships.backend.classhelpers;


import battleships.backend.Settings;
import battleships.backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;

import java.util.ArrayList;
import java.util.List;

public class PieceHelper {

    private State state;

    public PieceHelper(State state){
        this.state = state;
    }

    public List<GamePiece> findShipsOnLocations(List<BoardLocation> locations){
        List<GamePiece> piecesFound = new ArrayList<>();

        for(int i = 0; i < locations.size(); i++){
            GamePiece shipPiece = locations.get(i).getPiece();
            if(shipPiece != null && isShipPiece(shipPiece) && !piecesFound.contains(shipPiece))
                piecesFound.add(shipPiece);
        }

        return piecesFound;
    }

    public boolean isShipPiece(GamePiece piece){
        return piece.getId().charAt(Settings.PIECE_TYPE_INDEX) == Settings.SHIP_ID;
    }
}
