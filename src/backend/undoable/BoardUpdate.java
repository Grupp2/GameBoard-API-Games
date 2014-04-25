package backend.undoable;

import backend.actions.LocationsToFlipCalculation;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;
import backend.util.BoardParser;
import backend.util.GameRules;
import backend.State;

import java.util.ArrayList;
import java.util.List;


public class BoardUpdate implements UndoableAction{

    private State state;
    private List<Player> players;
    private BoardLocation location;
    private List<BoardLocation> locationsFlipped = new ArrayList<BoardLocation>();

    public BoardUpdate(State state, BoardLocation location){
        this.state = state;
        this.location = location;
        players = state.getPlayers();
    }

    public void execute(){
        List<BoardLocation> locationsToFlip = new LocationsToFlipCalculation(state, location, state.getCurrentPlayer()).execute();

        for(int i = 0; i < locationsToFlip.size(); i++){
            changeOwnerOfPieceAtLocation(locationsToFlip.get(i));
            locationsFlipped.add(location);
        }

    }

    @Override
    public void undo() {
        for(int i = locationsFlipped.size(); i>= 0; i--) {
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
