package backend.util;

import backend.State;
import backend.classhelpers.BoardHelper;
import backend.classhelpers.GamePieceHelper;
import game.impl.BoardLocation;
import game.impl.Player;

import java.util.ArrayList;
import java.util.List;

public class LocationsToFlipCalculation {

    private BoardLocation location;
    private Player currentPlayer;

    private GamePieceHelper pieceHelper;
    private BoardHelper boardHelper;
    private BoardParser boardParser;

    private List<BoardLocation> locations = new ArrayList<BoardLocation>();

    public LocationsToFlipCalculation(Player thePlayer, GamePieceHelper pieceHelper, BoardParser boardParser, BoardHelper boardHelper){
        this.location = boardParser.getLocation();
        this.currentPlayer = thePlayer;

        this.boardParser = boardParser;

        this.pieceHelper = pieceHelper;
        this.boardHelper = boardHelper;
    }

    public LocationsToFlipCalculation(State state, Player currentPlayer, BoardParser parser){
        this(currentPlayer, new GamePieceHelper(state), parser, new BoardHelper(state));
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

        int backWardsIndex = getBackwardsUpdateIndex(partialList, locationIndex);
        for(int i = locationIndex - 1; i >= backWardsIndex; i--)
            locations.add(partialList.get(i));

        int forwardIndex = getForwardUpdateIndex(partialList, locationIndex);
        for(int i = locationIndex + 1; i <= forwardIndex; i++)
            locations.add(partialList.get(i));
    }

    private int getBackwardsUpdateIndex(List<BoardLocation> list, int startIndex){

        for(int i = startIndex-1; i >= 0; i-- ){
            if(boardHelper.isLocationEmpty(list.get(i)))
                return startIndex;

            if(pieceHelper.getOwnerOfPiece(list.get(i).getPiece()) == currentPlayer)
                return i+1;
        }


        return startIndex;
    }

    private int getForwardUpdateIndex(List<BoardLocation> list, int startIndex){

        for(int i = startIndex+1; i < list.size(); i++) {
            if (boardHelper.isLocationEmpty(list.get(i)))
                return startIndex;

            if (pieceHelper.getOwnerOfPiece(list.get(i).getPiece()) == currentPlayer)
                return i-1;

        }

        return startIndex;
    }

}
