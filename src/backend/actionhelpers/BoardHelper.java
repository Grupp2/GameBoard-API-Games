package backend.actionhelpers;


import backend.State;
import game.impl.BoardLocation;

import java.util.List;

public class BoardHelper {

    private State state;

    public BoardHelper(State state){
        this.state = state;
    }

    public BoardLocation getLocationById(String id){
        List<BoardLocation> locations = state.getBoard().getLocations();

        for(int i = 0; i < locations.size(); i++)
            if(locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }

    public boolean isLocationEmpty(BoardLocation location){
        return location.getPiece() == null;
    }
}
