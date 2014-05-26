package battleships.backend.classhelpers;

import battleships.backend.State;
import game.impl.BoardLocation;
import battleships.backend.Settings;

import java.util.List;

public class BoardHelper {

    private State state;

    public BoardHelper(State state){
        this.state = state;
    }

    public List<BoardLocation> getPlayerOneBoardHalf(){
        return state.getBoard().getLocations().subList(0, 100);
    }

    public List<BoardLocation> getPlayerTwoBoardHalf(){
        return state.getBoard().getLocations().subList(100, 200);
    }

    public BoardLocation findDeployPieceLocation(){
        List<BoardLocation> locations = state.getBoard().getLocations();

        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).getPiece() != null)
                if(locations.get(i).getPiece().getId().equals(Settings.DEPLOY_PIECE_ID))
                    return locations.get(i);
        }

        return null;
    }

}
