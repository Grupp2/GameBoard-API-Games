package backend.classhelpers;

import backend.State;
import backend.util.BoardParser;
import backend.util.LocationsToFlipCalculation;
import game.impl.BoardLocation;
import game.impl.Player;

import java.util.List;

public class MoveHelper {


    private State state;

    public MoveHelper(State state){
        this.state = state;
    }

    public boolean doesPlayerHaveAnyValidMoves(Player player){
        List<BoardLocation> allBoardLocations = state.getBoard().getLocations();

        for(int i = 0; i < allBoardLocations.size(); i++) {
            if(isLocationEmpty(allBoardLocations.get(i)))
                if (isLocationValidOthelloMoveForPlayer(allBoardLocations.get(i), player))
                    return true;
        }

        return false;
    }

    public List<BoardLocation> getLocationsToFlipFromMove(BoardLocation location, Player player){
        return new LocationsToFlipCalculation(state, player, new BoardParser(state.getBoard(), location)).getLocationsToFlip();
    }

    public boolean isLocationValidOthelloMoveForPlayer(BoardLocation location, Player player){
        return getLocationsToFlipFromMove(location, player).size() > 0;
    }

    private boolean isLocationEmpty(BoardLocation location){
        return location.getPiece() == null;
    }

}
