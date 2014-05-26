package battleships.backend.classhelpers;

import battleships.backend.Settings;
import battleships.backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;

import java.util.ArrayList;
import java.util.List;

public class MoveHelper {

    private State state;
    private PieceHelper pieceHelper;
    private BoardHelper boardHelper;

    public MoveHelper(State state, PieceHelper pieceHelper, BoardHelper boardHelper){
        this.state = state;
        this.pieceHelper = pieceHelper;
        this.boardHelper = boardHelper;
    }


    public MoveHelper(State state){
        this(state, new PieceHelper(state), new BoardHelper(state));
    }


    public boolean hasShipOfLengthLeftToDeploy(int length){
        List<GamePiece> shipsDeployed;

        if(state.getPlayerInTurn().getName().equals(Settings.PLAYER_TWO_NAME))
            shipsDeployed = pieceHelper.findShipsOnLocations(boardHelper.getPlayerOneBoardHalf());
        else
            shipsDeployed = pieceHelper.findShipsOnLocations(boardHelper.getPlayerTwoBoardHalf());

        return Settings.PIECE_COUNT[length] > countShipsOfLength(length, shipsDeployed);
    }

    public int countShipsOfLength(int length, List<GamePiece> ships){

        int count = 0;

        for(int i = 0; i < ships.size(); i++){
            if(Integer.parseInt(""+ships.get(i).getId().charAt(2)) == length)
                count++;
        }


        return count;
    }

    public boolean isValidLengthOfShip(int length){
        return length > 1 && length < 6;
    }

    public boolean isDeployStartMove(){
        return getDeployStartLocation() == null;
    }

    public boolean doesLocationContainADeployPiece(BoardLocation location){
        return location.getPiece() != null && location.getPiece().getId().equals(Settings.DEPLOY_PIECE_ID);
    }

    public BoardLocation getDeployStartLocation(){
        List<BoardLocation> locations = state.getBoard().getLocations();

        for(int i = 0; i < locations.size(); i++){
            if(doesLocationContainADeployPiece(locations.get(i)))
                return locations.get(i);
        }

        return null;
    }


    public boolean doesAnyOfTheseLocationsHaveAShipOnThem(List<BoardLocation> locations){

        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).getPiece() != null && locations.get(i).getPiece().getId().charAt(0) == Settings.SHIP_ID)
                return true;
        }

        return false;
    }

    public boolean isLocationEmpty(BoardLocation location){
        return location.getPiece() == null;
    }

    public boolean isPieceDeployedDiagonally(Move move){

        BoardLocation endLocation = move.getDestination();
        BoardLocation startLocation = getDeployStartLocation();

        return !isLocationsInSameRow(startLocation, endLocation) && !isLocationsInSameColumn(startLocation, endLocation);
    }

    public boolean isLocationsInSameRow(BoardLocation locationOne, BoardLocation locationTwo){
        return locationOne.getId().charAt(0) == locationTwo.getId().charAt(0);
    }

    public boolean isLocationsInSameColumn(BoardLocation locationOne, BoardLocation locationTwo){
        return locationOne.getId().charAt(1) == locationTwo.getId().charAt(1);
    }

    public List<BoardLocation> getLocationsToDeployShipAtFromLocations(BoardLocation startLocation, BoardLocation endLocation){
        List<BoardLocation> extractedLocations;

        if(isLocationsInSameRow(startLocation, endLocation))
            extractedLocations = extractRowWithId(startLocation.getId().charAt(0));
        else
            extractedLocations = extractColumnWithId(startLocation.getId().substring(1));


        return extractLocationsBetween(startLocation, endLocation, extractedLocations);
    }

    public List<BoardLocation> extractRowWithId(char id){
        List<BoardLocation> locations = state.getBoard().getLocations();
        List<BoardLocation> extractedRow = new ArrayList<>();

        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).getId().charAt(0) == id)
                extractedRow.add(locations.get(i));
        }

        return extractedRow;
    }

    public List<BoardLocation> extractColumnWithId(String id){
        List<BoardLocation> locations = state.getBoard().getLocations();
        List<BoardLocation> extractedColumn = new ArrayList<>();

        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).getId().substring(1).equals(id))
                extractedColumn.add(locations.get(i));
        }

        return extractedColumn;
    }

    public List<BoardLocation> extractLocationsBetween(BoardLocation locationOne, BoardLocation locationTwo, List<BoardLocation> locations){
        List<BoardLocation> extractedLocations = new ArrayList<>();

        if(locationOne == locationTwo){
            extractedLocations.add(locationOne);
            return extractedLocations;
        }

        boolean shouldAdd = false;
        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).equals(locationOne) || locations.get(i).equals(locationTwo)){
                if(shouldAdd)
                    extractedLocations.add(locations.get(i));

                shouldAdd = !shouldAdd;
            }

            if(shouldAdd)
                extractedLocations.add(locations.get(i));
        }

        return extractedLocations;
    }

}
