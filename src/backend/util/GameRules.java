package backend.util;

import backend.State;
import backend.actionhelpers.LocationsToFlipCalculation;
import game.impl.*;

import java.util.List;


public class GameRules {

    public static boolean isPlayerOnePiece(GamePiece piece){
        return piece.getId().equals("O");
    }

    public static boolean isPlayerTwoPiece(GamePiece piece){
        return piece.getId().equals("X");
    }

    public static boolean isLocationEmpty(BoardLocation location){
        return location == null || location.getPiece() == null;
    }

    public static BoardLocation getLocationById(Board board, String id){
        List<BoardLocation> locations = board.getLocations();

        for(int i = 0; i < locations.size(); i++)
            if(locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }

    public static boolean doesCurrentPlayerHaveAnyValidMovesLeft(State state){

        List<BoardLocation> allBoardLocations = state.getBoard().getLocations();

        for(int i = 0; i < allBoardLocations.size(); i++) {
            if(isLocationEmpty(allBoardLocations.get(i)))
                if (isLocationValidMoveForCurrentPlayer(state, allBoardLocations.get(i)))
                    return true;

        }

        return false;
    }

    public static boolean isLocationValidMoveForCurrentPlayer(State state, BoardLocation location){
        List<BoardLocation> locationsToFlip = new LocationsToFlipCalculation(state, location, state.getCurrentPlayer()).getLocationsToFlip();
        return locationsToFlip.size() > 0;
    }

}
