package backend.util;

import game.impl.*;

import java.util.List;


public class GameRules {

    public static BoardLocation getLocationById(Board board, String id){
        List<BoardLocation> locations = board.getLocations();

        for(int i = 0; i < locations.size(); i++)
            if(locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }

}
