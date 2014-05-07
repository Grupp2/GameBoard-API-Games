package backend.actionhelpers;


import backend.State;
import game.impl.BoardLocation;

public class BoardHelper {

    private State state;

    public BoardHelper(State state){
        this.state = state;
    }

    public BoardLocation getLocationById(String id){
        return null;
    }

    public boolean isLocationEmpty(BoardLocation location){
        return location.getPiece() == null;
    }
}
