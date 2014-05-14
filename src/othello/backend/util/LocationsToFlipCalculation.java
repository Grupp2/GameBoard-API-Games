package othello.backend.util;

import othello.backend.State;
import othello.backend.classhelpers.BoardHelper;
import othello.backend.classhelpers.GamePieceHelper;
import game.impl.BoardLocation;
import game.impl.Player;

import java.util.ArrayList;
import java.util.List;

public class LocationsToFlipCalculation {

    private BoardLocation location;
    private Player thePlayer;

    private GamePieceHelper pieceHelper;
    private BoardHelper boardHelper;
    private BoardParser boardParser;

    private List<BoardLocation> locations = new ArrayList<BoardLocation>();

    public LocationsToFlipCalculation(Player thePlayer, GamePieceHelper pieceHelper, BoardParser boardParser, BoardHelper boardHelper){
        this.location = boardParser.getLocation();
        this.thePlayer = thePlayer;

        this.boardParser = boardParser;

        this.pieceHelper = pieceHelper;
        this.boardHelper = boardHelper;
    }

    public LocationsToFlipCalculation(State state, Player thePlayer, BoardParser parser){
        this(thePlayer, new GamePieceHelper(state), parser, new BoardHelper(state));
    }


    public List<BoardLocation> getLocationsToFlip(){
        parsePartial(boardParser.getRow());
        parsePartial(boardParser.getColumn());
        parsePartial(boardParser.getLeftToRightDiagonal());
        parsePartial(boardParser.getRightToLeftDiagonal());

        return locations;
    }

    private void parsePartial(List<BoardLocation> partialList){
        int locationIndex = partialList.indexOf(location);

        int backWardsIndex = getHowFarWeShouldUpdateBackward(partialList, locationIndex);
        for(int i = locationIndex - 1; i >= backWardsIndex; i--)
            locations.add(partialList.get(i));

        int forwardIndex = getHowFarWeShouldUpdateForward(partialList, locationIndex);
        for(int i = locationIndex + 1; i <= forwardIndex; i++)
            locations.add(partialList.get(i));
    }

    private int getHowFarWeShouldUpdateBackward(List<BoardLocation> list, int startIndex){

        for(int i = startIndex-1; i >= 0; i-- ){
            if(boardHelper.isLocationEmpty(list.get(i)))
                return startIndex;

            if(pieceHelper.getOwnerOfPiece(list.get(i).getPiece()) == thePlayer)
                return i+1;
        }

        return startIndex;
    }

    private int getHowFarWeShouldUpdateForward(List<BoardLocation> list, int startIndex){

        for(int i = startIndex+1; i < list.size(); i++) {
            if (boardHelper.isLocationEmpty(list.get(i)))
                return startIndex;

            if (pieceHelper.getOwnerOfPiece(list.get(i).getPiece()) == thePlayer)
                return i-1;

        }

        return startIndex;
    }

}
