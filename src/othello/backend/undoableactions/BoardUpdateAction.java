package othello.backend.undoableactions;

import othello.backend.State;
import othello.backend.classhelpers.GamePieceHelper;
import othello.backend.classhelpers.MoveHelper;
import game.impl.BoardLocation;
import game.impl.Player;

import java.util.ArrayList;
import java.util.List;


public class BoardUpdateAction implements UndoableAction {

    private Player currentPlayer;
    private BoardLocation location;

    private GamePieceHelper pieceHelper;
    private MoveHelper moveHelper;

    private List<BoardLocation> locationsFlipped = new ArrayList<BoardLocation>();

    public BoardUpdateAction(Player currentPlayer, BoardLocation location, GamePieceHelper pieceHelper, MoveHelper moveHelper){
        this.currentPlayer = currentPlayer;
        this.location = location;
        this.pieceHelper = pieceHelper;
        this.moveHelper = moveHelper;
    }

    public BoardUpdateAction(State state, BoardLocation location){
        this(state.getCurrentPlayer(), location, new GamePieceHelper(state), new MoveHelper(state));
    }

    @Override
    public void execute(){
        List<BoardLocation> locationsToFlip = moveHelper.getLocationsToFlipFromMove(location, currentPlayer);

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
