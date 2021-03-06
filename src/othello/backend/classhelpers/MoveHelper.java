package othello.backend.classhelpers;

import othello.backend.State;
import othello.backend.util.BoardParser;
import othello.backend.util.LocationsToFlipCalculation;
import game.impl.BoardLocation;
import game.impl.Player;

import java.util.List;

public class MoveHelper {


    private State state;

    private BoardHelper boardHelper;

    public MoveHelper(State state, BoardHelper boardHelper){
        this.state = state;
        this.boardHelper = boardHelper;
    }

    public MoveHelper(State state){
        this(state, new BoardHelper(state));
    }


    public boolean doesPlayerHaveAnyValidMoves(Player player){
        List<BoardLocation> allBoardLocations = state.getBoard().getLocations();

        for(int i = 0; i < allBoardLocations.size(); i++) {
            if(boardHelper.isLocationEmpty(allBoardLocations.get(i)))
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

}
