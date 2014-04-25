package backend.undoableactions;

import backend.State;
import game.impl.Move;

public class MoveAction implements UndoableAction{

    private State state;
    private Move move;

    private UndoableAction turnIncrement;
    private UndoableAction boardUpdate;

    public MoveAction(State state, Move move){
        this.state = state;
        this.move = move;

        this.turnIncrement = new TurnIncrementAction(state);
        this.boardUpdate = new BoardUpdateAction(state, move.getDestination());
    }

    @Override
    public void execute() {
        executeMove();
        boardUpdate.execute();
        turnIncrement.execute();
    }

    @Override
    public void undo() {
        turnIncrement.undo();
        boardUpdate.undo();
        undoMove();
    }

    @Override
    public String getName() {
        return "Move";
    }

    private void executeMove(){
        move.getDestination().setPiece(move.getPiece());
        state.getCurrentPlayer().getPieces().add(move.getPiece());
    }

    private void undoMove(){
        move.getDestination().setPiece(null);
        state.getCurrentPlayer().getPieces().remove(move.getPiece());
    }
}
