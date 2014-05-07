package backend.undoableactions;

import backend.actionhelpers.GamePieceHelper;
import backend.actionhelpers.MoveHelper;
import backend.util.BoardParser;
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
    private GamePieceHelper pieceHelper;
    private List<BoardLocation> locationsFlipped = new ArrayList<BoardLocation>();
    private MoveHelper moveHelper;
    public BoardUpdateAction(State state, BoardLocation location, GamePieceHelper pieceHelper, MoveHelper moveHelper){
        this.state = state;
        this.location = location;
        players = state.getPlayers();
        this.pieceHelper = pieceHelper;
        this.moveHelper = moveHelper;
    }

    public BoardUpdateAction(State state, BoardLocation location){
        this(state, location, new GamePieceHelper(state), new MoveHelper(state));
    }

    @Override
    public void execute(){
        List<BoardLocation> locationsToFlip = moveHelper.getLocationsToFlipFromMove(location, state.getCurrentPlayer());

        for(int i = 0; i < locationsToFlip.size(); i++){
            pieceHelper.changeOwnerOfPiece(locationsToFlip.get(i).getPiece());
            locationsFlipped.add(locationsToFlip.get(i));
        }

    }

    @Override
    public void undo() {
        for(int i = locationsFlipped.size()-1; i > -1; i--) {
            pieceHelper.changeOwnerOfPiece(locationsFlipped.get(i).getPiece());
            locationsFlipped.remove(i);
        }
    }

    @Override
    public String getName() {
        return "Board update";
    }

}
