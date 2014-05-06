package backend.undoableactions;

import backend.util.LocationsToFlipCalculation;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;
import backend.util.GameRules;
import backend.State;

import java.util.ArrayList;
import java.util.List;


public class BoardUpdateAction implements UndoableAction {

    private State state;
    private List<Player> players;
    private BoardLocation location;
    private List<BoardLocation> locationsFlipped = new ArrayList<BoardLocation>();

    public BoardUpdateAction(State state, BoardLocation location){
        this.state = state;
        this.location = location;
        players = state.getPlayers();
    }

    @Override
    public void execute(){
        List<BoardLocation> locationsToFlip = new LocationsToFlipCalculation(state, location, state.getCurrentPlayer()).getLocationsToFlip();

        for(int i = 0; i < locationsToFlip.size(); i++){
            changeOwnerOfPieceAtLocation(locationsToFlip.get(i));
            locationsFlipped.add(locationsToFlip.get(i));
        }

    }

    @Override
    public void undo() {
        for(int i = locationsFlipped.size()-1; i > -1; i--) {
            changeOwnerOfPieceAtLocation(locationsFlipped.get(i));
            locationsFlipped.remove(i);
        }
    }

    @Override
    public String getName() {
        return "Board update";
    }


    private Player getOwnerOfPiece(GamePiece piece){
        if(GameRules.isPlayerOnePiece(piece))
            return players.get(0);

        return players.get(1);
    }

    private void changeOwnerOfPieceAtLocation(BoardLocation location){
        GamePiece piece = location.getPiece();
        Player newOwner, oldOwner = getOwnerOfPiece(piece);
        String newPieceId;

        if(oldOwner == players.get(0)){
            newOwner = players.get(1);
            newPieceId = "X";
        }
        else{
            newOwner = players.get(0);
            newPieceId = "O";
        }

        oldOwner.getPieces().remove(piece);
        piece = new GamePiece(newPieceId);
        newOwner.getPieces().add(piece);
        location.setPiece(piece);
    }

}
