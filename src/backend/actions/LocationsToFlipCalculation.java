package backend.actions;


import backend.State;
import backend.util.BoardParser;
import backend.util.GameRules;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import java.util.ArrayList;
import java.util.List;

public class LocationsToFlipCalculation {

    private State state;
    private BoardLocation location;
    private Player currentPlayer;
    private List<BoardLocation> locations = new ArrayList<BoardLocation>();
    private BoardParser boardParser;

    public LocationsToFlipCalculation(State state, BoardLocation location, Player currentPlayer){
        this.state = state;
        this.location = location;
        this.currentPlayer = currentPlayer;
        boardParser = new BoardParser(state.getBoard(), location);
    }

    public List<BoardLocation> execute(){
        parsePartial(boardParser.getRow());
        parsePartial(boardParser.getColumn());
        parsePartial(boardParser.getLeftToRightDiagonal());
        parsePartial(boardParser.getRightToLeftDiagonal());

        return locations;
    }

    private void parsePartial(List<BoardLocation> partialList){
        int locationIndex = partialList.indexOf(location);

        int backWardsIndex = getBackwardsUpdateIndex(partialList, locationIndex);
        for(int i = locationIndex - 1; i >= backWardsIndex; i--)
            locations.add(partialList.get(i));

        int forwardIndex = getForwardUpdateIndex(partialList, locationIndex);
        for(int i = locationIndex + 1; i <= forwardIndex; i++)
            locations.add(partialList.get(i));
    }

    private int getBackwardsUpdateIndex(List<BoardLocation> list, int startIndex){

        for(int i = startIndex-1; i >= 0; i-- ){

            if(GameRules.isLocationEmpty(list.get(i)))
                return startIndex;

            if(getOwnerOfPiece(list.get(i).getPiece()) == currentPlayer)
                return i+1;
        }


        return startIndex;
    }

    private int getForwardUpdateIndex(List<BoardLocation> list, int startIndex){

        for(int i = startIndex+1; i < list.size(); i++) {
            if (GameRules.isLocationEmpty(list.get(i)))
                return startIndex;

            if (getOwnerOfPiece(list.get(i).getPiece()) == currentPlayer)
                return i-1;

        }

        return startIndex;
    }

    private Player getOwnerOfPiece(GamePiece piece){
        if(GameRules.isPlayerOnePiece(piece))
            return state.getPlayers().get(0);

        return state.getPlayers().get(1);
    }


}
